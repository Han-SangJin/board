package kr.or.ddit.member.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberService implements MemberServiceI {
	
//	private String memId;		// 아이디		MEM_ID
//	private String memPass;		// 비밀번호	MEM_PASS
//	private Date memRegdt;		// 생성일		MEM_REGDT
	
	private MemberDaoI memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	@Override
	public MemberVO getMember(String memId) {
		return memberDao.getMember(memId);
	}
	
	
	@Override
	public List<MemberVO> selectAllMember() {
		return memberDao.selectAllMember();
	}
	
	
	@Override
	public Map<String, Object> selectMemberPageList(PageVO pageVo) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberList", memberDao.selectMemberPageList(sqlSession,pageVo));
		
		// 15건 ==(페이지사이즈 7)==> 3페이지
		// 15/7 ==  2.14.. ==(올림)==> 3페이지 
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);
		int pages = (int)Math.ceil((double)totalCnt/7);
		map.put("pages", pages);
		
		sqlSession.close();
		return map;
	}
	
	
	@Override
	public int selectMemberTotalCnt() {
		SqlSession sqlSession = MybatisUtil.getSession();
		return memberDao.selectMemberTotalCnt(sqlSession);
	}
	
	
	@Override
	public int insertMember(MemberVO memberVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		return memberDao.insertMember(memberVo);
	}

	
	@Override
	public int deleteMember(String userid) {
		SqlSession sqlSession = MybatisUtil.getSession();
		return memberDao.deleteMember(userid);
	}
		
	@Override
	public int updateMember(MemberVO memberVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		return memberDao.updateMember(memberVo);
	}
}
