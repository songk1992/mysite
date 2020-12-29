<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<!-- header -->
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="6">글보기</th>
					</tr>
					
					
					<tr class="label">
					<td>제목</td>
					<td>등록일</td>
					<td>조회수</td>
					<td>좋아요</td>
					<td>싫어요</td>
					<td>등록자</td>
					
					<tr class="label">
						<td>${vo.title } </td>
						<td>${vo.regDate } </td>
						<td>${vo.hit } </td>
						<td>${vo.good } </td>
						<td>${vo.notGood } </td>
						<td>${vo.userName } </td>
					</tr>

					<tr><td colspan="6"><center>내용 / FORMAT은 추후 수정 예정</center></td></tr>
					
					<tr><td colspan="6"><div class="view-content">
								${vo.contents } </td></tr>
					<tr>
						<td>
							
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
				<a href="${pageContext.request.contextPath }/board?a=list">글목록</a>
            	<a href="${pageContext.request.contextPath }/board?a=modify&no=${vo.no }">글수정</a>
				</div>
			</div>
		</div>
		<!-- navigation -->
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
		
	</div>
</body>
</html>