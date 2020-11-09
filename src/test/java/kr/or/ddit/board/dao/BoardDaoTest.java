package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;

import static org.junit.Assert.*;
import org.junit.Test;

public class BoardDaoTest  {

	private BoardDaoI boardDao = new BoardDao();
	@Test
	public void selectAllBoard() {
		/***Given***/
		int ctgr_seq1 = 1;
		
		/***When***/
		List<BoardVo> boarlist = (List<BoardVo>) boardDao.selectAllBoard(ctgr_seq1);

		/***Then***/
		assertEquals(30, boarlist.size());
	}

	
	@Test
	public void selectBoardPageList() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSession();
		PageVO pageVo = new PageVO();
		pageVo.setCtgr_seq1(1);
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		
		/***When***/
		List<BoardVo> boardlist = (List<BoardVo>) boardDao.selectBoardPageList(sqlSession, pageVo);
		
		/***Then***/
		assertEquals(10, boardlist.size());
	} 
	
	@Test
	public void selectBoardTotalCnt() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSession();
		int ctgr_seq1 = 1;

		/***When***/
		int boardcnt = boardDao.selectBoardTotalCnt(sqlSession, ctgr_seq1);
		
		/***Then***/
		assertEquals(30, boardcnt);
	}
	 
	@Test
	public void insertBoard() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_cont("테스트내용");
		boardVo.setBoard_title("테스트제목");
		boardVo.setCtgr_seq1(1);	// 1,2
		boardVo.setMem_id("a001");

		/***When***/
		int inboard = boardDao.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(0, inboard);
	}
	
	@Test
	public void inBoard() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_dep(10);
		boardVo.setParent_seq1(10);
		boardVo.setBoard_cont("테스트답글");
		boardVo.setBoard_title("테스트제목");
		boardVo.setCtgr_seq1(1);	// 1,2
		boardVo.setMem_id("a001");

		/***When***/
		int inboard = boardDao.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(0, inboard);
	}
	
	@Test
	public void deleteBoard() {
		/***Given***/
		int board_seq1 = 10;

		/***When***/
		int delboard = boardDao.deleteBoard(board_seq1);
		
		/***Then***/
		assertEquals(1, delboard);
	}
	  
	@Test
	public void updateBoard() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_title("테스트제목수정");
		boardVo.setBoard_cont("테스트수정");
		boardVo.setCtgr_seq1(10);
		 
		/***When***/
		int upboard = boardDao.updateBoard(boardVo);

		/***Then***/
		assertEquals(0, upboard);
	} 



}
