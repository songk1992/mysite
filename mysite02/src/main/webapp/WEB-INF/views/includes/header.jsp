
<%@ page import="com.bitacademy.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<style>

icon-big {
    padding-left: 30%;
    font-size: 350%;
    display: block;
    color: #9a7a44;
    margin-bottom: 10px;
    transform: scale(1);
}

icon-big:hover {
    padding-left: 35%;
    font-size: 350%;
    display: block;
    color: #9a7a44;
    margin-bottom: 10px;
    transition: transform 0.5s, padding-left 0.5s;
    transform: scale(1.15);
}
</style>



<div id="header">
	<h1>MySite</h1>
	<icon-big><ion-icon name="walk-outline"></ion-icon></icon-big>
	
	
	
	
	<div class="wrap">
  <div class="bg"></div>
  <h1>Take a look around</h1>
</div>
	
	
	
	
	
	
	

	<ul>
		<c:choose>
			<c:when test ="${empty authUser }">
				<li><a href="${pageContext.request.contextPath }/user?a=loginform">로그인</a></li>
				<li><a href="${pageContext.request.contextPath }/user?a=joinform">회원가입</a></li>

			</c:when>
			
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath }/user?a=updateform&no=${authUser.no }&name=${authUser.name }">회원정보수정</a></li>
				<li><a href="${pageContext.request.contextPath }/user?a=logout">로그아웃</a></li>
				<li>${authUser.name}님 안녕하세요 ^^;</li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>


<!-- https://www.npmjs.com/package/vue-mousefollower-->
<!-- Effect inspired by https://codepen.io/supah/pen/RrzREx -->
