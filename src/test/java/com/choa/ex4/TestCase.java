package com.choa.ex4;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.util.List;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDAOImpl;
import com.choa.notice.NoticeDTO;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})*/
public class TestCase extends MyAbstractTest{

	@Autowired
	private NoticeDAOImpl noticeDAOImpl;
	
/*	@Test
	public void connectionTest(){
		assertNotNull(sqlSession);
		System.out.println("test");
	}*/
	
	//@Test
	public void noticeView() throws Exception{
		BoardDTO boardDTO = noticeDAOImpl.boardView(564);
		System.out.println(boardDTO.getWriter());
		assertNotNull(boardDTO);
	}
	
	//@Test
	public void noticeWrite() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setWriter("choa");
		noticeDTO.setTitle("test!!");
		noticeDTO.setContents("싸인회 하나유?");
		int result = noticeDAOImpl.boardWrite(noticeDTO);
		System.out.println(result);
		assertEquals(1, result);
	}
	
	//@Test
	public void noticeUpdate() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("updatetest!!");
		noticeDTO.setContents("싸인회 하는겁니까?");
		noticeDTO.setNum(581);
		int result = noticeDAOImpl.boardUpdate(noticeDTO);
		System.out.println(result);
		assertEquals(1, result);
	}
	
	//@Test
	public void noticeDelete() throws Exception{
		int result = noticeDAOImpl.boardDelete(554);
		System.out.println(result);
		assertEquals(1, result);
	}
	
	@Test
	public void noticeList() throws Exception{
		PageMaker pageMaker = new PageMaker(1, 20);
		String search = "writer";
		String find = "choa";
		List<BoardDTO> ar = noticeDAOImpl.boardList(pageMaker.getRowMaker(), search, find);
		System.out.println(ar.get(0).getWriter());
		System.out.println(ar.get(1).getWriter());
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void noticeCount() throws Exception{
		int result = noticeDAOImpl.boardCount();
		System.out.println(result);
		assertNotEquals(0, result);
	}
	
	/*@Autowired
	private NoticeDAOImpl noticeDAO;*/
	
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
