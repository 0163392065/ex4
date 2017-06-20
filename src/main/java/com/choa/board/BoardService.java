package com.choa.board;

import java.util.List;

public interface BoardService {
	//list
	public List<BoardDTO> boardList(int curPage, String search, String find) throws Exception;
	
	//view
	public BoardDTO boardView(int num) throws Exception;
	
	//write
	public int boardWrite(BoardDTO boardDTO) throws Exception;
	
	//update
	public int boardUpdate(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int boardDelete(int num) throws Exception;
	
	
	
}
