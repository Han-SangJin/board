package kr.or.ddit.category.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.category.model.CtgrVO;
import kr.or.ddit.db.MybatisUtil;

import static org.junit.Assert.*;
import org.junit.Test;

public class CtgrDaoTest{
	
	private CtgrDaoI ctgrDao;
	
	@Test
	public List<CtgrVO> selectAllCtgr() {
		return null;
	}

	@Test
	public int insertCtgr(CtgrVO ctgrVo) {
		return 0;
	}

	@Test
	public int updateCtgr(CtgrVO ctgrVo) {
		return 0;
	}

	@Test
	public CtgrVO getCtgr(int ctgr_seq1) {
		return null;
	}

	
	

}
