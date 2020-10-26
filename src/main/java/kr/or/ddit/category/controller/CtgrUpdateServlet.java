package kr.or.ddit.category.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.category.model.CtgrVO;
import kr.or.ddit.category.service.CtgrService;
import kr.or.ddit.category.service.CtgrServiceI;

/**
 * Servlet implementation class CtgrUpdate
 */
@WebServlet("/ctgrupdate")
public class CtgrUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CtgrServiceI ctgrService;   
	CtgrVO ctgrVo;
	
	@Override
	public void init() throws ServletException {
		ctgrService = new CtgrService();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ctgr_seq1 = Integer.parseInt(request.getParameter("ctgr_seq1"));
		System.out.println("ctgr_seq1 : " + ctgr_seq1);
		ctgrVo = ctgrService.getCtgr(ctgr_seq1); 
		 
		request.setAttribute("ctgrVo", ctgrVo);
		request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String ctgr_name = request.getParameter("ctgr_name");
		int ctgr_use = Integer.parseInt(request.getParameter("ctgr_use"));
		
		// 사용자 정보 등록
		CtgrVO ctgrVo = new CtgrVO(ctgr_name, ctgr_use);
		int insertCnt = ctgrService.updateMember(ctgrVo);

		// 1건이 입력되었을때 : 정상 - memberList 페이지로 이동
		if(insertCnt == 1){
			request.getRequestDispatcher("/memberList").forward(request, response);
		}
			
		// 1건이 아닐때 : 비정상 - 사용자가 데이터를 다시 업력할 수 있도록 등록페이지로 이동
		
		else {
			doGet(request,response);
		}
	}


}
