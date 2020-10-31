<%@page import="kr.or.ddit.attachfile.model.AttachVO"%>
<%@page import="java.util.List"%>
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
	#filedel{
		margin-left : 15%; 
	
	}
</style>

<script>
$(document).ready(function() {
	//여기 아래 부분
	//$('#board_content').summernote('code', '${board_data.BOARD_CONTENT}');
	$('#board_cont').summernote('editor.insertText', "${board_data.BOARD_CONTENT}")
	
	$('#board_cont').summernote({
		  height: 400,                 // 에디터 높이
		  minHeight: 400,             // 최소 높이
		  maxHeight: 300,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: "최대 2048자까지 쓸 수 있습니다"	//placeholder 설정
	});
});
    // 파일 초기화
 	function fileReset(form){
 		document.getElementById("a").value = ""
 		document.getElementById("b").value = ""
 		document.getElementById("c").value = ""
 		document.getElementById("d").value = ""
 		document.getElementById("e").value = ""

    }
</script>

</head>
<body>
	<form id="frm" class="form-horizontal" role="form" action="/boardupdateservlet?board_seq1=${boardVo.board_seq1}" method="POST" enctype="multipart/form-data">
		
		<h2>${boardVo.board_seq1} 번 게시글 수정</h2>
		
		<input type="submit" value="작성완료" id="sub">
		<hr>
		<label for="board_title" class="dlabel" value=""><h3>제목 수정 : </h3></label>
		<input type="text" id="board_title" name="board_title" placeholder="${boardVo.board_title}" value="">
		<hr>
		
		
		<h3> 내 용 수 정</h3>
		<textarea id="board_cont" name="board_cont" placeholder="" value="">${boardVo.board_cont}</textarea>
		<hr>
		
		
		<t> 파일 수정 </t>	<br>
	 	<%
    		List<AttachVO> attachList = (List<AttachVO>) request.getAttribute("attachList");
    	%>   
	 	
		<input id="filedel" type="button" value="목록 초기화" onclick="fileReset(this.form);">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br><br>
	
		
		<% 	 
			int attachsize = attachList.size();
		%>
				
				<input type="text" name="attachsize" value="<%= attachsize %>">
		<%		
			if(attachsize > 0){
				for(int i=0; i<attachsize; i++){
		%>
				<input type="file" id="file + ${i}" class="infile" name="file_real_name" value="<%= attachList.get(i).getFile_name() %>"><%= attachList.get(i).getFile_real_name() %>
				<input data-userid="<%= attachList.get(i).getFile_seq1() %>" type="button" id="del + ${i}" class="infile" name="file_real_name" value="삭제"><br><hr>
			 
		<%
				}	
			}else{ // 회원정보가 존재하지 않을 경우...
		%>
						<a>등록된 파일이 존재하지 않습니다.</a>
			<%	
				}
			%>

 
		
		<div class="boarddiv" style="display:none">
			<input type="text" name="board_seq1" value="${boardVo.board_seq1}">
			<input type="text" name="ctgr_seq1" value="<%= request.getParameter("ctgr_seq1") %>">
		</div>
	
	</form>
</body>
</html>