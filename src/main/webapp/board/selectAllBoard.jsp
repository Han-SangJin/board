<%@page import="kr.or.ddit.board.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<%
    List<BoardVO> selectAllBoard = (List<BoardVO>) request.getAttribute("selectAllBoard");
%>    

	<c:set var="selectAllBoard" value="<%= selectAllBoard %>"/>
	<c:set var="boardsize" value="<%= selectAllBoard.size() %>"/>
	<fmt:formatNumber value="${boardsize}" type="number" var="numberType" />
    
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
	.title {
		width : 600px;
	}
	.date {
		width : 200px;
	}
	.id {
		width : 150px;
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

	<a href="/boardinsertservlet?ctgr_seq1=${ctgr_seq1}"><input type="button" value="새로운 글 등록"></a>
	
	int boardsize : ${ selectAllBoard.size() }
 	page : ${page}
 	pages : ${pages}
 	ctgr_seq1 : ${ctgr_seq1}
 	
 	<c:set var="ctgr_seq1" value="${ctgr_seq1}" scope="session"/>
 	

 	 
	<br><br>

	<table border="1">
			<tr id=title>
				<!-- <td>게시판 시퀸스</td> -->
				<!-- <td>부모 시퀸스값</td> -->
				<td class="title">제목</td>
				<!-- <td>내용</td> -->
				<td>작성일</td>
				<!-- <td>원글의 시퀸스</td> -->
				<td>아이디</td>
				<!-- <td>카테고리 번호</td> -->
				<!-- <td>삭제여부</td> -->
				<td></td>
			</tr>
		
		<c:choose>
			<c:when test="${boardsize > 0}">
				<c:forEach var="i" begin="0" end="${boardsize-1}">
					<tr id="cont">
						<c:choose>
							<c:when test="${ selectAllBoard.get(i).getBoard_del() == 2 }">
								<%-- <td>${ selectAllBoard.get(i).getBoard_seq1() }</td> --%>
								<%-- <td>${ selectAllBoard.get(i).getParent_seq1() }</td> --%>
								<td class="title"> 삭제된 게시물 입니다.</td>
								<%-- <td>${ selectAllBoard.get(i).getBoard_cont() }</td> --%>
								<td class="date"> </td>
								<%-- <td>${ selectAllBoard.get(i).getBoard_dep() }</td> --%>
								<td class="id"> </td>
								<%-- <td>${ selectAllBoard.get(i).getCtgr_seq1() }</td> --%>
								<%-- <td>${ selectAllBoard.get(i).getBoard_del() }</td> --%>
							</c:when>
							<c:otherwise>
								<%-- <td>${ selectAllBoard.get(i).getBoard_seq1() }</td> --%>
								<%-- <td>${ selectAllBoard.get(i).getParent_seq1() }</td> --%>
								<%-- <td><a href="/boardselectservlet?board_seq1=${selectAllBoard.get(i).getBoard_seq1()}&ctgr_seq1=${selectAllBoard.get(i).getCtgr_seq1()}">${selectAllBoard.get(i).getBoard_title()}</a></td>  --%>
								<td class="title"><a href="/reviewselectallservlet?board_seq1=${selectAllBoard.get(i).getBoard_seq1()}">${selectAllBoard.get(i).getBoard_title()}</a></td>
								<%-- <td>${ selectAllBoard.get(i).getBoard_cont() }</td> --%>
								<td class="date">${ selectAllBoard.get(i).getBoard_date() }</td>
								<%-- <td>${ selectAllBoard.get(i).getBoard_dep() }</td> --%>
								<td class="id">${ selectAllBoard.get(i).getMem_id() }</td>
								<%-- <td>${ selectAllBoard.get(i).getCtgr_seq1() }</td> --%>
								<%-- <td>${ selectAllBoard.get(i).getBoard_del() }</td> --%>
							</c:otherwise>	
						</c:choose>
					</tr>
				</c:forEach> 
			</c:when>
			<c:otherwise>
				글 목록이 존재하지 않습니다.
			</c:otherwise>
		</c:choose>
	</table>
	
	<div class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${1 < page}">
					<li><a href="/boardselectallservlet?page=1&ctgr_seq1=${ctgr_seq1}&pageSize_str=${pages}">◀◀</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/boardselectallservlet?page=${page}&ctgr_seq1=${ctgr_seq1}&pageSize_str=${pages}">◀◀</a></li>
				</c:otherwise>
			</c:choose>	
		
			<c:choose>
				<c:when test="${1 < page}">
					<li><a href="/boardselectallservlet?page=${page-1}&ctgr_seq1=${ctgr_seq1}&pageSize_str=${pages}">◀</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/boardselectallservlet?page=${page}&ctgr_seq1=${ctgr_seq1}&pageSize_str=${pages}">◀</a></li>
				</c:otherwise>
			</c:choose>	
			
				<c:forEach var="i" begin="1" end="${pages }">
					<c:choose>
						<c:when test="${i == page}">
							<li class="active"><span>${i}</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="/boardselectallservlet?page=${i}&ctgr_seq1=${ctgr_seq1}&pageSize_str=${pages}">${i}</a></li>
						</c:otherwise>
							  
					</c:choose>				
				</c:forEach>
			
			<c:choose>
				<c:when test="${page < pages}">
					<li><a href="/boardselectallservlet?page=${page+1}&ctgr_seq1=${ctgr_seq1}&pageSize_str=${pages}">▶</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/boardselectallservlet?page=${page}&ctgr_seq1=${ctgr_seq1}&pageSize_str=${pages}">▶</a></li>
				</c:otherwise>
			</c:choose>	
			
			<c:choose>
				<c:when test="${page < pages}">
					<li><a href="/boardselectallservlet?page=${pages}&ctgr_seq1=${ctgr_seq1}&pageSize_str=${pages}">▶▶</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/boardselectallservlet?page=${page}&ctgr_seq1=${ctgr_seq1}&pageSize_str=${pages}">▶▶</a></li>
				</c:otherwise>
			</c:choose>	
		
			
		</ul>
	</div>
</body>
</html>