package com.choa.freeBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnect;
import com.choa.util.ListInfo;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Repository("freeBoard")
public class FreeBoardDAOImpl implements BoardDAO {
   
   /*@Inject
   private DataSource dataSource;*/
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE="FreeBoardMapper.";

	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"list", listInfo);
		
	}
	@Override
	public BoardDTO boardView(int num) throws Exception {
		
		BoardDTO boardDTO = sqlSession.selectOne(NAMESPACE+"view", num);
		
		return boardDTO;
		
	}
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {		
		
		return sqlSession.insert(NAMESPACE+"write", boardDTO);
	}
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}
	@Override
	public int boardDelete(int num) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"delete", num);
	}
	
	@Override
	public int boardCount(ListInfo listInfo) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"count");

	}
	@Override
	public void boardHit(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}
   
   
}