<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">

		<!-- header -->
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />


		<div id="content">
			<div id="board">

		<!-- 찾기 기능 -->
		<form id="search_form" action="" method="post">
			<input type="text" id="kwd" name="kwd" value=""> <input
				type="submit" value="찾기">
		</form>

		<!-- 게시판 -->
		

		
		<!-- 보여주는 글 숫자 조절 현재는 10개씩 보여줌-->
		<c:set var = "pageamountOfarticles" scope = "session" value = "5"/>
		<!--<c:out value = "${pageamountOfarticles }"/>-->



		
		
		<table class="tbl-ex">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
				<th><ion-icon name="thumbs-up-outline"></ion-icon></th>
				<th><ion-icon name="thumbs-down-outline"></ion-icon></th>
				<th>&nbsp;</th>
			</tr>
		

			<c:forEach items='${list }' var='vo' varStatus='status'>
				<tr>
					<td>${status.count }</td>
					<td style='text-align:left; padding-left:${vo.depth*9 }px'>
					
					<c:choose>
					<c:when test ="${vo.depth>1}">
							<ion-icon name="return-down-forward-outline"></ion-icon>
					</c:when>
					<c:otherwise>
					</c:otherwise>
					</c:choose>
					
					
					<a href="${pageContext.request.contextPath }/board?a=view&no=${vo.no }">${vo.title }</a>
            
					
					</td>
					<td>${vo.userName } </td>

					<td>${vo.regDate } </td>
					<td>${vo.hit } </td>
					<td>${vo.good } </td>
					<td>${vo.notGood } </td>
					
					<td>
						
						<!--  TODO : 지우기 기능 -->
						<c:choose>
						<c:when test ="${authUser.no == vo.userNo}">
						<ion-icon name="trash-outline"></ion-icon>
						</c:when>
						
						<c:otherwise>
						</c:otherwise>
						</c:choose>
					</td>
					
	
					
					
					
					
				</tr>
			</c:forEach>
		</table>

		<!-- pager 추가 -->
		<div class="pager">
		
		<ul>
		
			<li><ion-icon name="chevron-back-outline"></ion-icon></li>
		    <c:forEach var="i" begin="1" end="5" step="1">
            <li>
            <a href="${pageContext.request.contextPath }/board?a=list&pagenumber=${i }&pageamountOfarticles=${pageamountOfarticles }">${i }</a>
            </li>
          	</c:forEach>
          	<li><ion-icon name="chevron-forward-outline"></ion-icon></li>
          	
		</ul>		
		</div>
		<!-- pager 추가 -->


		
		
		<!-- 글쓰기  -->
		<c:choose>
			<c:when test ="${empty authUser }">
			<center>글쓰기는 회원 가입 후에 가능</center>
			
			</c:when>
			
			<c:otherwise>
			<div class="bottom"><a href="${pageContext.request.contextPath }/board?a=write" id="new-book"><ion-icon name="pencil-outline"></ion-icon></a>
						</div>
			</c:otherwise>
		</c:choose>
		
		
		
		
			</div>
		</div>
		<!-- navigation -->
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

	</div>
	
	
	<!-- 이모티콘 -->
	<!-- https://ionicons.com/usage#chevron-forward-outline -->
	<script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>
	
	
</body>
</html>