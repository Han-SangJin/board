package kr.or.ddit.category.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.category.model.CtgrVO;
import kr.or.ddit.db.MybatisUtil;

import static org.junit.Assert.*;
import org.junit.Test;

public class CtgrDaoTest{
	
	private CtgrDaoI ctgrDao = new CtgrDao();
	
	@Test
	public void selectAllCtgr() {
		/***Given***/
		
		/***When***/
		List<CtgrVO> ctlist = (List<CtgrVO>)ctgrDao.selectAllCtgr();

		/***Then***/
		assertEquals(11, ctlist.size());
	}

	@Test
	public void insertCtgr() {
		/***Given***/
		CtgrVO ctgrvo = new CtgrVO();	
		
		/***When***/
		int inctgr = ctgrDao.insertCtgr(ctgrvo);
		
		/***Then***/
		assertEquals(0, inctgr);
	}

	@Test
	public void updateCtgr() {
		/***Given***/
		CtgrVO ctgrvo = new CtgrVO();	
		ctgrvo.setCtgr_seq1(25);	
		ctgrvo.setCtgr_use(2);

		/***When***/
		int upctgr = ctgrDao.updateCtgr(ctgrvo);

		/***Then***/
		
		assertEquals(1, upctgr);
	}

	@Test
	public void getCtgr() {
		/***Given***/
		int ctgr_seq1 = 1;

		/***When***/
		CtgrVO ctgrname = (CtgrVO) ctgrDao.getCtgr(ctgr_seq1);
		
		/***Then***/
		assertEquals("자유게시판", ctgrname.getCtgr_name());
	}

	
	

}
