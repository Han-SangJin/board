package kr.or.ddit.attachfile.dao;

import java.util.List;

import kr.or.ddit.attachfile.model.AttachVO;

public interface AttachDaoI {

	List<AttachVO> selectAllAttach(int board_seq1);
	
	int deleteAttach(List<AttachVO> attachList);

	int insertAttach(List<AttachVO> attachList);
	
	int updateBoard(List<AttachVO> attachList);
	
}
