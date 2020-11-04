package kr.or.ddit.attachfile.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.attachfile.service.AttachServiceI;
import kr.or.ddit.db.MybatisUtil;

import static org.junit.Assert.*;
import org.junit.Test;

public class AttachDaoTest {
	
	private AttachDaoI attachDao = new AttachDao();

	
	@Test
	public void selectAllAttach() {
		/***Given***/
		int board_seq1 = 1;
		
		/***When***/
		List<AttachVO> atlist = (List<AttachVO>) attachDao.selectAllAttach(board_seq1);

		/***Then***/
		assertEquals(5, atlist.size());
	}
	
	@Test
	public void deleteAttach() {
		/***Given***/
		AttachVO atvo = new AttachVO();
		atvo.setFile_seq1(32);
		
		List<AttachVO> attachList = new ArrayList<>();
		attachList.add(atvo);
		
		/***When***/
		int delat = attachDao.deleteAttach(attachList);

		/***Then***/
		assertEquals(1, delat);
		
	}

	@Test
	public void insertAttach() {
		/***Given***/
		AttachVO atvo = new AttachVO();
		atvo.setFile_name("d:\\테스트경로\\");
		atvo.setFile_real_name("테스트파일.txt");
		atvo.setFile_seq1(8);
		
		List<AttachVO> attachList = new ArrayList<>();
		attachList.add(atvo);
		
		/***When***/
		int inat = attachDao.insertAttach(attachList);
		
		/***Then***/
		assertEquals(1, inat);
	}


	@Test
	public void updateBoard() {
		/***Given***/
		AttachVO atvo = new AttachVO();
		atvo.setFile_name("d:\\테스트경로\\");
		atvo.setFile_real_name("테스트파일.png");
		atvo.setFile_seq1(33);
		
		List<AttachVO> attachList = new ArrayList<>();
		attachList.add(atvo);
		
		/***When***/
		int inat = attachDao.updateBoard(attachList);

		/***Then***/
		assertEquals(1, inat);
	}
}
