package kr.or.ddit.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.review.model.ReviewVO;

public class ReviewDao implements ReviewDaoI {
	
	@Override
	public List<ReviewVO> selectAllReview(int board_seq1) {
		System.out.println("selectAllReview : " + board_seq1);
		SqlSession sqlSession = MybatisUtil.getSession();
		List<ReviewVO> reviewList = sqlSession.selectList("review.selectAllReview", board_seq1);
		
		sqlSession.close();
		return reviewList;
	}

	@Override
	public int deleteReview(int revw_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = sqlSession.update("review.deleteReview", revw_seq1);
		
		if(deleteCnt ==1){
			sqlSession.commit();
		}else{
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}
	

}
