<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "vo.*" %>
	


      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto active" href="${pageContext.request.contextPath}/HomeController">Home</a></li>
          <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/MemberOneController">${loginMember.memberName}님</a></li>
          <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/BoardListController">Board</a></li>
          <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/LogoutController">logOut</a></li>
        </ul>
      </nav>  

  