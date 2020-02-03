package controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MeetingJDBCDAO;
import model.dao.NewsDAO;
import model.vo.MeetingVO;
import model.vo.NewsVO;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String newsid = request.getParameter("newsid");			
		NewsDAO dao = new NewsDAO();

		if(action == null) {
				List<NewsVO> list = dao.listAll();
				for (NewsVO vo : list) {
					System.out.println(vo.getTitle());
				}
				request.setAttribute("list", list);
			
		}	else {
				if (action.equals("delete")) {
					dao.delete(Integer.parseInt(newsid));
					List<NewsVO> list = dao.listAll();
					for (NewsVO vo : list) {
						System.out.println(vo.getTitle());
					}
					request.setAttribute("list", list);
			}
				else if(action.equals("read")){
					dao.listOne(Integer.parseInt(newsid));
					List<NewsVO> list = dao.listAll();
					for (NewsVO vo : list) {
						System.out.println(vo.getTitle());
					}
					request.setAttribute("list", list);					
				}
		}
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writedate = request.getParameter("writedate");
		String cnt = request.getParameter("cnt");
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWritedate(writedate);
		vo.setCnt(Integer.parseInt(cnt));
		if(action.equals("insert")) {
			boolean result = dao.insert(vo);
			if (result) {
				request.setAttribute("msg", writer + "님의 글이 성공적으로 입력되었습니다.");			
			} else {
				request.setAttribute("msg", writer + "님의 글이 입력되지 않았습니다.");
			}
		} else {
			vo.setId(Integer.parseInt(action));
			boolean result = dao.update(vo);
			if (result) {			
				request.setAttribute("msg", writer + "님의 글이 성공적으로 수정되었습니다.");			
			} else {
				request.setAttribute("msg", writer + "님의 글이 수정되지 않았습니다.");
			}
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}
}
