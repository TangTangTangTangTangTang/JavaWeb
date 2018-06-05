package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;


/**
 * Servlet implementation class UpdataServlet
 */
@WebServlet("/UpdataServlet")
public class UpdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");  
		doGet(request, response);
		int id =Integer.valueOf(request.getParameter("id"));
		String name =request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		int bookCount =Integer.valueOf(request.getParameter("bookCount"));
		String author =request.getParameter("author");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/zyts", "root", "1997");
				String sql="update tbb_table set name=?,price=?,bookCount=?,author=? where id=?";/*bookCount中的C是大写还是小写？
*/				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, name); 
				ps.setDouble(2, price);
				ps.setInt(3, bookCount );
				ps.setString(4, author);
				ps.setInt(5, id);
				
				ps.executeUpdate();
				ps.close();
				conn.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		response.sendRedirect("QueryServlet3");		
		
	}

}
