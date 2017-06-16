package com.choa.ex4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.util.List;

import com.choa.notice.NoticeDAOImpl;
import com.choa.notice.NoticeDTO;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})*/
public class TestCase extends MyAbstractTest{

	@Autowired
	private NoticeDAOImpl noticeDAO;
	
	//서비스로도 테스트가 가능하다
	//@Test
/*	public void test() throws Exception {
		NoticeDTO noticeDTO = noticeDAO.noticeView(542);
		System.out.println(noticeDTO.getNum());
		System.out.println(noticeDTO.getTitle());
		Assert.assertNotNull(noticeDTO);
	}
	
	//@Test
	public void test2() throws Exception {
		int result = noticeDAO.noticeDelete(541);
		assertEquals(1, result);
	}
	
	@Test
	public void test3() throws Exception {
		PageMaker pageMaker = new PageMaker(1, 10);
		
		List<NoticeDTO> ar = noticeDAO.noticeList(pageMaker.getRowMaker());
		Assert.assertEquals(0, ar.size());
	}*/

}
