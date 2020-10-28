<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.dlabel{
		display : inline-block;
		margin-left : 50px;
	}
	#modiBtn{
		margin-left : 200px;
	}
	#delBtn{
		margin-left : 50px;
	} 
	#contdiv{
		height : 400px;
	}
	#board_cont{
		margin-left : 40px;
	}
</style>
</head>
<body>
		<!-- 	
			int board_seq1;			//	board_seq1		게시판 시퀸스
			int parent_seq1;		//	parent_seq1		게시판의 부모 시퀸스값
			String board_title;		//	board_title		제목
			String board_cont;		//	board_cont		내용
			Date board_date;		//	board_date		작성일
			int board_dep;			//	board_dep		깊이 
			int board_del;			//  BOARD_DEL		게시판 삭제여부
			String mem_id;			//	mem_id			작성자 아이디
			int ctgr_seq1;			//	ctgr_seq1		카테고리 번호
			
			
			getBoard_seq1()
			getParent_seq1()
			getBoard_title()
			getBoard_cont()
			getBoard_date()
			getBoard_dep()
			getMem_id()
			getCtgr_seq1()
			getBoard_del()
		-->
	
	 
	<form id="frm" class="form-horizontal" role="form" action="/boardinsertservlet" method="POST">
		<%-- <div class="form-group">
			<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
			<div class="col-sm-10">
				<img src="${cp}/profile/${memberVo.filename}"/>

				<img src="${cp}/profileImg?userid=${memberVo.userid}" /><br>
				<button id="profileDownBtn" type="button" class="btn btn-default">다운로드
					:${memberVo.realFilename}</button>
				</a>
			</div>
		</div> --%> 
		<h2>게시글 작성</h2>
		 
		<hr>
		  
		<div class="boarddiv">
			<label for="board_seq1" class="dlabel" style="display:none">게시글 번호 : </label>
			
			<label for="mem_id" class="dlabel">아이디 : </label>
			<input type="text" id="mem_id" name="mem_id" placeholder="사용자 아이디" value="<%= session.getAttribute("mem_id") %>" READONLY>
			
			<br>
		</div>
		<hr>
		
		<div class="boarddiv">
			<label for="board_title" class="dlabel">제목 : </label>
			<input type="text" id="board_title" name="board_title" placeholder="" value="">
				 
			<c:choose>	
				<c:when test="${mem_id eq boardVo.mem_id}">
					<a href="/boardupdateservlet?board_seq1=${boardVo.board_seq1}">
						<button id="modiBtn" type="button">수정</button>
					</a>
					<a href="/boarddeleteservlet?board_seq1=${boardVo.board_seq1}">
						<button id="delBtn" type="button">삭제</button>
					</a>
				</c:when>
				
				<c:otherwise>
					
				</c:otherwise>
			</c:choose>	
			
		</div>
		<hr>
		
		<div id="contdiv" class="boarddiv">
			<label for="board_cont" class="dlabel">내용</label><br>
			<textarea id="board_cont" name="board_cont" placeholder="" cols="100" rows="20" value=""></textarea>
			 
		</div>
		<hr>
		
		<div class="boarddiv" style="display:none">
			<label for="parent_seq1" class="dlabel">부모의 시퀸스 값 : </label>
			<label class="label">${boardVo.parent_seq1}</label>
			
			<label for="board_dep" class="dlabel">깊이 : </label>
			<label class="label">${boardVo.board_dep}</label>
			
			<label for="board_del" class="dlabel">삭제여부 : </label>
			<label class="label">${boardVo.board_del}</label>
			
			<label for="ctgr_seq1" class="dlabel">카테고리 : </label>
			<label class="label">${boardVo.ctgr_seq1}</label>
			<input type="text" name="ctgr_seq1" value="<%= request.getParameter("ctgr_seq1") %>">
		</div>
		
		<input type="submit" value="작성완료">
	</form>
</body>
</html>