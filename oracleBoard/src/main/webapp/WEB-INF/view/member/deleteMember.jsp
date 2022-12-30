<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
	 <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/bootstrap/homepage/assets/css/style.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
	   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700,900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/insert/fonts/icomoon/style.css">


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/insert/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/insert/css/style.css">
<title>memberdelete</title>
</head>
<body>
<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
</div>
	 <div class="content">
    
    <div class="container">
      <div class="row align-items-stretch justify-content-center no-gutters">
        <div class="col-md-7">
          <div class="form h-100 contact-wrap p-5">
            <h3 class="text-center">회원탈퇴 </h3><br>
            <div> ${loginMember.memberName}님 회원탈퇴 </div><br>
            <form class="mb-5" method="post" action="${pageContext.request.contextPath}/RemoveMemberController">
            	<input type="hidden" name= "memberId"value = "${loginMember.memberId}">
                <div class="row">
	                <div class="col-md-12 form-group mb-3">
	                  <label for="budget" class="col-form-label">비밀번호 확인 </label>
	                  <input type="password" class="form-control" name="memberPw" id="subject" placeholder="password ">
	                </div>
              	</div>
				<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h1 class="modal-title fs-5" id="staticBackdropLabel">정말 탈퇴하시겠습니까?</h1>
					        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">다시 생각하기</button>
					        <button type="submit" class="btn btn-primary">네 충분히 확인했습니다</button>
					      </div>
					    </div>
					  </div>
					</div>
	   			 <br>
              <div class="row justify-content-center">
                <div class="col-md-5 form-group text-center">
                  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" class="btn btn-block btn-primary rounded-0 py-2 px-4">탈퇴하기</button>
                
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>


  </div>
  <c:if test="${msg==1}">
  	<script>
  		alert("비밀번호를 확인해주세요")
  	</script>
  </c:if>
  

    <script src="${pageContext.request.contextPath}/bootstrap/insert/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/insert/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/insert/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/insert/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/insert/js/main.js"></script>
</body>
</html>