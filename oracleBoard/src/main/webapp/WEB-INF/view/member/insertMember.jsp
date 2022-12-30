<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertMemberForm</title>
<!-- Latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/loginCss/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/loginCss/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/loginCss/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/loginCss/css/style.css">
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
              <h3>회원가입</h3>
 
            </div>
            <form action="${pageContext.request.contextPath}/AddMemberController" method="post" id="form">
              <div class="form-group first">
                <label for="username">아이디 </label>
                <input type="text" class="form-control" id="id"name="memberId">
              </div>
               <div class="form-group first">
                <label for="username">이름 </label>
                <input type="text" class="form-control" id="name"name="memberName">
              </div>
              <div class="form-group last mb-4">
                <label for="password">비밀번호 </label>
                <input type="password" class="form-control" id="pw" name="memberPw">
                
              </div>
              <input type="button" value="회원가입" class="btn btn-block btn-primary" id="btn">
            </form>
            </div>
          </div>
          
        </div>
        
      </div>
    </div>
  </div>
  <c:if test="${msg==1}">
  	<script>
  		alert("다른 아이디를 사용해주세요")
  	</script>
  </c:if>
 <script>
  	$('#btn').click(function(){
  		if($('#id').val().length<4){
  			alert("id는 4자 이상이여야합니다");
  			return;
  		}
  		if($('#name').val().length<1){
  			alert("이름을 적어주세요");
  			return;
  		}
  		if($('#pw').val().length<4){
  			alert("pw는 4자이상이여야합니")
  			return;
  		}
  		$('#form').submit();
  		
  	})
  </script>
	
	<script src="${pageContext.request.contextPath}/bootstrap/loginCss/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/loginCss/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/loginCss/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/loginCss/js/main.js"></script>
	
	
</body>
</html>


  
   