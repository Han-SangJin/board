package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;

public class BoardDao implements BoardDaoI {

	@Override
	public BoardVO selectBoard(int board_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		BoardVO boardVo = sqlSession.selectOne("board.selectBoard", board_seq1);
		
		sqlSession.close();
		return boardVo;
	}
	
	// 전체글 가져오기
	@Override
	public List<BoardVO> selectAllBoard(int ctgr_seq1) {
		System.out.println("ctgr_seq1"+ctgr_seq1);
		SqlSession sqlSession = MybatisUtil.getSession();
		List<BoardVO> selectAllBoard =  sqlSession.selectList("board.selectAllBoard", ctgr_seq1);
		
		sqlSession.close(); 
		return selectAllBoard;
	}

	// 전체 글 가져오기 (계층정렬)
	@Override
	public List<BoardVO> selectBoardPageList(SqlSession sqlSession, PageVO pageVo) {
		return sqlSession.selectList("board.selectBoardPageList", pageVo);
	}
	
	// 전체 글 갯수
	@Override
	public int selectBoardTotalCnt(SqlSession sqlSession, int ctgr_seq1) {
		return sqlSession.selectOne("board.selectBoardTotalCnt", ctgr_seq1);
	}
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = 0;

		insertCnt = sqlSession.insert("board.insertBoard", boardVo);
		
		if(insertCnt >= 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
			
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int inBoard(BoardVO boardVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = 0;

		insertCnt = sqlSession.insert("board.inBoard", boardVo);
		
		if(insertCnt >= 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
			
		sqlSession.close();
		return insertCnt;
	}
		
	@Override
	public int deleteBoard(int board_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = sqlSession.update("board.deleteBoard", board_seq1);
		
		if(deleteCnt >=1){
			sqlSession.commit();
		}else{
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}
	
	
	@Override
	public int updateBoard(BoardVO boardVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updateCnt = sqlSession.update("board.updateBoard", boardVo);
		System.out.println("servcie updateCnt : "+updateCnt);
		if(updateCnt >=1){
			sqlSession.commit();
		}else{
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}


}
