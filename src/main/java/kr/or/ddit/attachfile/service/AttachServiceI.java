package kr.or.ddit.attachfile.service;

import java.util.List;

import kr.or.ddit.attachfile.model.AttachVO;

public interface AttachServiceI {

	List<AttachVO> selectAllAttach(int board_seq1);
	
	int deleteAttach(int board_seq1);

	int insertAttach(AttachVO attachVo);
}
