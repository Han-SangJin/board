package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public interface MemberServiceI {

	MemberVO getMember(String userId);

	List<MemberVO> selectAllMember();
	
	Map<String, Object> selectMemberPageList(PageVO pageVo);
	
	int selectMemberTotalCnt();
	
	int insertMember(MemberVO memberVo);
	
	int deleteMember(String userid);
	
	int updateMember(MemberVO memberVo);
}
 