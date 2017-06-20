package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnect;
import com.choa.util.RowMaker;

@Repository("notice")
//NoticeDAO noticDao = new NoticeDAO();
public class NoticeDAOImpl implements BoardDAO{
	
	@Autowired
	/*private DataSource dataSource;*/
	private SqlSession sqlSession;
	//Mapper를 또 사용하게 되면 하나 더 선언하면 된다.
	private static final String NAMESPACE="NoticeMapper.";
	
		
	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/

	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker, String search, String find) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("rowMaker", rowMaker);
		map.put("search", search);
		map.put("find", find);
		return sqlSession.selectList(NAMESPACE+"list", map);
		
/*		Connection con = null;
		//	Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		
		String sql ="select * from "
				+ "(select rownum R, N.* from "
				+ "(select * from notice order by num desc) N) "
				+ "where R between ? and ?";
		st = con.prepareStatement(sql);
		st.setInt(1, rowMaker.getStartRow());
		st.setInt(2, rowMaker.getLastRow());
		
		rs = st.executeQuery();
		
		while(rs.next()){
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
			ar.add(noticeDTO);
		}
		
		DBConnect.disConnect(rs, st, con);
		
		return ar;*/
	}
	@Override
	public BoardDTO boardView(int num) throws Exception {
		
		BoardDTO boardDTO = sqlSession.selectOne(NAMESPACE+"view", num);
		
		return boardDTO;
		
/*		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		NoticeDTO noticeDTO=null;
		
		String sql ="select * from notice where num=?";
		
		st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		rs = st.executeQuery();
		
		if(rs.next()){
			noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
		}
		
		//close
		DBConnect.disConnect(rs, st, con);
		return noticeDTO;*/
	}
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {		
		
		return sqlSession.insert(NAMESPACE+"write", boardDTO);
/*		Connection con = null;
		PreparedStatement st= null;
		int result=0;
		
		String sql="insert into notice values(point_seq.nextval,?,?,?,sysdate,0)";
		st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getWriter());
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getContents());
		result = st.executeUpdate();
		
		DBConnect.disConnect(st, con);
		return result;*/
	}
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", boardDTO);
/*		Connection con = null;
		PreparedStatement st= null;
		int result=0;
		
		String sql="update notice set title=?, contents=? where num=?";
		st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setInt(3, boardDTO.getNum());
		result = st.executeUpdate();
		
		DBConnect.disConnect(st, con);
		return result;*/
	}
	@Override
	public int boardDelete(int num) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"delete", num);
/*		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		String sql = "delete notice where num = ? ";
		
		st = con.prepareStatement(sql);
		st.setInt(1, num);
		result = st.executeUpdate();
		
		DBConnect.disConnect(st, con);
		
		return result;*/
	}
	
	@Override
	public int boardCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"count");
/*		Connection con = null;
		PreparedStatement st= null;
		ResultSet rs = null;
		
		String sql = "select nvl(count(num), 0) from notice";
		
		st= con.prepareStatement(sql);
		
		rs = st.executeQuery();
		
		rs.next();
		
		int result = rs.getInt(1);
		
		DBConnect.disConnect(rs, st, con);
		
		return result;*/
	}
	@Override
	public void boardHit(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

	}
