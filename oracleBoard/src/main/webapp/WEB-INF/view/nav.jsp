<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "vo.*" %>

<nav class="navbar navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/HomeController"><span>&nbsp;&nbsp;&nbsp;</span>홈</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/MemberOneController"><span>&nbsp;&nbsp;&nbsp;</span>${loginMember.memberName}님  </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/BoardListController"><span>&nbsp;&nbsp;&nbsp;</span>게시판</a>
        </li>
       
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/LogoutController"><span>&nbsp;&nbsp;&nbsp;</span>로그아웃 </a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>

    