<%@ page import="com.bitacademy.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<div id="navigation">
	<ul>
		<li><a href="https://nxver.com/about/">김송현</a></li>
		<li><a href="${pageContext.request.contextPath }/guestbook?a=list">방명록</a></li>
		<li><a href="${pageContext.request.contextPath }/board?a=list">게시판</a></li>
		<li><a href="${pageContext.request.contextPath }/board?a=hello">시간여행</a></li>
	</ul>
</div>