
<%@ page import="com.bitacademy.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<head>
<script src="${pageContext.request.contextPath }/assets/js/script2.js"></script>
<script
	src="${pageContext.request.contextPath }/assets/js/header_hello2021.js"></script>
<script
	src="${pageContext.request.contextPath }/assets/js/header_random_spawn.js"></script>
</head>


<!-- floating message referenced and used from -->
<!-- https://codepen.io/Web_yuki1027/details/KKgQbQE -->
<section class="section">
	<h2 class="section__title">
		Happy New Year<br>
		<span>2021</span>
	</h2>
</section>




<div id="header">
	<ul>
		<c:choose>
			<c:when test="${empty authUser }">
				<li><a
					href="${pageContext.request.contextPath }/user?a=loginform">로그인</a></li>
				<li><a
					href="${pageContext.request.contextPath }/user?a=joinform">회원가입</a></li>
			</c:when>

			<c:otherwise>
				<li><a
					href="${pageContext.request.contextPath }/user?a=updateform&no=${authUser.no }&name=${authUser.name }">회원정보수정</a></li>
				<li><a href="${pageContext.request.contextPath }/user?a=logout">로그아웃</a></li>
				<li>${authUser.name}님안녕하세요^^;</li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>


<!-- https://www.npmjs.com/package/vue-mousefollower-->
<!-- Effect inspired by https://codepen.io/supah/pen/RrzREx -->
