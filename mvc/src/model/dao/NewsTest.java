package model.dao;

import java.util.List;

import org.junit.Test;

import model.vo.NewsVO;

public class NewsTest {

	@Test
	public void test() {
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();
		vo.setWriter("라이언");
		vo.setTitle("화요일 만남");
		vo.setContent("화요일 저녁 6시에 만납시다!");
		vo.setWritedate("2019-07-01T13:40");
		vo.setCnt(1);
		dao.insert(vo);
		List<NewsVO > list = dao.listAll();
		for(NewsVO  data : list)
			System.out.println(data);
/*	
		System.out.println("화요일이 들어간 글**"); 
		list = dao.search("화요일");
		for(NewsVO  data : list)
			System.out.println(data);
*/	
	}
	
}
