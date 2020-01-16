package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myfirst")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");	
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		LocalDate currentDate = LocalDate.now();
		int day = currentDate.getDayOfWeek().getValue();
		
		String dd = " ";

		switch (day) {
		case 0:
			dd = "일";
			break;
		case 1:
			dd = "월";
			break;
		case 2:
			dd = "화";
			break;
		case 3:
			dd = "수";
			break;
		case 4:
			dd = "목";
			break;
		case 5:
			dd = "금";
			break;
		case 6:
			dd = "토";
			break;
		}
		
		if(name == null) {
			out.print("<h2>" + "GUEST" + "님 반가워요.. 오늘은 " + dd + "요일입니다!!" + "</h2>");
		}
		else {
			out.print("<h2>" + name + "님 반가워요.. 오늘은 " + dd + "요일입니다!!" + "</h2>");
		}
		
		out.close();
	}
}
