package servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DealDeleteServlet
 */
@WebServlet("/DealDeleteServlet")
public class DealDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int id =Integer.valueOf(request.getParameter("id"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zyts?useUnicode=true&characterEncoding=UTF-8","root","1997");	   
				   String sql="select * from tbb_table where id=?";
				   PreparedStatement ps=conn.prepareStatement(sql);
				   ps.setInt(1,id);
				   ResultSet rs= ps.executeQuery();				   				  
				   while(rs.next()) {
					   id=rs.getInt("id");
					   String name=rs.getString ("name");
					   Double price=rs.getDouble ("price");
					   int bookCount=rs.getInt ("bookCount");
					   String author=rs.getString ("author");
					   System.out.print(id);

					   Class.forName("com.mysql.jdbc.Driver");
					   Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/zyts?useUnicode=true&characterEncoding=UTF-8","root","1997");
				   String sqll="insert into tbb_table1(name,price,bookCount,author,id) values(?,?,?,?,?)";
				   PreparedStatement ps1=conn1.prepareStatement(sqll);

				   ps1.setInt(1,id);
				   ps1.setString(1,name);
				   ps1.setDouble(2,price);
				   ps1.setInt(3,bookCount);
				   ps1.setString(4,author);
				   ps1.setInt(5,id);
				   int row = ps1.executeUpdate();
				   if(row>0) {
					   request.setAttribute("id", id);
					   request.getRequestDispatcher("DeleteServlet").forward(request, response);
					   ps.close();
						conn.close();
						ps1.close();
						conn1.close();
					   return;  
					   }
				   }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
