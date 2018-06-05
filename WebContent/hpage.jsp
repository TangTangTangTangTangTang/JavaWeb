<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html class="no-js" lang="en">
<html>
<head>
<title>贵州大学图书信息管理系统</title>
 <link rel="stylesheet" href="css/nav_menu3.css" type="text/css" media="all" />
</head>
<body>
<img src="photos/a.jpg" width="383" height="107"/>
<img src="photos/lo.png"/>
<font color="blue" size="3"> ${msg }</font>  
<a href="login.jsp">退出</a>
<div class="nav_menu3">
	<ul>
		<li class='nav-has-sub'><a href='#'>管理员信息</a>
			<ul>
				<li><a href='#'>信息查询</a></li>
				<li><a href='#'>信息修改</a></li>
			</ul>
		</li>
		
		<li class='nav-has-sub'><a href='QueryServlet1'>查询书籍</a>
	   </li>
	   
	   <li class='nav-has-sub'><a href='fill.jsp'>增加图书</a><!-- 能否用servlet? -->
		</li>
		
	   <li class='nav-has-sub'><a href='QueryServlet2'>删除图书</a>
		</li>
		
	   <li class='nav-has-sub'><a href='QueryServlet3'>修改图书信息</a>
		</li>
		
		<li class='nav-has-sub'><a href='#'>借阅查询</a>
		  <ul>
		     <li><a href='#'>不告诉你</a></li>
		     <li><a href='#'>就不告诉你</a></li>	
		  </ul>  
	   </li>
	   
	   <li class='nav-has-sub'><a href='#'>公告发布</a>
			<ul>
				<li><a href='#'>上级通知</a></li>
				<li><a href='#'>新闻</a></li>
			</ul>
		</li>
	   
	</ul>
</div>
</body>
</html>