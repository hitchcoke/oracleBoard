<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
 <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <link href="${pageContext.request.contextPath}/bootstrap/homepage/assets/css/style.css" rel="stylesheet">
<title>BoardOne</title>

</head>
<body>
	<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>

   <div class="container px-11">
   
   <div class="row">
 
   <div>
   <br><br>
	   <h1 style="float:left" class="scrollto">${board.boardTitle}</h1>
	   	<br>
	  	
		<table class="table" border= "1">
			<tr>
				<th class="bg-primary text-white" width=10%>작성자</th>
				<td>${board.memberId}</td>
			</tr><tr>
				<th class="bg-primary text-white">작성일자</th>
				<td>${board.updatedate} <span style="float:right">조회:&nbsp;&nbsp;${board.boardView}</span></td>
			</tr>
		</table>
		
		<textarea id="textarea" readonly="readonly" style="height:200px; width:100%">${board.boardContent}</textarea>
	</div>
	<br>
	<br>
	  <c:if test="${board.memberId.equals(loginMember.memberId)}">
		<div style="float:right">
		<button type="button" class="btn btn-outline-primary" onclick="location.href='${pageContext.request.contextPath}/ModifiyBoardController?boardNo=${board.boardNo}'">수정</button>
		<button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">삭제</button>
		</div>
	</c:if>
	
	
	<h2 class="scrollto">댓글</h2>
	<div>
	<table width=100%>
		<c:forEach var="re" items="${list}">
		
			<tr>
				<th>${re.memberId}</th>
			</tr>
			<tr style="background-color:#E6E6E6">
				<td>${re.recommentContent}</td>		
			</tr>
			<tr style="background-color:#E6E6E6">
				<td>${re.createdate}
				<c:if test="${re.memberId.equals(loginMember.memberId)}">
				<span style="float:right"><a href="${pageContext.request.contextPath}/RemoveRecommentController?recommentNo=${re.recommentNo}&boardNo=${board.boardNo}">삭제</a></span></c:if>
				</td>
			</tr>
			
			
		</c:forEach>
	</table>
	</div>
	<br>
	<form method= "post" action="${pageContext.request.contextPath}/AddRecommentController" id="form">
		<h4>${loginMember.memberId}</h4>
		<input type="hidden" name="boardNo" value="${board.boardNo}">
		<textarea class="form-control" name="recommentContent" id="message" cols="30" rows="4"  placeholder="댓글적기"></textarea><br>
		<button type="button" id="btn"class="btn btn-outline-primary">작성</button>
	</form>
	 <script>
  	$('#btn').click(function(){
  		
  		if($('#message').val().length<1){
  			alert("내용을 적어주세요")
  			return;
  		}
  		$('#form').submit();
  		
  	})
  </script>
	
	</div>
	</div>
	<Br>
	<br>
	<br>


<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">정말 삭제하시나요</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">아니요</button>
        <button type="button" class="btn btn-outline-primary" onclick="location.href='${pageContext.request.contextPath}/RemoveBoardController?boardNo=${board.boardNo}'">네</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>
