package kr.or.ddit.category.service;

import java.util.List;

import kr.or.ddit.category.dao.CtgrDao;
import kr.or.ddit.category.dao.CtgrDaoI;
import kr.or.ddit.category.model.CtgrVO;

public class CtgrService implements CtgrServiceI {
	
//	private String memId;		// 아이디		MEM_ID
//	private String memPass;		// 비밀번호	MEM_PASS
//	private Date memRegdt;		// 생성일		MEM_REGDT
	
	private CtgrDaoI ctgrDao;
	
	public CtgrService() {
		ctgrDao = new CtgrDao();
	}
	
	  
	@Override
	public List<CtgrVO> selectAllCtgr() {
		return ctgrDao.selectAllCtgr();
	}
	
	
}
