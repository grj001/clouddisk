<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.Map" %>
<jsp:include page="/top.jsp"></jsp:include>
<script type="text/javascript" src="js/echarts.min.js"></script>

<div id="main" class="col-sm-6" style="height:400px;"></div>
<div id="chart2" class="col-sm-6" style="height:400px;"></div>
<%
List<Map> staticResult = (List<Map>)request.getAttribute("staticResult");
Map result = staticResult.get(0);
%>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    // 指定图表的配置项和数据
    myChart.title = '用户文件数量统计';

	option = {
	    color: ['#3398DB'],
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            data : ['文本文件','视频文件','图片文件','代码文件','其他'],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'直接访问',
	            type:'bar',
	            barWidth: '60%',
	            data:[<%=result.get("doc_number")%>, <%=result.get("video_number")%>, <%=result.get("pic_number")%>
	            , <%=result.get("code_number")%>, <%=result.get("other_number")%>]
	        }
	    ]
	};
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    
    
    var pieChart = echarts.init(document.getElementById('chart2'));
    option2 = {
    	    title : {
    	        text: '某站点用户访问来源',
    	        subtext: '纯属虚构',
    	        x:'center'
    	    },
    	    tooltip : {
    	        trigger: 'item',
    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
    	    },
    	    legend: {
    	        orient: 'vertical',
    	        left: 'left',
    	        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
    	    },
    	    series : [
    	        {
    	            name: '访问来源',
    	            type: 'pie',
    	            radius : '55%',
    	            center: ['50%', '60%'],
    	            data:[
    	                {value:335, name:'直接访问'},
    	                {value:310, name:'邮件营销'},
    	                {value:234, name:'联盟广告'},
    	                {value:135, name:'视频广告'},
    	                {value:1548, name:'搜索引擎'}
    	            ],
    	            itemStyle: {
    	                emphasis: {
    	                    shadowBlur: 10,
    	                    shadowOffsetX: 0,
    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    	                }
    	            }
    	        }
    	    ]
    	};
    pieChart.setOption(option2);
</script>

<jsp:include page="/bottom.jsp"></jsp:include>