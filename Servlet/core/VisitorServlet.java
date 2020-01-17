package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8"); 
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		out.print("<h2>"+ request.getParameter("gname")+"님이"+ currentDate.format(formatter) +"에 남긴 글입니다.</h2>");
		out.print("<hr>");
		out.print("<h2>내용 : "+request.getParameter("etc")+"</h2>");
		out.print("<a href='/sedu/html/visitorForm.html'>입력화면으로</a>");
		out.close();
	}
}



