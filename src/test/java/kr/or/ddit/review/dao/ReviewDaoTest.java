package kr.or.ddit.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.review.model.ReviewVO;

import static org.junit.Assert.*;
import org.junit.Test;

public class ReviewDaoTest {
	
	private ReviewDaoI reviewDao;
	
	@Test
	public List<ReviewVO> selectAllReview(int board_seq1) {
		return null;
	}

	@Test
	public int deleteReview(int revw_seq1) {
		return 0;
	}

	
	@Test
	public int insertReview(ReviewVO reviewVo) {
		return 0;
	}
	

}
