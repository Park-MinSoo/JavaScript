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

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("number");
		int rand = (int)(Math.random()*6)+1;
		int numfn = Integer.parseInt(num);
		System.out.println("? ?¬? κ°? : " + numfn + ", μΆμΆ? κ°? : " + rand);
		HttpSession session = request.getSession();

		if(session.getAttribute("cnt") == null)
			session.setAttribute("cnt", new int[1]);
		int[] session_v = (int[])session.getAttribute("cnt");
		session_v[0] += 1;
		LottoVO vo = new LottoVO();
		java.time.LocalDateTime ctime = java.time.LocalDateTime.now();
		java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("hh? mmλΆ?");			

		if(session_v[0]>=4) {
			vo.setMsg("? ?΄? ?λͺ¨ν  ? ??΄?....? ?  λΈλΌ?°??λ₯? ?¬κΈ°λ? ?? ?λͺ¨ν?Έ?");
		}
		else {
			if(numfn == rand) {
				vo.setMsg(ctime.format(formatter) + "? ?Ήμ²?!!! μΆμΉ΄μΆμΉ΄~");		
				vo.setImgUrl("/edu/images/sun.png");
				session_v[0]=4;
			}
			else {
				vo.setMsg(ctime.format(formatter) + "? ?Ήμ²? ?€?¨!! ??½??½~");		
				vo.setImgUrl("/edu/images/sad.gif");				
				vo.setLinkDisplay(true);
			}						
		}
		request.setAttribute("lotto", vo);
		RequestDispatcher rd1 = request.getRequestDispatcher("/jspexam/lottoview.jsp");	
		rd1.forward(request, response);	
	}
}



