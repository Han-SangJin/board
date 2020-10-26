package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDao implements MemberDaoI {
	
//	private String memId;		// 아이디		MEM_ID
//	private String memPass;		// 비밀번호	MEM_PASS
//	private Date memRegdt;		// 생성일		MEM_REGDT
	
	// select 
	// 한건 : selectOne
	// 여러건 : selctList
	
	@Override
	public MemberVO getMember(String mem_id) {
		SqlSession sqlSession = MybatisUtil.getSession();
		MemberVO memberVo = sqlSession.selectOne("member.getMember", mem_id);
		
		sqlSession.close();
		return memberVo;
	}
	
	
	@Override
	public List<MemberVO> selectAllMember() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<MemberVO> memberList =  sqlSession.selectList("member.selectAllMember");
		
		sqlSession.close();
		return memberList;
	}

	
	@Override
	public List<MemberVO> selectMemberPageList(SqlSession sqlSession, PageVO pageVo) {
		return sqlSession.selectList("member.selectMemberPageList", pageVo);
	}
	

	@Override
	public int selectMemberTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}


	@Override
	public int insertMember(MemberVO memberVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = 0;

		try{
			insertCnt = sqlSession.insert("member.insertMember", memberVo);
		}catch(Exception e){
			 
		}

		if(insertCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return insertCnt;
	}

	
	@Override
	public int deleteMember(String memId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = sqlSession.delete("member.deleteMember", memId);
		
		if(deleteCnt ==1){
			sqlSession.commit();
		}else{
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}


	@Override
	public int updateMember(MemberVO memberVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = sqlSession.delete("member.updateMember", memberVo);
		
		if(deleteCnt ==1){
			sqlSession.commit();
		}else{
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}
	
	

}
