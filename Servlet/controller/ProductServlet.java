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
import model.vo.ProductVO;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		HttpSession session = request.getSession();

		if (session.getAttribute("cnt") == null)
			session.setAttribute("cnt", new ProductVO());	
		ProductVO vo =(ProductVO)session.getAttribute("cnt");

			switch (pid) {
			case "p001":
				vo.setApp(1);
				break;
			case "p002":
				vo.setBan(1);
				break;
			case "p003":
				vo.setBong(1);
				break;
			}
		request.setAttribute("product", vo);
		RequestDispatcher rd1 = request.getRequestDispatcher("/jspexam/productView.jsp");
		rd1.forward(request, response);
	}
}
