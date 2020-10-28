package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardselectservlet")
public class BoardSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardServiceI boardService;
	
	  
 	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
 	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int board_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
		BoardVO boardVo = boardService.selectBoard(board_seq1);
		
		if(board_seq1 > 0) {	
			int ctgr_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
			request.setAttribute("ctgr_seq1", ctgr_seq1);
		}
		
		request.setAttribute("boardVo", boardVo);
		request.getRequestDispatcher("/board/selectBoard.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
