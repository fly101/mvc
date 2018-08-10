package fun.westory.mvc.shoppingcart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProcessStep1Servlet",urlPatterns = "/processStep1")
public class ProcessStep1Servlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//1. 获取选中的图书的信息
		String [] books = request.getParameterValues("book");
		//2. 把图书信息放入到 HttpSession 中
		request.getSession().setAttribute("books", books);
		
		//2. 重定向页面到 shoppingcart/step-2.jsp
		System.out.println(request.getContextPath() + "/shoppingcart/step-2.jsp");
		response.sendRedirect(request.getContextPath() + "/shoppingcart/step-2.jsp");
	}

}
