<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="/js/summernote/summernote-lite.js"></script>
<script src="/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/css/summernote/summernote-lite.css">
<title>Insert title here</title>
<style>
	.dlabel{
		display : inline-block; 
		
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
	#board_title{
		width : 300px;
		height : 50px;
	}
	t {
		font-size: 23px;
		
	}
	#plus{ 
		border-radius : 50%;
		width : 35px;
		height : 35px;
		border-color : blue;
		background-color : rgba(255,255,255,0.5); 
	}
	#sub{
		margin-left : 90%; 
	}
	#filesub{
		margin-left : 15%; 
	}
</style>

<script>
$(document).ready(function() {
	//여기 아래 부분
	$('#board_cont').summernote({
		  height: 400,                 // 에디터 높이
		  minHeight: 400,             // 최소 높이
		  maxHeight: 300,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: "최대 2048자까지 쓸 수 있습니다"	//placeholder 설정
	});

	$('#plus').click(function(){
		$('#filediv').append("")
		
	});
});
</script>

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
		<%-- 
			이미지 파일 보여주기
			다운로드 버튼
		<div class="form-group">
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
		<input type="submit" value="작성완료" id="sub">
		<hr>
		<label for="board_title" class="dlabel"><h3>제목 : </h3></label>
		<input type="text" id="board_title" name="board_title" placeholder="" value="">
		<hr>
		
		
		
		<h3> 내 용 </h3>
		<textarea id="board_cont" name="board_cont"></textarea>
		<hr>
		
		
		<div class="boarddiv" style="display:none">
			<label for="board_seq1" class="dlabel" style="display:none">게시글 번호 : </label>
			
			<input type="text" id="mem_id" name="mem_id" placeholder="사용자 아이디" value="<%= session.getAttribute("mem_id") %>">
			
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
	</form>
	
	
	
	<form action="/attachinsertservlet" method="POST" enctype="multipart/form-data">
		<div>
			<t> 파일 추가  
				<input type="submit" value="등록" id="filesub">
		 	<!-- <input type="button" id="plus" value="+"> -->
			</t>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br><br>
			
			<input type="file" class="file_real_name" id="file_real_name1" name="file_real_name" value=""><br>
			<input type="file" class="file_real_name" id="file_real_name2" name="file_real_name" value=""><br>
			<input type="file" class="file_real_name" id="file_real_name3" name="file_real_name" value=""><br>
			<input type="file" class="file_real_name" id="file_real_name4" name="file_real_name" value=""><br>
			<input type="file" class="file_real_name" id="file_real_name5" name="file_real_name" value=""><br>
		</div>
		
	</form>
	
	
	
</body>
</html>