package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getpost")
public class GetPostServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>요청 방식 : "+request.getMethod()+"</h2>");
		out.print("<h2>Query 문자열 : "+
		                  request.getParameter("name")+"</h2>");
		out.close();
		System.out.println("GET 방식 수행");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");	//post방식은 꼭 setCharacterEncoding을 미리 호출하고 수행시켜야한다!! 전달된 query를 다시 디코딩하면서 자바가 인식하는 유니코드로 바꿔줘야 하기 때문. 
		out.print("<h2>요청 방식 : "+request.getMethod()+"</h2>");
		out.print("<h2>Query 문자열 : "+request.getParameter("name")+"</h2>");
		out.close();
		System.out.println("POST 방식 수행");
	}
}



