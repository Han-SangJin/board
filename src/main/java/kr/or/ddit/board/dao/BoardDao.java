package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;

public class BoardDao implements BoardDaoI {

	@Override
	public BoardVO selectBoard(int board_seq1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<BoardVO> selectAllBoard(int ctgr_seq1) {
		System.out.println("ctgr_seq1"+ctgr_seq1);
		SqlSession sqlSession = MybatisUtil.getSession();
		List<BoardVO> selectAllBoard =  sqlSession.selectList("board.selectAllBoard", ctgr_seq1);
		
		sqlSession.close(); 
		return selectAllBoard;
	}

	@Override
	public List<BoardVO> selectBoardPageList(SqlSession sqlSession, PageVO pageVo) {
		return sqlSession.selectList("board.selectBoardPageList", pageVo);
	}
	
	@Override
	public int selectBoardTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("board.selectBoardTotalCnt");
	}
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public int deleteBoard(int board_seq1) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public int updateBoard(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
