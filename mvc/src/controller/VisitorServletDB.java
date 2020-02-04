package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.VisitorDAO;
import model.vo.VisitorVO;
@WebServlet("/visitor")
public class VisitorServletDB extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		
		VisitorDAO dao = new VisitorDAO();
		if(keyword == null) {
			List<VisitorVO> list = dao.listAll();
			for(VisitorVO vo : list) {
				System.out.println(vo.getMemo());
			}
			request.setAttribute("list", list);
		} else {
			List<VisitorVO> list = dao.search(keyword);
			if(list.size() == 0) {
				request.setAttribute("msg", keyword+"�? ?��고있?�� �??�� ?��?��?��");
			} else {
				request.setAttribute("list", list);
			}
		}
		request.getRequestDispatcher("/jspexam/visitorView.jsp")
        .forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		String name = request.getParameter("name");
		String memo = request.getParameter("content");
		VisitorDAO dao = new VisitorDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName(name);
		vo.setMemo(memo);
		boolean result = dao.insert(vo);
		if(result) {
			request.setAttribute("msg", name+"?��?�� �??�� ?��공적?���? ?��?��?��?��?��?��!!..");
		} else {
			request.setAttribute("msg", name+"?��?�� �??�� ?��?��?�� ?��?��?��?��?��!!");
		}
		request.getRequestDispatcher("/jspexam/visitorView.jsp")
		           .forward(request, response);
	}
}
