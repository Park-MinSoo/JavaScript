package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.MeetingJDBCDAO;
import model.vo.MeetingVO;

@WebServlet("/meeting")
public class MeetingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String action = request.getParameter("action");
		String id = request.getParameter("id");			
		MeetingJDBCDAO dao = new MeetingJDBCDAO();

		if(action == null) {
			if (keyword == null) {
				List<MeetingVO> list = dao.listAll();
				for (MeetingVO vo : list) {
					System.out.println(vo.getTitle());
				}
				request.setAttribute("list", list);
			} 	
			
			else {
				List<MeetingVO> list = dao.search(keyword);
				if (list.size() == 0) {
					request.setAttribute("msg", keyword + "Î•? ?ã¥Í≥†Ïûà?äî Í∏??ù¥ ?óÜ?ñ¥?ö©");
				} else {
					request.setAttribute("list", list);
				}
			}
		}	else {
				if (action.equals("delete")) {			
					dao.delete(Integer.parseInt(id));
					List<MeetingVO> list = dao.listAll();
					for (MeetingVO vo : list) {
						System.out.println(vo.getTitle());
					}
					request.setAttribute("list", list);
			}
		}
		request.getRequestDispatcher("/jspexam/meetingView_jstl.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String meetingdate = request.getParameter("meetingDate");
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		MeetingVO vo = new MeetingVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(meetingdate);
		boolean result = dao.insert(vo);
		if (result) {
			request.setAttribute("msg", name + "?ãò?ùò Í∏??ù¥ ?Ñ±Í≥µÏ†Å?úºÎ°? ?ûÖ?†•?êò?óà?ñ¥?öî!!..");
		} else {
			request.setAttribute("msg", name + "?ãò?ùò Í∏??ù¥ ?ûÖ?†•?óê ?ã§?å®?ñà?ñ¥?öî!!");
		}
		request.getRequestDispatcher("/jspexam/meetingView_jstl.jsp").forward(request, response);
	}
}
