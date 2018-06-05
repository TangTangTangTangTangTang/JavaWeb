<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {background-image:url(photos/bj.jpg);
background-size:cover;
}
</style> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript">
	function check(form){
		with(form){
			if(accountN.value == ""){
				alert("请输入账户名！");
				return false;
			}
			if(pwd.value == ""){
				alert("请设置密码！");
				return false;
			}
			if(rpwd.value == ""){
				alert("请再次输入密码！");
				return false;
			}			
			if(name.value == ""){
				alert("请输入姓名！");
				return false;
			}
			if(tel.value == ""){
				alert("请输入手机号！");
				return false;
			}
			if(rpwd.value != pwd.value){
				alert("前后密码不一致！");
				return false;
			}
			return true;
		}
	}
</script>
</head>
<br/><br/><br/><br/><br/><br/><br/><br/>
<body>
	<form action="RegistServlet" method="post" onsubmit="return check(this);">
		<table align="center" width="450">
			<tr>
				<td align="center" colspan="2">
				
					<h2>欢迎注册</h2>
					<hr>
				</td>
			</tr>
			<tr>
				<td align="right">账户名：</td> 
				<td><input type="text" name="accountN" /></td>
			</tr>
			<tr>
				<td align="right">密　码：</td>
				<td><input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td align="right">确认密码：</td>
				<td><input type="password" name="rpwd" /></td>
			</tr>
			<tr>
				<td align="right">姓　名：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td align="right">手机号：</td>
				<td><input type="text" name="tel" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="注　册">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>