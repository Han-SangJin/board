package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.model.BoardVO;

public class BoardService implements BoardServiceI {

	private BoardDaoI boardDao;
	  
	public BoardService() {
		boardDao = new BoardDao();
	}
	
	
	@Override
	public BoardVO selectBoard(int board_seq1) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public List<BoardVO> selectAllBoard(int ctgr_seq1) {
		System.out.println("ctgr_seq1"+ctgr_seq1);
		return boardDao.selectAllBoard(ctgr_seq1);
	}

	@Override
	public int insertBoard(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int board_seq1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
