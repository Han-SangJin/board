package kr.or.ddit.review.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.review.dao.ReviewDao;
import kr.or.ddit.review.dao.ReviewDaoI;
import kr.or.ddit.review.model.ReviewVO;

import static org.junit.Assert.*;
import org.junit.Test;

public class ReviewServiceTest {
	
	private ReviewServiceI reviewService;
	
	
	@Test
	public void selectAllReviewTest(int board_seq1) {
		
		/***Given***/
		board_seq1 = 1;
		
		/***When***/
		List<ReviewVO> reviewlist = (List<ReviewVO>)reviewService.selectAllReview(board_seq1);
		
		/***Then***/
		assertNotEquals(5, reviewlist.size());
	}
//
//	
//	@Test
//	public int deleteReview(int revw_seq1) {
//		return 0;
//	}
//
//	
//	@Test
//	public int insertReview(ReviewVO reviewVo) {
//		return 0;
//	}
}
