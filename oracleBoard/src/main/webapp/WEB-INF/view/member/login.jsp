<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<!-- Latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
	
<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/loginCss/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/loginCss/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/loginCss/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/loginCss/css/style.css">
    <script>
	  $(document).ready(function() {
	  	$('#pw').blur(function){
	  		if ($('#id').val().length<1||$('#pw').val().length<1){
	  			$('#msgs').text("올바르게 채워주세요");
	  			$('#id').focus();
	  		}
	  		
	  	})
	  }
	  	
  </script>
 
</head>
<body>
	<div class="content">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <img src="${pageContext.request.contextPath}/image/undraw_remotely_2j6y.svg" alt="Image" class="img-fluid">
        </div>
        <div class="col-md-6 contents">
          <div class="row justify-content-center">
            <div class="col-md-8">
              <div class="mb-4">
              <h3>로그인</h3>
 
            </div>
            <form action="${pageContext.request.contextPath}/LoginController" method="post">
              <div class="form-group first">
                <label for="username">아이디 </label>
                <input type="text" class="form-control" id="id" name="memberId">
              </div>
             
              <div class="form-group last mb-4">
                <label for="password">비밀번호 </label>
                <input type="password" class="form-control" id="pw" name="memberPw">
                
              </div>
                <a href="${pageContext.request.contextPath}/AddMemberController">회원가입 </a>
              <input type="submit" value="로그인" class="btn btn-block btn-primary">
            </form>
            </div>
          </div>
          <span id = "msgs" class="msgs"></span>
          
        </div>
        
      </div>
    </div>
  </div>
  <c:if test="${msg==1}">
  	<script>
  		alert("아이디 비밀번호를 확인해주세요")
  	</script>
  </c:if>

 
	
	<script src="${pageContext.request.contextPath}/bootstrap/loginCss/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/loginCss/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/loginCss/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/loginCss/js/main.js"></script>
	
	
</body>
</html>


  
   