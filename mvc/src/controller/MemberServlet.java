package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.MemberVO;

@WebServlet("/member1")
public class MemberServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("gname");
		String number = request.getParameter("gnumber");
		String account = request.getParameter("gaccount");
		String pwd = request.getParameter("gpwd");

		MemberVO vo = new MemberVO();

		if(name.equals("")) {
			name = "?óÜ?ùå";
		}
		if(number.equals("")) {
			number = "?óÜ?ùå";
		}
		if(account.equals("")) {
			account = "?óÜ?ùå";
		}
		if(pwd.equals("")) {
			pwd = "?óÜ?ùå";
		}
		
		vo.setName(name);
		vo.setPhonenum(number);		
		vo.setAccount(account);		
		vo.setPwd(pwd);		
				
		
		
		request.setAttribute("member", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/jspexam/memberView.jsp");	
		rd.forward(request, response);	
	}
}

