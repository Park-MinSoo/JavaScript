package model.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.vo.VisitorVO;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;
class VisitorDAOTest {
	@Test
	void test() {
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.listAll();
		System.out.println(list.size());
		for(VisitorVO vo : list)
			System.out.println(vo);
	}
	
	@Test
	void test1() {
		System.out.println("�??�� 기능 ?��?��?��");
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.search("�?");
		System.out.println(list.size());
		for(VisitorVO vo : list)
			System.out.println(vo);
	}
	
	
	@Test
	void test2() {
		System.out.println("?��?�� ?��?��?��");
		VisitorDAO dao = new VisitorDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName("?��?��?��");
		vo.setMemo("~~~?��?��?? 그냥 금요?��~~~");
		boolean result = dao.insert(vo);	//insert�? ?��?���? true ?��?���? false?��?��.
		if(result)
			System.out.println("?��?�� ?���?");
		else
			fail("?��?��?��?��");
	}
}
