<%@page import="kr.or.ddit.category.model.CtgrVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    	List<CtgrVO> ctgrList = (List<CtgrVO>) request.getAttribute("ctgrList");
    %>        
    
<!DOCTYPE html>
<html lang="UTF-8">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
    label{
    	width : 100px;
    }
    
  </style>
<script>
/* $(document).ready(function(){
	$("#ctgrList #update").on("click", function(){
	// data-userid
	var ctgeseq1 = $(this).data("ctgeseq1");
	//alert("ctgeseq1 : " + ctgeseq1); 
	//alert($("select[name=use]").val());

	/* document.location="/member?userid=" + userid; 
})

*/
/*
	$("#ctgrList #delete").on("click", function(){
	// data-userid
	var ctgeseq2 = $(this).data("ctgeseq2");
	/* alert("ctgeseq2 : " + ctgeseq2); */
		
	/* document.location="/member?userid=" + userid; 
	})
})  */   
		  
$(function(){

	var se = document.getElementBuId("used");
	alert(se)
	
	 $("#ctgrList #update").click(function(){
		var email = $("#used option:selected").text();
		alert(email)
	)}; 
});    
</script>
</head>
<body>

  <div class="row content">
  
  
   
  
     <div class="col-sm-3 sidenav">
      <h4>블로그</h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="#section1">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/ctgrinsertservlet">게시판 생성</a></li>
        <li><a href="#section3">자유 게시판</a></li>
        <li><a href="#section3">공지 게시판</a></li>
      </ul><br>
  
    </div>
 	 
    <div class="col-sm-9">
      <h4><small>게시판 목록</small></h4>
      <hr>
      
      
      
    <div class="col-sm-9">
      <h4><small>Board Make</small></h4>
      <hr>
    
		<form id="ctgrfm" action="${pageContext.request.contextPath}/ctgrinsertservlet" method="post">
        <table class="table table-striped">
				 <tr> 
				 	<td><h4>카테고리 번호</h4></td>
				 	<td><h4>카테고리 이름</h4></td>
				 	<td><h4>카테고리 사용여부</h4></td>
				 	<td><h4>생성/삭제</h4></td>
				 </tr>
				 <tr>   
				 	<td><p> 게시판 이름 : </p></td>
				 	<td><input type="text" name="ctgr_name" value=""></td>
				 	<td><p>
				 	<select name="ctgr_use" id="ctgr_use">
			      		<option value="1">사용</option>
			      		<option value="2">미사용</option>
			        </select></p></td>
				 	<td><input type="submit"value="생성"></td>
				 </tr>
				  
				 
				 <tbody id="ctgrList">
				  
				<% 	 
					int ctgrSize = ctgrList.size();
					if(ctgrSize > 0){
						for(int i=0; i<ctgrSize; i++){
				%>			 
					<tr>
						<td><%= ctgrList.get(i).getCtgr_seq1() %></td>
						<td><%= ctgrList.get(i).getCtgr_name() %></td>
						
						<td>
						<select name="use" id="used">
						
						
					    <% if(ctgrList.get(i).getCtgr_use() == 1){ %>
						<option>사용</option>
					   <%} else if(ctgrList.get(i).getCtgr_use() == 2){ %>
						<option>미사용</option>
						<%} %> 
						
						
						<option value="1">사용</option>
			      		<option value="2">미사용</option>
						
						    <%-- <option value=1 <c:if test="${ctgr_use == 1}">selected</c:if>>사용</option>
		                    <option value=2 <c:if test="${ctgr_use == 2}">selected</c:if>>미사용</option>  --%>
		
						</select>
						</td>
						
						<td>
						<input id="update" type="button" value="수정" data-ctgeseq1="<%= ctgrList.get(i).getCtgr_seq1() %>">
						<input id="delete" type="button" value="삭제" data-ctgeseq2="<%= ctgrList.get(i).getCtgr_seq1() %>"></td>
						 
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
				</tbody>
				
			</table>
    		</form>
    
    
  
    </div>
  </div>
</div>

<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

</body>
</html>
