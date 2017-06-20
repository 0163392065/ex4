package com.choa.notice;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.PageMaker;

@Service
//NoticeService noticeService = new NoticeService();
public class NoticeServiceImpl implements BoardService{
	
	@Inject
	private NoticeDAOImpl noticeDAO;
	
	public void test(){
		
		System.out.println("noticeDAO : "+noticeDAO);
	}
	
	@Override
	public List<BoardDTO> boardList(int curPage, String search, String find) throws Exception {
		int result = noticeDAO.boardCount();
		PageMaker pageMaker = new PageMaker(curPage, result);
		List<BoardDTO> ar = noticeDAO.boardList(pageMaker.getRowMaker(), search, find);
		return ar;
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.boardView(num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		return noticeDAO.boardDelete(num);
	}

	
	/*//Constructor
	public NoticeService(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	//setter
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}*/

}
