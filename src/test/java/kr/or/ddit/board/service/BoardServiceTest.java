package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;

import static org.junit.Assert.*;
import org.junit.Test;

public class BoardServiceTest {

	private BoardServiceI boardService = new BoardService();
	  
	
	@Test
	public void selectAllBoard() {
		/***Given***/
		int ctgr_seq1 = 1;
		
		/***When***/
		List<BoardVO> boarlist = (List<BoardVO>) boardService.selectAllBoard(ctgr_seq1);

		/***Then***/
		assertEquals(30, boarlist.size());
	}

	 
	@Test
	public void selectBoardPageList() {
		/***Given***/
		PageVO pageVo = new PageVO();
		pageVo.setCtgr_seq1(1);
		pageVo.setPage(1);
		pageVo.setPageSize(10);

		/***When***/
		Map<String, Object> map = (Map<String, Object>) boardService.selectBoardPageList(pageVo);
		List<BoardVO> boardlist = (List<BoardVO>) map.get("selectAllBoard");
		
		/***Then***/
		assertEquals(10, boardlist.size());
	} 
 
	@Test
	public void selectBoardTotalCnt() {
		/***Given***/
		int ctgr_seq1 = 1;

		/***When***/
		int boardcnt = boardService.selectBoardTotalCnt(ctgr_seq1);
		
		/***Then***/
		assertEquals(30, boardcnt);
	}
	
	@Test
	public void insertBoard() {
		/***Given***/
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_cont("테스트내용");
		boardVo.setBoard_title("테스트제목");
		boardVo.setCtgr_seq1(1);	// 1,2
		boardVo.setMem_id("a001");

		/***When***/
		int inboard = boardService.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(0, inboard);
	}
	
	@Test
	public void inBoard() {
		/***Given***/
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_dep(10);
		boardVo.setParent_seq1(10);
		boardVo.setBoard_cont("테스트답글");
		boardVo.setBoard_title("테스트제목");
		boardVo.setCtgr_seq1(1);	// 1,2
		boardVo.setMem_id("a001");

		/***When***/
		int inboard = boardService.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(0, inboard);
	}
	
	@Test
	public void deleteBoard() {
		/***Given***/
		int board_seq1 = 10;

		/***When***/
		int delboard = boardService.deleteBoard(board_seq1);
		
		/***Then***/
		assertEquals(1, delboard);
	}
	  
	@Test
	public void updateBoard() {
		/***Given***/
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title("테스트제목수정");
		boardVo.setBoard_cont("테스트수정");
		boardVo.setCtgr_seq1(10);
		 
		/***When***/
		int upboard = boardService.updateBoard(boardVo);

		/***Then***/
		assertEquals(0, upboard);
	} 





}
