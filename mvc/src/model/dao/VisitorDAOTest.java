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
		System.out.println("ê²??ƒ‰ ê¸°ëŠ¥ ?…Œ?Š¤?Š¸");
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.search("ë°?");
		System.out.println(list.size());
		for(VisitorVO vo : list)
			System.out.println(vo);
	}
	
	
	@Test
	void test2() {
		System.out.println("?‚½?… ?…Œ?Š¤?Š¸");
		VisitorDAO dao = new VisitorDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName("?¬?™?´");
		vo.setMemo("~~~?˜¤?Š˜?? ê·¸ëƒ¥ ê¸ˆìš”?¼~~~");
		boolean result = dao.insert(vo);	//insertê°? ?˜?˜ë©? true ?•ˆ?˜ë©? false?´?‹¤.
		if(result)
			System.out.println("?‚½?… ?„±ê³?");
		else
			fail("?‚½?…?‹¤?Œ¨");
	}
}
