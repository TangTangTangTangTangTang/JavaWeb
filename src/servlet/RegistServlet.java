package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.InforDao;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 request.setCharacterEncoding("utf-8"); 
		  response.setContentType("text/html;charset=utf-8"); 
//		  response.setCharacterEncoding("utf-8"); 
//		PrintWriter out = response.getWriter();
		// 设置request的编码
		// 获取姓名
		String accountN = request.getParameter("accountN");
		// 获取性别
		String pwd = request.getParameter("pwd");
		// 获取年龄
		String name = request.getParameter("name");
		// 获取班级
		String tel = request.getParameter("tel");
		
		
       /*if(!password.equals(rpsw)){  
           request.setAttribute("msg", "两次输入的密码不同");  
           request.getRequestDispatcher("regist.jsp").forward(request, response);  
           return;  
       }  */
       InforDao I = new InforDao();  
       I.saveInfor(accountN,pwd,name,tel);
       request.setAttribute("msg", "恭喜："+accountN+"，注册成功");  
       request.getRequestDispatcher("login.jsp").forward(request, response);  
 
   }  
}
