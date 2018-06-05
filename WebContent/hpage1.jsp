<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贵州大学图书信息管理系统</title>

<style>
#header {
   background-color:black;
   color:red;
   padding:5px;
   text-align:center;
}
#nav {
   line-height:45px;
   background-color:#eeeeee;
   height:530px;
   width:100px;
   float:left;
   padding:15px;
}
#section {
   width:550px;
   float:left;
   paading:10px;
   text-align:center;
}
#footer{
   background-color:black
   color:white;
   clear:both;
   text-align:center;
   padding:5px
}
</style>
</head>
<body>
<div id="header">
<h1>贵州大学图书信息管理系统</h1>
</div>

<div id="nav">

<a href="">管理员信息</a><br/>
<a href="QueryServlet1">查询书籍</a><br/>
<a href="fill.jsp">增加图书</a><br/>
<a href="QueryServlet2">删除图书</a><br/>
<a href="QueryServlet3">修改图书信息</a><br/>

借阅查询<br/>
公告发布<br/>
</div>

<div id="section">
<br/><br/><br/><br/><br/><br/><br/>
欢迎来到贵州图书信息管理系统！
</div>

<div id="footer">
powered by TLC
</div>
</body>
</html>