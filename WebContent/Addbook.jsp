<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书信息</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="book" class="javabean.Book"></jsp:useBean>
<jsp:setProperty property="*" name="book"/>
<%
   try{
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/zyts?useUnicode=true&characterEncoding=UTF-8","root","1997");
	   String sql="insert into tbb_table(name,price,bookCount,author) values(?,?,?,?)";
	   PreparedStatement ps=conn.prepareStatement(sql);
	   ps.setString(1,book.getName());
	   ps.setDouble(2,book.getPrice());
	   ps.setInt(3,book.getBookCount());
	   ps.setString(4,book.getAuthor());
	   int row = ps.executeUpdate();
	   if(row>0){
		   out.print("成功添加了"+row+"条图书信息");
	   }
	   ps.close();
	   conn.close();
   }catch(Exception e){
	   out.print("图书信息添加失败");
	   e.printStackTrace();
   }
%>
<br>
<a href="hpage.jsp">返回</a>
</body>
</html>