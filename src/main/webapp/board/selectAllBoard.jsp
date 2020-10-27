<%@page import="kr.or.ddit.board.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<%
    List<BoardVO> selectAllBoard = (List<BoardVO>) request.getAttribute("selectAllBoard");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<style>
	#title td {
		font-size:24px;
	}
	#cont td{
		font-size:20px;
	} 

</style>
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
	
		
	<c:set var="selectAllBoard" value="<%= selectAllBoard %>"/>
	<c:set var="boardsize" value="<%= selectAllBoard.size() %>"/>
	<fmt:formatNumber value="${boardsize}" type="number" var="numberType" />
	
	int boardsize : ${ selectAllBoard.size() }
	
	<table border="1">
			<tr id=title>
				<td>게시판 시퀸스</td>
				<td>부모 시퀸스값</td>
				<td>제목</td>
				<td>내용</td>
				<td>작성일</td>
				<td>깊이</td>
				<td>아이디</td>
				<td>카테고리 번호</td>
				<td>삭제여부</td>
				<td></td>
			</tr>
		
		<c:forEach var="i" begin="0" end="${boardsize-1}">
			<tr id="cont">
				<td>${ selectAllBoard.get(i).getBoard_seq1() }</td>
				<td>${ selectAllBoard.get(i).getParent_seq1() }</td>
				<td><a herf="#">${ selectAllBoard.get(i).getBoard_title() }</a></td>
				<td>${ selectAllBoard.get(i).getBoard_cont() }</td>
				<td>${ selectAllBoard.get(i).getBoard_date() }</td>
				<td>${ selectAllBoard.get(i).getBoard_dep() }</td>
				<td>${ selectAllBoard.get(i).getMem_id() }</td>
				<td>${ selectAllBoard.get(i).getCtgr_seq1() }</td>
				<td>${ selectAllBoard.get(i).getBoard_del() }</td>
			</tr>
		</c:forEach>
	</table>
	
	   
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
<%-- 	 
	 	<table>	
	<% 	 
		int memSize = selectAllBoard.size();
		System.out.println(memSize);
		
		if(memSize > 0){
			for(int i=0; i<memSize; i++){
	%>			 
		<tr data-userid="<%= selectAllBoard.get(i).getBoard_seq1() %>">
			<td><%= selectAllBoard.get(i).getBoard_seq1() %></td>
		</tr>	  
	<% 			  
			}
		}else{ // 회원정보가 존재하지 않을 경우...
	%> 
		<tr>
			<td colspan="2">회원정보가 존재하지 않습니다.</td>
		</tr>
	<%	
		}
	%>	
	</table>	  
		 
 --%>


</body>
</html>