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
		vo.setTitle("화요일날 만남");
		vo.setContent("화요일날 6시에 만나여 ㅎㅎ");
		vo.setWritedate("2019-07-01T13:40");
		vo.setCnt(1);
		dao.insert(vo);
		List<NewsVO > list = dao.listAll();
		for(NewsVO  data : list)
			System.out.println(data);

	}
	
}
