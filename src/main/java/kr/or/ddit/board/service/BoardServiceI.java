package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVO;

public interface BoardServiceI {

	BoardVO selectBoard(int board_seq1);
	
	List<BoardVO> selectAllBoard(int ctgr_seq1);
	
	int insertBoard(BoardVO boardVo);
	
	int deleteBoard(int board_seq1);
	
	int updateBoard(BoardVO boardVo);
	
}
