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
   public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
	   return sqlSession.selectList(NAMESPACE+"list", rowMaker);
/*      Connection con = dataSource.getConnection();
      PreparedStatement st=null;
      ResultSet rs = null;
      String sql="select * from "
            + "(select rownum R, F.* from "
            + "(select * from freeboard order by ref desc, step asc) F) "
            + "where R between ? and ?";
      
      List<BoardDTO> ar = new ArrayList<BoardDTO>();
      
      st = con.prepareStatement(sql);
      st.setInt(1, rowMaker.getStartRow());
      st.setInt(2, rowMaker.getLastRow());
      rs = st.executeQuery();
      
      while(rs.next()){
         FreeBoardDTO freeBoardDTO = new FreeBoardDTO();
         freeBoardDTO.setNum(rs.getInt("num"));
         freeBoardDTO.setWriter(rs.getString("writer"));
         freeBoardDTO.setTitle(rs.getString("title"));
         freeBoardDTO.setContents(rs.getString("contents"));
         freeBoardDTO.setReg_date(rs.getDate("reg_date"));
         freeBoardDTO.setHit(rs.getInt("hit"));
         freeBoardDTO.setRef(rs.getInt("ref"));
         freeBoardDTO.setStep(rs.getInt("step"));
         freeBoardDTO.setDepth(rs.getInt("depth"));
         ar.add(freeBoardDTO);   
      }
      // close
      DBConnect.disConnect(rs, st, con);
      System.out.println(ar.size());
      return ar;*/
   }

   @Override
   public BoardDTO boardView(int num) throws Exception {
	   return sqlSession.selectOne(NAMESPACE+"view", num);
/*      Connection con =dataSource.getConnection();
      PreparedStatement st=null;
      ResultSet rs = null;
      String sql="select * from freeboard where num=?";
      FreeBoardDTO freeBoardDTO =null;
      
      st = con.prepareStatement(sql);
      st.setInt(1, num);
      rs = st.executeQuery();
      if(rs.next()){
         freeBoardDTO = new FreeBoardDTO();
         freeBoardDTO.setNum(rs.getInt("num"));
         freeBoardDTO.setWriter(rs.getString("writer"));
         freeBoardDTO.setTitle(rs.getString("title"));
         freeBoardDTO.setContents(rs.getString("contents"));
         freeBoardDTO.setReg_date(rs.getDate("reg_date"));
         freeBoardDTO.setHit(rs.getInt("hit"));
         freeBoardDTO.setRef(rs.getInt("ref"));
         freeBoardDTO.setStep(rs.getInt("step"));
         freeBoardDTO.setDepth(rs.getInt("depth"));
      }
      
      //close
      DBConnect.disConnect(rs, st, con);
   
      return freeBoardDTO;*/
   }

   @Override
   public int boardWrite(BoardDTO boardDTO) throws Exception {
	   return sqlSession.insert(NAMESPACE+"write", boardDTO);
/*      Connection con =dataSource.getConnection();
      PreparedStatement st=null;
      int result=0;
      
      String sql="insert into freeboard values(freeboard_seq.nextval, ?,?,?, sysdate, 0)";
      
      st = con.prepareStatement(sql);
      st.setString(1, boardDTO.getWriter());
      st.setString(2, boardDTO.getTitle());
      st.setString(3, boardDTO.getContents());
      result =st.executeUpdate();
      
      //close
      DBConnect.disConnect(st, con);
      
      
      return result;*/
   }

   @Override
   public int boardUpdate(BoardDTO boardDTO) throws Exception {
	   return sqlSession.update(NAMESPACE+"update", boardDTO);
/*      Connection con = dataSource.getConnection();
      PreparedStatement st =null;
      String sql =" update freeboard set writer=?, title=? , contents=? where num=?";
      int result =0;
      
      st = con.prepareStatement(sql);
      st.setString(1, boardDTO.getWriter());
      st.setString(2, boardDTO.getTitle());
      st.setString(3, boardDTO.getContents());
      st.setInt(4, boardDTO.getNum());
      result =st.executeUpdate();

      //close
      DBConnect.disConnect(st, con);  
      
      return result;*/
   }

   @Override
   public int boardDelete(int num) throws Exception {
	   return sqlSession.delete(NAMESPACE+"delete", num);
/*      Connection con = dataSource.getConnection();
      PreparedStatement st =null;
      String sql =" delete freeboard where num=?";
      int result=0;
      
      st = con.prepareStatement(sql);
      st.setInt(1, num);
      result = st.executeUpdate();
      
      //close
      DBConnect.disConnect(st, con);
      
      return result;*/
   }

   @Override
   public int boardCount() throws Exception {
	   return sqlSession.selectOne(NAMESPACE+"count");
/*      Connection con = dataSource.getConnection();
      PreparedStatement st = null;
      ResultSet rs = null;
      int result=0;
      String sql ="select nvl(count(num),0) from freeboard ";
      
         st= con.prepareStatement(sql);
         rs = st.executeQuery();
         rs.next();
         result = rs.getInt(1);
         
         //close
         DBConnect.disConnect(rs, st, con);
   
      return result;*/
   }

   @Override
   public void boardHit(int num) throws Exception {
	   sqlSession.selectOne(NAMESPACE+"hit", num);
/*	   Connection con = dataSource.getConnection();
	   PreparedStatement st = null;
	   int result = 0 ;
	   
	   String sql = "update freeboard set hit = hit + 1 where num = ?";
	   
	   st = con.prepareStatement(sql);
	   st.setInt(1, num);
	   result=st.executeUpdate();
	   
	   DBConnect.disConnect(st, con);*/
	   

   }
   
   
}