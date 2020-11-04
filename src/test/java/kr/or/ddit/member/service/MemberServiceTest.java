package kr.or.ddit.member.service;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

import static org.junit.Assert.*;
import org.junit.Test;

public class MemberServiceTest {
	
	private MemberServiceI memberService = new MemberService();
	
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userid = "a001";
		String password = "123";
		
		/***When***/
		MemberVO memberVo = memberService.getMember(userid);
		
		/***Then***/
		assertEquals(password, memberVo.getMem_pass());

	}
}
