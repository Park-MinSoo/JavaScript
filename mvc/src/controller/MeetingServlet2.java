package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MeetingDAO;
import model.dao.MeetingJDBCDAO;
import model.vo.MeetingVO;

@WebServlet("/meeting2")
public class MeetingServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("id");
		String action = request.getParameter("action");

		MeetingDAO dao = new MeetingJDBCDAO();
		if(keyword == null) {
			if(action != null) {
				boolean result = dao.delete(Integer.parseInt(id));
				if (result) {
					request.setAttribute("msg", "ê¸??´ ?„±ê³µì ?œ¼ë¡? ?‚­? œ?˜?—ˆ?Šµ?‹ˆ?‹¤.");
				} else {
					request.setAttribute("msg", "ê¸??´ ?‚­? œ?˜ì§? ?•Š?•˜?Šµ?‹ˆ?‹¤.");
				}
			} 
			request.setAttribute("list", dao.listAll());
		} else {
			List<MeetingVO> list = dao.search(keyword);
			if (list != null && list.size() == 0) {
				request.setAttribute("msg", keyword + "(?´)ê°? ?¬?•¨?œ ê¸??´ ?—†?Šµ?‹ˆ?‹¤.");
			} else {
				request.setAttribute("list", dao.search(keyword));
			}
		}
		request.getRequestDispatcher("/jspexam/meetingView2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String meetingDate = request.getParameter("meetingDate");
		MeetingDAO dao = new MeetingJDBCDAO();
		MeetingVO vo = new MeetingVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(meetingDate);
		if(action.equals("insert")) {
			boolean result = dao.insert(vo);
			if (result) {			
				request.setAttribute("msg", name + "?‹˜?˜ ê¸??´ ?„±ê³µì ?œ¼ë¡? ?…? ¥?˜?—ˆ?Šµ?‹ˆ?‹¤.");			
			} else {
				request.setAttribute("msg", name + "?‹˜?˜ ê¸??´ ?…? ¥?˜ì§? ?•Š?•˜?Šµ?‹ˆ?‹¤.");
			}
		} else {
			vo.setId(Integer.parseInt(action));
			boolean result = dao.update(vo);
			if (result) {			
				request.setAttribute("msg", name + "?‹˜?˜ ê¸??´ ?„±ê³µì ?œ¼ë¡? ?ˆ˜? •?˜?—ˆ?Šµ?‹ˆ?‹¤.");			
			} else {
				request.setAttribute("msg", name + "?‹˜?˜ ê¸??´ ?ˆ˜? •?˜ì§? ?•Š?•˜?Šµ?‹ˆ?‹¤.");
			}
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/jspexam/meetingView2.jsp").forward(request, response);
	}
}
