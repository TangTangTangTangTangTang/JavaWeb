package javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InforDao {

	public void saveInfor(String accountN,String pwd,String name,String tel){
		Connection conn =null;  
        PreparedStatement ps =null;  
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/zyts","root","1997"); 
				String sql = "insert into loginfor value(?,?,?,?)";
				 ps = conn.prepareStatement(sql);
				// 对SQL语句中的第1个参数赋值
				ps.setString(1, accountN);
				// 对SQL语句中的第2个参数赋值
				ps.setString(2, pwd);
				// 对SQL语句中的第3个参数赋值
				ps.setString(3, name);
				// 对SQL语句中的第4个参数赋值
				ps.setString(4, tel);
			    ps.executeUpdate();
				// 关闭PreparedStatement
				
			} catch (ClassNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }finally {  
	            try {  
	                if(ps!=null)ps.close();  
	                if(conn!=null)conn.close();  
	                }   
	            catch (SQLException e) {          
	                                    }  
	        }  
	    }  
	    //单独测试使用  
	    //public static void main(String[] args) {  
	        //String psw =new UserDao().findUsername("345");  
	        //System.out.println(psw);  
	        //UserDao u = new UserDao();  
	        //u.addUser("345", "345");  
	    //}  

	public String findAccountN(String accountN) {
		// TODO Auto-generated method stub
		String pwd = null;  
        Connection conn =null;  
        PreparedStatement pstmt =null;  
        ResultSet rs = null;  
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/zyts","root","1997");
				String sql = "select * from loginfor where accountN=?";  
	            pstmt = conn.prepareStatement(sql);  
	            pstmt.setString(1, accountN);  
	            rs = pstmt.executeQuery(); 
	            if(rs==null){  
	                return null;  
	            }  
	            if(rs.next()){  
	            	pwd=rs.getString("pwd");  
	            }else{  
	            	pwd=null;  
	            }  
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return pwd;
	}
	      
}
