package javabean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javabean.Book;
public class Bookdao {
	public Connection getConnection() {
		Connection conn=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/zyts","root","1997");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return conn;
	}
	
	public void delete(int[]ids) {
		Connection conn=getConnection();
		
		try {
			String sql = "delete from tb_student_del where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int id : ids) {
				ps.setInt(1, id);
				ps.addBatch();
			}
			ps.executeBatch();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				// ¹Ø±ÕConnection
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
              }
		}
}
	
	public List<Book> find(int page){
		List<Book> list = new ArrayList<Book>();
		Connection conn=getConnection();
		String sql="select*from tbb_table order by id desc limit ?,?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*Book.PAGE_SIZE);
			ps.setInt(2, Book.PAGE_SIZE);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Book book=new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString ("name"));
				book.setPrice(rs.getDouble ("price"));
				book.setBookCount(rs.getInt ("bookCount"));
				book.setAuthor(rs.getString ("author"));
				list.add(book);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return list;	
	}
	
	public int findCount() {
		int count=0;
		Connection conn=getConnection();
		String sql="select count(*) from tbb_table";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				count= rs.getInt(1);
			}
				rs.close();
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
			
	}
}
