package core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FowardServlet 수행 시작");
		//response.sendRedirect("/sedu/first.html");
		//response.sendRedirect("/edu/first.html");
		response.sendRedirect("http://www.naver.com");	
		System.out.println("FowardServlet 수행 종료");
	}
}
