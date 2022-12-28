<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
	
<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/table/css/style.css">

<title>memberOne</title>
</head>
<body>
	<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<br>
	<br>
	<div class="col-md-11" style="margin: auto;">
	<div class="row">
	
		 <div class="col-md-3">
			<div class="card" style="width: 18rem; margin:0 auto; ;">
		  		<img src="${pageContext.request.contextPath}/image/face.png" class="card-img-top">
				<div class="card-body">
				    <h5 class="card-title">이름:&nbsp;${loginMember.memberName}</h5>
				    <p class="card-text">아이디:&nbsp;${loginMember.memberId}</p>
				    <p class="card-text">회원가입일 :&nbsp;${loginMember.updatedate}</p>
				   <div class="btn-group">
					  <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
					    정보수정
					  </button>
					  <ul class="dropdown-menu">
					    <li><a href="${pageContext.request.contextPath}/ModifyMemberController">개인정보 수정</a></li>
					    <li><a href="${pageContext.request.contextPath}/RemoveMemberController">회원탈퇴</a></li>
					  </ul>
					</div>
			    </div>
			  </div>
			 </div>   
			<div class="col-md-9 contents">
			<table class="table table-bordered align-middle" border="1">
				<tr class="mt-4 p-5 bg-primary text-white rounded">
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>이동</th>
				</tr>
				 <c:forEach var="b" items="${list}">
				 	<tr>
				 		<td>${b.title}</td>
				 		<td>${loginMember.memberId}</td>
				 		<td>${b.updatedate}</td>
				 		<td><a href="${pageContext.request.contextPath}/BoardOneController?boardNo="${b.boardNo}>이동</a></td>
				 	</tr>
				 </c:forEach>
			 </table>
	 		</div>
	 	</div>
	 	</div>
	
	
</body>
</html>	   
	  