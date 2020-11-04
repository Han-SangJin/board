package kr.or.ddit.member.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

import static org.junit.Assert.*;
import org.junit.Test;

public class MemberDaoTest {
	
	private MemberDaoI memberDao = new MemberDao();;
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userid = "a001";
		String userpass = "123";
		
		/***When***/
		MemberVO memberVo = memberDao.getMember(userid);
		
		/***Then***/
		assertEquals(userpass, memberVo.getMem_pass());
		
	}
	

}
