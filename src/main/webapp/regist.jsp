<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="js/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/jumbotron-narrow.css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container">
      <div class="header clearfix">
        <h3 class="text-muted">注册新用户</h3>
      </div>

      <div class="jumbotron">
        <form action="regist" method="post" onsubmit="return checkPwd();">
        	<input name="userId" type="hidden">
        	<div class="col-sm-12">
        	<div class="col-sm-4">
	        	<div class="form-group" id="accountNoDiv">
	        		<label>登录账号</label>
	        		<input name="accountNo" type="text" class="form-control">
	        	</div>
        	</div>
        	<div class="col-sm-4">
        	<div class="form-group">
        		<label>密码</label>
        		<input name="password" type="password" class="form-control">
        	</div>
        	</div>
        	<div class="col-sm-4">
        	<div class="form-group">
        		<label>确认密码</label>
        		<input name="passwordc" type="password" class="form-control">
        	</div>
        	</div>
        	</div>
        	<div class="col-sm-12">
	        	<div class="col-sm-5">
		        	<div class="form-group">
		        		<label>用户名</label>
		        		<input name="userName" type="text" class="form-control">
		        	</div>
	        	</div>
	        	<div class="col-sm-2">
		        	<div class="form-group">
		        		<label>性别</label>
		        		<select name="gender" class="form-control">
		        			<option value="m">男</option>
		        			<option value="f">女</option>
		        		</select>
		        	</div>
	        	</div>
	        	<div class="col-sm-5">
		        	<div class="form-group">
		        		<label>出生日期</label>
		        		<input name="birthday" type="text" class="form-control">
		        	</div>
	        	</div>
        	</div>
        	<div class="col-sm-12">
        	<div class="col-sm-6">
        	<div class="form-group">
        		<label>email</label>
        		<input name="email" type="text" class="form-control">
        	</div>
        	</div>
        	<div class="col-sm-6">
        	<div class="form-group">
        		<label>电话号码</label>
        		<input name="phoneNo" type="text" class="form-control">
        	</div>
        	</div>
        	</div>
        	<button class="btn btn-primary">提交</button>
        </form>
      </div>
      <footer class="footer">
        <p>© 2016 Company, Inc.</p>
      </footer>
    </div> <!-- /container -->
<script type="text/javascript">
function checkPwd(){
	var accountNo = $("input[name='accountNo']").val();
	var pwd = $("input[name='password']").val();
	if(accountNo==""||pwd==""){
		alert("请输入账号和密码再进行保存。");
		return false;
	}
	var pwdc = $("input[name='passwordc']").val();
	if(pwd==pwdc){
		return true;
	}else{
		alert("两次输入密码不一致，请重新输入！");
		$("input[name='password']").val("");
		$("input[name='passwordc']").val("");
		return false;
	}
}
</script>
</body>
</html>