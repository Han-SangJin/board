package kr.or.ddit.attachfile.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.attachfile.service.AttachService;
import kr.or.ddit.attachfile.service.AttachServiceI;

@WebServlet("/attachinsertservlet")
@MultipartConfig
public class AttachInsertServlet extends HttpServlet {
	
	private AttachServiceI reviewService;
	private static final Logger logger = LoggerFactory.getLogger(AttachInsertServlet.class);
	  
	
 	@Override
	public void init() throws ServletException {
		reviewService = new AttachService();
	}
 	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String file_real_name = request.getParameter("file_real_name");
		System.out.println("file_real_name : "+file_real_name);
		
		logger.debug("arameter : {}",file_real_name );
		
		Part profile = request.getPart("file_real_name");;
		logger.debug("file : {}", profile.getHeader("Content-Disposition"));
		String realFilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
		String ext = (".").concat(FileUploadUtil.getExtension(realFilename));
		String fileName = "D:\\attachfile\\";
		String filePath = "";
		
		if(profile.getSize() > 0) {
			filePath = "D:\\attachfile\\" + fileName + ext;
			profile.write(filePath);
		}
		
		// 사용자 정보 등록
		AttachVO attachVo = new AttachVO(filePath,realFilename);
		
		int insertCnt = reviewService.insertAttach(attachVo);
			
		 
		/*
		   Forward 는 Web Container 차원에서 페이지의 이동만 존재합니다. 
		   실제로 웹 브라우저는 다른 페이지로 이동했음을 알 수 없습니다. 
		   그렇기 때문에 웹 브라우저에는 최초에 호출한 URL이 표시되고, 이동한 페이지의 URL 정보는 확인할 수 없습니다. 
		   또한 현재 실행중인 페이지와 forward에 의해 호출될 페이지는 Request 객체와 Response 객체를 공유합니다.
		   (페이지만 이동)
		  
		   Redirect 는 Web Container로 명령이 들어오면, 웹 브라우저에게 다른 페이지로 이동하라고 명령을 내립니다. 그러면 웹
		   브라우저는 URL을 지시된 주소로 바꾸고 해당 주소로 이동합니다. 다른 웹 컨테이너에 있는 주소로 이동하며 새로운 페이지에서는
		   Request와 Response객체가 새롭게 생성됩니다.
		   (새로요청)
		 */
		
		// 1건이 입력되었을때 : 정상 - 글작성 게시판으로 이동
		if(insertCnt == 1){
//			request.getRequestDispatcher("/memberList").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/boardinsertservlet");
		}
			
		// 1건이 아닐때 : 비정상 - 사용자가 데이터를 다시 업력할 수 있도록 등록페이지로 이동
		
		else {
			doGet(request,response);
		}
	}

}
