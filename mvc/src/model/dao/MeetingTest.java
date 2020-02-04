package model.dao;

import java.util.List;

import org.junit.Test;

import model.vo.MeetingVO;

public class MeetingTest {

	@Test
	public void test() {
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		MeetingVO vo = new MeetingVO();
		vo.setName("?Ό?΄?Έ");
		vo.setTitle("???Ό ??? 6?? λ§λ©??€!");	
		vo.setMeetingDate("2019-07-01T13:40");
		dao.insert(vo);
		List<MeetingVO> list = dao.listAll();
		for(MeetingVO data : list)
			System.out.println(data);
		System.out.println("???Ό?΄ ?€?΄κ°? κΈ?**"); 
		list = dao.search("???Ό");
		for(MeetingVO data : list)
			System.out.println(data);
	}
	
}
