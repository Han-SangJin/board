package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.attachfile.service.AttachService;
import kr.or.ddit.attachfile.service.AttachServiceI;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardupdateservlet")
@MultipartConfig
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceI boardService;
	private AttachServiceI attchService;
	
	BoardVO boardVo;
	List<AttachVO> attachList;
	AttachVO attachVo;
	String path = "";
	String real = "";
	
	  
 	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		attchService = new AttachService();
	}
 	
 	// 수정할 정보를 업데이트 페이지로 가져옴
 	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		request.setCharacterEncoding("utf-8");
 		
 		// 업데이트 jsp 에서 카테고리 번호와 게시판 번호를 가지고 와서
 		// 그번호에 맞는 게시판의 정보를 다시 불러온다.
 		
 		// 게시글 내용
 		int board_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
 		boardVo = boardService.selectBoard(board_seq1);
 		
 		// 파일 목록
 		attachList = attchService.selectAllAttach(board_seq1);
 		
		
 		// 가져온 정보를 업데이트 화면에 뿌려줌
		request.setAttribute("boardVo", boardVo);
		request.setAttribute("attachList", attachList);
 		request.getRequestDispatcher("/board/updateBoard.jsp").forward(request, response);
	}
	
 	
 	// 수정한 정보를 DB에 저장
	//	int file_seq1;				// 파일 번호
	//	String file_name;			// 파일 key값 부여한 이름
	//	String file_real_name;		// 파일 원래이름
 	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		request.setCharacterEncoding("utf-8");
 		int board_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
 		System.out.println("board_seq1 + " +board_seq1);
		String board_title = (String) request.getParameter("board_title");
		System.out.println("board_title + " +board_title);
		String board_cont = request.getParameter("board_cont");
		System.out.println("board_cont + " +board_cont);
		int attachsize = Integer.parseInt(request.getParameter("attachsize"));

		
		// 게시판 정보 등록
		BoardVO boardVo = new BoardVO(board_seq1,board_title,board_cont);
		int boardCnt = boardService.updateBoard(boardVo);
		
	
		
		System.out.println("attachsize : " +attachsize);
		// 파일이 없으면 실행하지 않음
		if(attachsize == 0) {
			System.out.println("수정 파일 없음");
		
		// 파일이 있는 경우에만 실행	
		}else {
			
			// 파일정보 보내기
			int i = 0;
			List<AttachVO> attachList = new ArrayList<>();
			
			for (Part profile : request.getParts()) {
				String file_real_name = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
				System.out.println("profile.getHeader(\"Content-Disposition\")"+ profile.getHeader("Content-Disposition"));
				String file_seq = FileUploadUtil.getfile_seq(profile.getHeader("Content-Disposition"));
				int file_seq1 = Integer.parseInt(file_seq);
				String ext = (".").concat(FileUploadUtil.getExtension(file_real_name));
				String fileName = UUID.randomUUID().toString();
				String file_name = "";
				
				
				if(profile.getSize() > 0) {
					file_name = "D:\\attachfile\\" + fileName + ext;
					profile.write(file_name);
				}
				
				if (profile.getSize()>0 && !file_name.equals("") && !file_real_name.equals("") ){
					i++;
//					System.out.println(i);
					System.out.println("file_name : " + file_name);
					System.out.println("realFilename : " + file_real_name);
					System.out.println("file_seq1 : " + file_seq);
					
					AttachVO attachVo = new AttachVO(file_name,file_real_name);
					attachList.add(attachVo);
				}
		    }
			
			// 파일 정보 업뎃
			int attachCnt = attchService.updateBoard(attachList);
			
			
			if(boardCnt >= 1 && attachCnt >= 1){
//			response.sendRedirect(request.getContextPath() + "/board/boardselectservlet?board_seq1=" + board_seq1);
				request.getRequestDispatcher("/board/boardselectservlet?board_seq1=\" + board_seq1").forward(request, response);
			}else {
				doGet(request,response);
			}
		}
		
		
		
	}
}
