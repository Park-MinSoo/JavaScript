package controller;

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
import javax.servlet.http.HttpSession;
import model.vo.LottoVO;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("number1");
		String num2 = request.getParameter("number2");
		String oper = request.getParameter("oper");
		int num1fn = Integer.parseInt(num1);
		int num2fn = Integer.parseInt(num2);
		int result=0;
	
		if(oper.equals("/") && num2fn == 0) {
			String error = "?Çò?àó?Öà ?ó∞?Ç∞?ãú ?ëê Î≤àÏß∏ ?à´?ûê?äî 0?ùº ?àò ?óÜ?äµ?ãà?ã§!!";
			request.setAttribute("error", error);
			RequestDispatcher rd1 = request.getRequestDispatcher("/jspexam/errorResult.jsp");	
			rd1.forward(request, response);				
		}
		else {
		switch(oper){
		case "+":
			result = num1fn + num2fn;
			break;
		case "-":
			result = num1fn - num2fn;
			break;
		case "*":
			result = num1fn * num2fn;
			break;	
		case "/":
			result = num1fn / num2fn;
			break;	
		}
		request.setAttribute("calcresult", result);
		RequestDispatcher rd2 = request.getRequestDispatcher("/jspexam/calcResult.jsp");	
		rd2.forward(request, response);	
		}
	}
}



