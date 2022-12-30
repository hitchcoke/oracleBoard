<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/insert/fonts/icomoon/style.css">


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/insert/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/insert/css/style.css">
<title>Boardupdate</title>
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
            <h3 class="text-center">boardUpdate </h3><br>
            <div> ${loginMember.memberId}님 게시글 수정 </div><br>
            <form class="mb-5" method="post" action="${pageContext.request.contextPath}/ModifiyBoardController" id="form">
            	<input type="hidden" name= "boardNo" value="${b.boardNo}">
                <div class="row">
	                <div class="col-md-12 form-group mb-3">
	                  <label for="budget" class="col-form-label">제목 </label>
	                  <input type="text" class="form-control" name="boardTitle" id="subject" placeholder="${b.boardTitle } ">
	                </div>
              	</div>
	              <div class="row mb-5">
	                <div class="col-md-12 form-group mb-3">
	                  <label for="message" class="col-form-label">내용 </label>
	                  <textarea class="form-control" name="boardContent" id="message" cols="30" rows="4"  placeholder="${b.boardContent}"></textarea>
	                </div>
	             </div>
              	

   			 <br>
              <div class="row justify-content-center">
                <div class="col-md-5 form-group text-center">
                  <button type="button" id="btn" class="btn btn-block btn-primary rounded-0 py-2 px-4">수정하기</button>
                
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

  </div>
   <script>
  	$('#btn').click(function(){
  		if($('#subject').val().length<4){
  			alert("제목은 4자 이상이여야합니다");
  			return;
  		}
  		if($('#message').val().length<1){
  			alert("내용을 적어주세요")
  			return;
  		}
  		$('#form').submit();
  		
  	})
  </script>
  

    <script src="${pageContext.request.contextPath}/bootstrap/insert/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/insert/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/insert/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/insert/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/insert/js/main.js"></script>
</body>
</html>