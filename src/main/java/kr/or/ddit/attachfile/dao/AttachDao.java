package kr.or.ddit.attachfile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.review.model.ReviewVO;

public class AttachDao implements AttachDaoI {

	
	@Override
	public List<AttachVO> selectAllAttach(int board_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<AttachVO> attachList = sqlSession.selectList("attach.selectAllAttach", board_seq1);
		
		sqlSession.close();
		return attachList;
	}

	
	@Override
	public int deleteAttach(int board_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = sqlSession.delete("attach.deleteAttach", board_seq1);
		
		if(deleteCnt ==1){
			sqlSession.commit();
		}else{
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}

	
	@Override
	public int insertAttach(List<AttachVO> attachList) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = 0;
		
		insertCnt = sqlSession.insert("attach.insertAttach", attachList);
		
		if(insertCnt >= 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
			
		sqlSession.close();
		return insertCnt;
	}

}
