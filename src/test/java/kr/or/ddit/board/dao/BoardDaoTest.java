package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;

import static org.junit.Assert.*;
import org.junit.Test;

public class BoardDaoTest  {

	private BoardDaoI boardDao;
	
	@Test
	public BoardVO selectBoard(int board_seq1) {
		return null;
	}
	
	@Test
	public List<BoardVO> selectAllBoard(int ctgr_seq1) {
		return null;
	}
	
	@Test
	public List<BoardVO> selectBoardPageList(SqlSession sqlSession, PageVO pageVo) {
		return null;
	}
	
	@Test
	public int selectBoardTotalCnt(SqlSession sqlSession, int ctgr_seq1) {
		return 0;
	}
	
	@Test
	public int insertBoard(BoardVO boardVo) {
		return 0;
	}

	@Test
	public int inBoard(BoardVO boardVo) {
		return 0;
	}
		
	@Test
	public int deleteBoard(int board_seq1) {
		return 0;
	}

	
	@Test
	public int updateBoard(BoardVO boardVo) {
		return 0;
	}


}
