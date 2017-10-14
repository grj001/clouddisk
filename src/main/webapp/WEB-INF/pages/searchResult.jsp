<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.zhiyou.clouddisk.model.FileIndex,com.github.pagehelper.Page" %>
<jsp:include page="/top.jsp"></jsp:include>

<div class="panel panel-warning">
  <div class="panel-heading">
    <form class="form-inline" action="searchFiles" method="post">
    	<label>查询条件：文件名称</label>
    	<input class="form-control" name="keyWord" type="text" value="${keyWord}">
    	<input type="hidden" name="pageNum">
    	<button type="submit" class="btn btn-default">搜索</button>
    </form>
  </div>
  <div class="panel-body">
    <table class="table table-bordered table-striped table-hover">
       <thead>
	   <tr>
	       <th>ID</th>
	       <th>名称</th>
	       <th>路径</th>
	       <th>是否文件</th>
	   </tr>
	   </thead>
<%
Page<FileIndex> result = (Page<FileIndex>)request.getAttribute("result");
int nowPage = result.getPageNum();
if(result!=null){
	for(FileIndex r:result){

%>
		<tr>
			<td><%=r.getFileIndexId() %></td>
			<td><%=r.getName() %></td>
			<td><%=r.getPath() %></td>
			<td><%=r.getIsFile() %></td>
		</tr>
<%
	}
}
%>
	</table>
	<nav aria-label="Page navigation">
	  <ul class="pagination">
	    <li>
	      <a href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
<%
//当前页前面两个页码小于2个
if(result.getPageNum()<3){
	for(int i=1;i<=5&&i<=result.getPages();i++){
%>
		<li class="<%=result.getPageNum()==i?"active":"" %>"><a href="#" onclick="pageTo('<%=i %>')"><%=i %></a></li>
<%
	}
}else if((result.getPages()-result.getPageNum())<=2){
	//当前页后面两个页码小于2个
	for(long i=((result.getPages()-4)<=1?1:(result.getPages()-4));i<=result.getPages();i++){
%>
		<li class="<%=result.getPageNum()==i?"active":"" %>"><a href="#" onclick="pageTo('<%=i %>')"><%=i %></a></li>
<%
	}
}else{
	for(int i=result.getPageNum()-2;i<=result.getPageNum()+2;i++){
%>
		<li class="<%=result.getPageNum()==i?"active":"" %>"><a href="#" onclick="pageTo('<%=i %>')"><%=i %></a></li>
<%
	}
}
%>
	    <li>
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
  </div>
</div>
<script type="text/javascript">
function pageTo(pageNum){
	$("input[name='pageNum']").val(pageNum);
	$("form[action='searchFiles']").submit();
}
</script>
<jsp:include page="/bottom.jsp"></jsp:include>