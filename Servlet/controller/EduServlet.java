package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edu1")
public class EduServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String score = request.getParameter("gscore");
		int scorefn = Integer.parseInt(score);
		
		if(scorefn >= 90) {
			RequestDispatcher rd1 = request.getRequestDispatcher("/jspexam/gradeA.jsp");	
			rd1.forward(request, response);	
			}
		else if(scorefn >=80 && scorefn <=89) {
			RequestDispatcher rd2 = request.getRequestDispatcher("/jspexam/gradeB.jsp");	
			rd2.forward(request, response);
			}
		else if(scorefn >=70 && scorefn <=79) {
			RequestDispatcher rd3 = request.getRequestDispatcher("/jspexam/gradeC.jsp");	
			rd3.forward(request, response);
			}
		else {
			RequestDispatcher rd4 = request.getRequestDispatcher("/jspexam/gradeD.jsp");	
			rd4.forward(request, response);		
		}

	}
}

