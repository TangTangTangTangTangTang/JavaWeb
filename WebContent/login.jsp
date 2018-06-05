<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {background-image:url(photos/bj.jpg);
background-size:cover;
}
</style> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到贵州大学图书信息管理系统！</title>
<script type="text/javascript">
	function check(form){
		with(form){
			if(accountN.value == ""){
				alert("账户不能为空");
				return false;
			}
			if(pwd.value == ""){
				alert("密码不能为空");
				return false;
			}
		}
	}
	
    /* function change(){  
        var img =document.getElementById("verify");  
        img.src="VerifyCodeServlet?a="+new Date().getTime();  
    }   */

</script>

</head>
<body >
  <center>  
<h1>欢迎登陆</h1>  
<form action="LoginServlet" method="post" onsubmit="return check(this); ">  

    <table valign="center",align="center">  
    <br/><br/><br/><br/><br/><br/><br/><br/>
    <tr> 
    <td width="66" align="right"><font size="3">账户名：</font></td><td colspan="2"><input type="text" name="accountN" style="width:200;height:25;"/></td>  
    </tr>  
    <tr>  
    <td align="right"><font size="3">密　码：</font></td><td colspan="2"><input type="password" name="pwd"  style="width:200;height:25;"/></td>  
    </tr>  
    <!-- <tr>  
    <td align="right"><font size="3">验证码：</font></td>  
    <td width="108" valign="middle"><input type="text" name="verifycode" style="width:100;height:25;"/></td>  
    <td width="90" valign="middle"><a href="javascript:change()"><img src="VerifyCodeServlet" id="verify" border="0"></a></td>  
    </tr>   -->
    <tr><td colspan="3" align="center"><input type="submit" value="登录" style="width:130;height:30;"/></td></tr>  
    </table>  
    </form>  
    <a href="regist.jsp"><font size="2" ><i>没有帐号？点击注册</i></font></a>  
    
    <font color="red" size="3"> ${msg }</font>  
</center>  
</body>
</html>