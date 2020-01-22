package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("number");
		int rand = (int)(Math.random()*6)+1;
		int numfn = Integer.parseInt(num);
		System.out.println("전달된 값 : " + numfn + ", 추출된 값 : " + rand);
		
		if(numfn == rand) {
			RequestDispatcher rd1 = request.getRequestDispatcher("/jspexam/success.jsp");	
			rd1.forward(request, response);
		}
		else {
			RequestDispatcher rd2 = request.getRequestDispatcher("/jspexam/fail.jsp");	
			rd2.forward(request, response);
		}
	}
}



