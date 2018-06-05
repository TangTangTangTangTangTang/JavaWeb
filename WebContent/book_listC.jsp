<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="javabean.Book"%>
<html>
<head>
<title>修改数量</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	td{font-size: 12px;}
	h2{margin: 0px}
</style>
<script type="text/javascript">
      function check(form){
    	  with(form){
    		  if(bookCount.value == ""){
    			  alert("请输入更新数量")
    			  return false;
    		  }
    		  return true;
    	  }
      }

      function change() {
    		var msg = "确认修改？";
    		if (confirm(msg)==true){
    		return true;
    		}else{
    		return false;
    		}
    		}
</script>
</head>
<body>
	<table align="center" width="550" border="1" height="180" bordercolor="white" bgcolor="" cellpadding="1" cellspacing="1">
		<tr bgcolor="white">
			<td align="center" colspan="6">
				<h2>所有图书信息</h2>
			</td>
		</tr>
		<tr align="center" bgcolor="#e1ffc1" >
			<td><b>ID</b></td>
			<td><b>图书名称</b></td>
			<td><b>价格</b></td>
			<td><b>数量</b></td>
			<td><b>作者</b></td>
			<td><b>修改对应列相应数据</b></td>
			
		</tr>
			<%
				// 获取图书信息集合
					List<Book> list = (List<Book>)request.getAttribute("list");
					// 判断集合是否有效
					if(list == null || list.size() < 1){
						out.print("没有数据！");
					}else{
						// 遍历图书集合中的数据
						for(Book book : list){
			%>
				<tr align="center" bgcolor="white">
					<td><%=book.getId()%></td>
					<td><%=book.getName()%></td>
					<td><%=book.getPrice()%></td>
					<td><%=book.getBookCount()%></td>
					<td><%=book.getAuthor()%></td>
					<td>
					     <form action="UpdataServlet" method="post" onsubmit="return check(this);">
					     <input type="hidden" name="id" value="<%=book.getId()%>">
					     <input type="text" name="name" size="10" value="<%=book.getName()%>"  >
					     <input type="text" name="price" size="3"  value="<%=book.getPrice()%>"  >
					     <input type="text" name="bookCount" size="3"  value="<%=book.getBookCount()%>"  >
					     <input type="text" name="author" size="10"  value="<%=book.getAuthor()%>"  >
					     <input type="submit" value="修改" size="3" onclick="javascript:return change();" >			     
					     </form>
					</td>
				</tr>
			<%
					}
				}
			%>
			<tr>
			    <td align="center" colspan="5">  			    
			        ${bar }
			    <td>
			</tr>
	</table>
</body>
</html>