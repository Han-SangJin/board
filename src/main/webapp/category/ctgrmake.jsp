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
</head>
<body>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>블로그</h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="#section1">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/boardmake">게시판 생성</a></li>
        <li><a href="#section3">자유 게시판</a></li>
        <li><a href="#section3">공지 게시판</a></li>
      </ul><br>
  
    </div>
 
    <div class="col-sm-9">
      <h4><small>Board Make</small></h4>
      <hr>
    
        <table class="table table-striped">
				 <tr> 
				 	<td><h4>카테고리 번호</h4></td>
				 	<td><h4>카테고리 이름</h4></td>
				 	<td><h4>카테고리 사용여부</h4></td>
				 	<td><h4>생성/삭제</h4></td>
				 </tr>
				 <tr> 
				 	<form id="ctgrfm" action="${cp }/CtgrMake" method="POST" enctype="multipart/form-data">
				 	<td><p> 게시판 이름 : </p></td>
				 	<td><input type="text" name="ctgrname" value=""></td>
				 	<td><p>
				 	<select name="ctgruse">
			      		<option value=1>사용</option>
			      		<option value=2>미사용</option>
			        </select></p></td>
				 	<td><input type="submit"value="생성"></td>
				 	</form>
				 </tr>
				 
				 <tbody id="ctgrList">
				 
				<% 	 
					int ctgrSize = ctgrList.size();
					if(ctgrSize > 0){
						for(int i=0; i<ctgrSize; i++){
				%>			 
					<tr data-userid="<%= ctgrList.get(i).getCtgr_seq1() %>">
						<td><%= ctgrList.get(i).getCtgr_seq1() %></td>
						<td><%= ctgrList.get(i).getCtgr_name() %></td>
						
						<td>
						<select>
					   <% if(ctgrList.get(i).getCtgr_use() == 1){ %>
						<option>사용</option>
					   <%} else if(ctgrList.get(i).getCtgr_use() == 2){ %>
						<option>미사용</option>
						<%} %>
						</select>
						</td>
						
						<td><input type="button" value="삭제"></td>
						
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
    
    
    
  
    </div>
  </div>
</div>

<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

</body>
</html>
