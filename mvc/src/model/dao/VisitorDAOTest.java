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
		System.out.println("κ²?? κΈ°λ₯ ??€?Έ");
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.search("λ°?");
		System.out.println(list.size());
		for(VisitorVO vo : list)
			System.out.println(vo);
	}
	
	
	@Test
	void test2() {
		System.out.println("?½? ??€?Έ");
		VisitorDAO dao = new VisitorDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName("?¬??΄");
		vo.setMemo("~~~?€??? κ·Έλ₯ κΈμ?Ό~~~");
		boolean result = dao.insert(vo);	//insertκ°? ??λ©? true ??λ©? false?΄?€.
		if(result)
			System.out.println("?½? ?±κ³?");
		else
			fail("?½??€?¨");
	}
}
