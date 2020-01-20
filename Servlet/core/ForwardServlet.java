package core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FowardServlet 수행 시작");
		RequestDispatcher rd = request.getRequestDispatcher("/first.html");	
		// Context Path 이후 부분을 줘야함.(Context Path = /sedu 이후 부분) 무조건 (sedu) 붙이기 때문이다. 즉, 동일한 서버의 동일 웹 어플리케이션에 존재하는 대상만 가능 
		rd.forward(request, response);
		System.out.println("FowardServlet 수행 종료");
	}
}
