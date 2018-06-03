package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javabean.InforDao;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
        String accountN = request.getParameter("accountN");  
        String password = request.getParameter("pwd");
        String pwd =new InforDao().findAccountN(accountN);
        /*String verifyc  = request.getParameter("verifycode");
        String svc =(String) request.getSession().getAttribute("sessionverify");
        if(!svc.equalsIgnoreCase(verifyc)){  
            request.setAttribute("msg", "验证码错误！");  
            request.getRequestDispatcher("login.jsp").forward(request, response);  
            return;  
        }  */
        if(pwd ==null){  
            request.setAttribute("msg", "没有这个用户！");  
            request.getRequestDispatcher("login.jsp").forward(request, response);  
            return;  
        }  
        if(pwd!=null&&!pwd.equals(password)){  
            request.setAttribute("msg", "密码错误请重新输入！");  
            request.getRequestDispatcher("login.jsp").forward(request, response);  
            return;  
        }  
        if(pwd.equals(password)){  
            request.setAttribute("msg", "用户："+accountN+",欢迎访问"); //是否可以使主要页知道谁来了 
            request.getRequestDispatcher("hpage.jsp").forward(request, response);  
        }  
          
	}
}

