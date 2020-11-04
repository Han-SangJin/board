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
	
	private ReviewServiceI reviewService = new ReviewService();
	
	
	@Test
	public void selectAllReviewTest() {
		/***Given***/
		int board_seq1 = 1;
		
		/***When***/
		List<ReviewVO> reviewlist = (List<ReviewVO>)reviewService.selectAllReview(board_seq1);
		
		/***Then***/ 
		assertEquals(12, reviewlist.size());
		
	}
	
	
	@Test
	public void deleteReview() {
		/***Given***/
		int revw_seq1 = 1;

		/***When***/
		int delreview = reviewService.deleteReview(revw_seq1);
		
		/***Then***/
		assertEquals(1, delreview);
	}

	
	@Test
	public void insertReview() {
		/***Given***/
		ReviewVO reviewVo = new ReviewVO();
		reviewVo.setBoard_seq1(0);
		reviewVo.setMem_id("a001");
		reviewVo.setRevw_cont("내용");

		/***When***/
		int inreview = reviewService.insertReview(reviewVo);
		
		/***Then***/
		assertNotEquals(0, inreview);
	}
}
