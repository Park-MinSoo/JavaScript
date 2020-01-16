package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberlocal")
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int local_v=0;
		response.setContentType("text/html; charset=utf-8");	// 컨텐트타입을 먼저 설정하고
		PrintWriter out = response.getWriter();	// 그다음 출력 String 객체를 만들어준다.
		member_v += 10;
		local_v += 10;
		out.print("<ul>");
		out.print("<li>멤버변수 : " + member_v + "</li>");	// 공유하여 유지된다.
		out.print("<li>지역변수 : " + local_v + "</li>");	// 요청시 응답하고 사라지는것이 지역변수 (각 요청마다 콜 스텍이 개별적으로 할당)
		out.print("</ul>");
		out.close();
	}
}
