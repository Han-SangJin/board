package kr.or.ddit.attachfile.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.attachfile.dao.AttachDao;
import kr.or.ddit.attachfile.dao.AttachDaoI;
import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.db.MybatisUtil;

import static org.junit.Assert.*;
import org.junit.Test;

public class AttachServiceTest {

	private AttachServiceI attachService;
	

	
	
	@Test
	public List<AttachVO> selectAllAttach(int board_seq1) {
		return null;
	}
	
	@Test
	public int deleteAttach(List<AttachVO> attachList) {
		return 0;
	}

	@Test
	public int insertAttach(List<AttachVO> attachList) {
		return 0;
	}


	@Test
	public int updateBoard(List<AttachVO> attachList) {
		return 0;
	}
	
}
