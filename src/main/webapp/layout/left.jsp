<%@page import="kr.or.ddit.category.model.CtgrVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
    	List<CtgrVO> ctgrList = (List<CtgrVO>) request.getAttribute("ctgrList");
%>        
dfdfdfdsfsdfsdfsd
<c:set var="ctgrList" value="<%=ctgrList %>"/>    
    
<%-- 	<c:forEach var="movie" items="${ctgrList}" varStatus="status">
		<ul class="nav nav-sidebar">
			<li class="active"><a>${status.ctgr_name } <span class="sr-only">(current)</span></a></li>
			<li class="active"><a>${status.ctgr_use }</a></li>
		</ul>  
	</c:forEach> --%>
	

<%--  
 	<c:forEach var="i" begin="0" end="${fn:length(ctgrList)-1}">
			${ctgrList[i]}<br>
	</c:forEach>  --%>