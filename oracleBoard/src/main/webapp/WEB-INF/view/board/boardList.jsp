<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	 <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
 	 <link href="${pageContext.request.contextPath}/bootstrap/homepage/assets/css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/table/css/style.css">
</head>
<body>
<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
		</div>

	<div class="col-md-11" style="margin: auto;">
	<h1 style="float:left" class="scrollto">BoardList</h1>
	
		<table class="table table-bordered align-middle">
			<tr class="mt-4 p-5 bg-primary text-white rounded">
				<th width=15%>boardNo</th>
				<th>boardTitle</th>
				<th width=20%>createdate</th>
			</tr>
		<c:forEach var="b" items="${list}">
			<tr>
				<td>${b.boardNo}</td>
				<td><a href="${pageContext.request.contextPath}/BoardOneController?boardNo=${b.boardNo}">${b.boardTitle}</a></td>
				<td>${b.createdate}</td>
			</tr>
		</c:forEach>
		</table>
		
	<div>
		<nav aria-label="Page navigation example">
  			<ul class="pagination justify-content-center">
  				<c:if test="${currentPage > 1}">
	   				<li class="page-item">
	   			</c:if>				
	   			<c:if test="${currentPage <= 1 }">
	   				<li class="page-item disabled"></c:if>	
	      				<a class="page-link" href="${pageContext.request.contextPath}/BoardListController?rowPerPage=${rowPerPage}&currentPage=${currentPage-1}">Previous</a>
	    			</li>

	    		<c:if test="${currentPage <= lastPage}">
	    			<li class="page-item"></c:if>
	    		<c:if test="${currentPage > lastPage}">
	    			<li class="page-item disabled"></c:if>
	      		   		<a class="page-link" href="${pageContext.request.contextPath}/BoardListController?rowPerPage=${rowPerPage}&currentPage=${currentPage+1}">Next</a>
	    			</li>				
 	   		</ul>
	   </nav></div>
	   <div width=100%>
		<button type="button" class="btn btn-outline-primary" onclick="location.href='${pageContext.request.contextPath}/AddBoardController'">게시글작성 </button>
			 <span style="float:right">
			 	<form id="pageForm" method="get" action="${pageContext.request.contextPath}/BoardListController">
					<input type="hidden" name="currnetPage" value="${currentPage}">
					<select name="rowPerPage" id="rowPerPage">
			
						<c:if test="${rowPerPage == 10}">
							<option value="10" selected="selected">10개씩</option>
							<option value="20">20</option>
							<option value="30">30</option>
						</c:if>
						<c:if test="${rowPerPage == 20}">
							<option value="10">10</option>
							<option value="20" selected="selected">20개씩</option>
							<option value="30">30</option>
						</c:if>
						<c:if test="${rowPerPage == 30}">
							<option value="10">10</option>
							<option value="20">20</option>
							<option value="30" selected="selected">30개씩</option>
						</c:if>
					</select>
					<input type="text" name="searchtitle" value="${searchtitle}">
					<button type="submit" class="btn btn-outline-primary">검색</button>
				</form>
			</span>
	   </div>
	</div>
	<br>
	<br>
	<br>
	
</body>
</html>
