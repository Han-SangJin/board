package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;

public class BoardService implements BoardServiceI {

	private BoardDaoI boardDao;
	  
	public BoardService() {
		boardDao = new BoardDao();
	}
	
	
	@Override
	public BoardVO selectBoard(int board_seq1) {
		return boardDao.selectBoard(board_seq1);
	}
	
	@Override
	public List<BoardVO> selectAllBoard(int ctgr_seq1) {
		return boardDao.selectAllBoard(ctgr_seq1);
	}
	  
	@Override
	public Map<String, Object> selectBoardPageList(PageVO pageVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int ctgr_seq1 = pageVo.getCtgr_seq1();
		System.out.println("selectBoardPageList ctgr_seq1 : " +ctgr_seq1);
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<BoardVO> list = boardDao.selectBoardPageList(sqlSession,pageVo);
		for(BoardVO post : list) {
			System.out.println(post.getBoard_title());
			post.setBoard_title(post.getBoard_title().replaceAll(" ", "&nbsp;"));
//			System.out.println(post.getBoard_title().replaceAll(" ", "&nbsp;"));
		}
		
		map.put("selectAllBoard", boardDao.selectBoardPageList(sqlSession,pageVo));
		 
		
//		for(BoardVO post : list) {
//			System.out.println(post.getBoard_title().replaceAll(" ", "&nbsp;"));
//			
//			post.setTitle(post.getTitle().replaceAll(" ", "&nbsp;"));
//			if(("F").equals(post.getStatus())) {
//				String oldTitle = post.getTitle();
//				String newTitle = oldTitle.substring(0, oldTitle.lastIndexOf("─")+1);
//				newTitle += "[삭제된 게시글입니다]";
//				post.setTitle(newTitle);
//			}
//		}
		
		
			 
		// 15건 ==(페이지사이즈 7)==> 3페이지
		// 15/7 ==  2.14.. ==(올림)==> 3페이지 
		int totalCnt = boardDao.selectBoardTotalCnt(sqlSession, ctgr_seq1);
		int pages = (int)Math.ceil((double)totalCnt/10);
		System.out.println("pages" + pages);
		map.put("pages", pages);
		
		sqlSession.close();
		return map;
	} 
 
	@Override
	public int selectBoardTotalCnt(int ctgr_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		return boardDao.selectBoardTotalCnt(sqlSession, ctgr_seq1);
	}
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		return boardDao.insertBoard(boardVo); 
	}

	@Override
	public int deleteBoard(int board_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		return boardDao.deleteBoard(board_seq1);
	}
	
	@Override
	public int updateBoard(BoardVO boardVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		return boardDao.updateBoard(boardVo);
	}



}
