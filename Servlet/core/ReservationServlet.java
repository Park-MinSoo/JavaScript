package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8"); 
		String reservateDay = request.getParameter("gdate");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");		
		
		out.print("<h1>"+ request.getParameter("gname")+"님의 예약내용</h1>");
		out.print("<hr>");
		out.print("<ul>");
		out.print("<li>룸 : "+ request.getParameter("groom")+"</li>");
		out.print("<li>추가 요청 사항: "+request.getParameter("sub")+"</li>");
		out.print("<li>예약날짜 : "+ LocalDate.parse(reservateDay).format(formatter)+"</li>");
		out.print("</ul>");
		out.print("예약<a href='/sedu/html/reservation.html'>입력화면으로</a>");
		out.close();
	}
}



