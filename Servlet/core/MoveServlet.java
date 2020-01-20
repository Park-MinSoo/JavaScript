package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html; charset=utf-8");
	String action = request.getParameter("action");
	PrintWriter out = response.getWriter();
	if(action == null) {// 항상 null값 이 존재하면 null부터 체크해주는것이 좋다.
		out.print("<h2>전달된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니당..</h2>");
	}
	else if(action.equals("naver")) {	// 자바는 문자열을 비교할때 반드시 equals를 사용해야 한다.
		response.sendRedirect("http://www.naver.com/");	
	}
	else if(action.equals("daum")) {
		response.sendRedirect("http://www.daum.net/");	
	}
	else if(action.equals("google")) {
		response.sendRedirect("http://google.com/");	
	}
	else  {
	}
  }
}
