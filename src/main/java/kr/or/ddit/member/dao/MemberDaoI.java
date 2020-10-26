package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public interface MemberDaoI {
	
	MemberVO getMember(String memId);
	
	List<MemberVO> selectAllMember();
	
	List<MemberVO> selectMemberPageList(SqlSession sqlSession, PageVO pageVo);
	
	int selectMemberTotalCnt(SqlSession sqlSession);
	
	int insertMember(MemberVO memberVo);
	
	int deleteMember(String memId);
	
	int updateMember(MemberVO memberVo);
	
//	private String memId;		// 아이디		MEM_ID
//	private String memPass;		// 비밀번호	MEM_PASS
//	private Date memRegdt;		// 생성일		MEM_REGDT
	
}
 