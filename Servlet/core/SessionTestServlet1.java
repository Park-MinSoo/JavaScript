package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessiontest1")
public class SessionTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int local_v=0;
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cnt") == null)	// 장바구니에 물건을 담을떄마다 계속 새 장바구니를 꺼내면 안되기 떄문
			session.setAttribute("cnt", new int[1]);// session 데이터에 보관하는 데이터는 반드시 객체여야 한다.!!!,, 데이터를 저장할 방을 등록하고 있다.
		int[] session_v = (int[])session.getAttribute("cnt");
		session_v[0] += 10;
		member_v += 10;
		local_v += 10;
		out.print("<ul>");
		out.print("<li>멤버변수 : " + member_v + "</li>");	
		out.print("<li>지역변수 : " + local_v + "</li>");	
		out.print("<li>섹션 객체에 저장된 배열 원소 : " + session_v[0] + "</li>");	
		out.print("</ul>");
		out.close();
	}
}
