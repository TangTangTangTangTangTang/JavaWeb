package servlet;
import javabean.Bookdao;
import javabean.Book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * Servlet implementation class QueryServlet1
 */
@WebServlet("/QueryServlet1")
public class QueryServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int currPage = 1;
		if(request.getParameter("page") != null){
			currPage = Integer.parseInt(request.getParameter("page"));
		}
		// ʵ����ProductDao
		Bookdao dao = new Bookdao();
		// ��ѯ������Ʒ��Ϣ
		List<Book> list = dao.find(currPage);//����Ҫ���ҵ�ҳ������list
		// ��list���õ�request֮��
		request.setAttribute("list", list);
		// ��ҳ��
		int pages ;
		// ��ѯ�ܼ�¼��
		int count = dao.findCount();
		// ������ҳ��
		if(count%Book.PAGE_SIZE == 0){
			// ����ҳ����ֵ
			pages = count/Book.PAGE_SIZE;
		}else{
			// ����ҳ����ֵ
			pages = count/Book.PAGE_SIZE + 1;
		}
		// ʵ����StringBuffer
		StringBuffer sb = new StringBuffer();
		// ͨ��ѭ��������ҳ��
		for(int i=1; i <= pages; i++){
			// �ж��Ƿ�Ϊ��ǰҳ
			if(i == currPage){
				// ������ҳ��
				sb.append("��" + i + "��");
			}else{
				// ������ҳ��
				sb.append("<a href='QueryServlet1?page=" + i + "'>" + i + "</a>");
			}
			// ������ҳ��
			sb.append("��");
		}
		// ����ҳ�����ַ������õ�request֮��
		request.setAttribute("bar", sb.toString());
		// ת����book_list.jspҳ��
		    request.getRequestDispatcher("book_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
