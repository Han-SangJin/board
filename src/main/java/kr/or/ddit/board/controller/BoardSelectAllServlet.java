package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardselectallservlet")
public class BoardSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardServiceI boardService;
	
	  
 	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
 	 
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ctgr_seq1 = Integer.parseInt(request.getParameter("ctgr_seq1"));
		List<BoardVO> selectAllBoard = boardService.selectAllBoard(ctgr_seq1);
		System.out.println("ctgr_seq1"+ctgr_seq1);
		 
		request.setAttribute("selectAllBoard", selectAllBoard);
		request.getRequestDispatcher("/board/selectAllBoard.jsp").forward(request, response);
	}
	   
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
  
} 
 