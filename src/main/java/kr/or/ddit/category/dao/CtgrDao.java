package kr.or.ddit.category.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.category.model.CtgrVO;
import kr.or.ddit.db.MybatisUtil;

public class CtgrDao implements CtgrDaoI {
	
//	private String memId;		// 아이디		MEM_ID
//	private String memPass;		// 비밀번호	MEM_PASS
//	private Date memRegdt;		// 생성일		MEM_REGDT
	
	// select 
	// 한건 : selectOne
	// 여러건 : selctList
	
	@Override
	public List<CtgrVO> selectAllCtgr() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<CtgrVO> ctgrList =  sqlSession.selectList("ctgr.selectAllCtgr");
		 
		sqlSession.close();
		return ctgrList;
	}

	
	

}
