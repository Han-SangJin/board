<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
    <div class="col-sm-9">
      <h2>I Love Login</h2>
     	<label>ID :</label>   <input type="text"> <br>
      	<label>PASS :</label> <input type="text"> <br>
      
      	<br><br><br><br>
      	<input type="button" class="btn btn-success" value="로그인">
      	<input type="button" class="btn btn-success" value="회원가입"><br><br><br><br><br><br><br>
      	 
      	<br><br><br><br><br><br><br>
      <h4><small>2020.10.24</small></h4>
     
</body>
</html>
