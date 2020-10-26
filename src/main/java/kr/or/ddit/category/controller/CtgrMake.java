package kr.or.ddit.category.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.category.model.CtgrVO;
import kr.or.ddit.category.service.CtgrService;
import kr.or.ddit.category.service.CtgrServiceI;
import oracle.jdbc.proxy.annotation.Post;

@WebServlet("/ctgrmake")
public class CtgrMake extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CtgrServiceI ctgrService;
	
	@Override
	public void init() throws ServletException {
		ctgrService = new CtgrService();
	}
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ctgrList");
		  
		List<CtgrVO> ctgrList = ctgrService.selectAllCtgr();
		request.setAttribute("ctgrList", ctgrList);
		request.getRequestDispatcher("/category/ctgrmake.jsp").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctgr_seq1 = request.getParameter("ctgr_seq1");
		String ctgr_name = request.getParameter("ctgr_name");
		String ctgr_use = request.getParameter("ctgr_use");
		
		System.out.println(ctgr_seq1);
		System.out.println(ctgr_name);
		System.out.println(ctgr_use);
	
		
	}

}
