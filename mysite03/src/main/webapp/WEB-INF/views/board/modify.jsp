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
		<div id="board" class="board-form">

				<form action="${pageContext.request.contextPath }/board/modify" method="post">
					<input type = "hidden" name="no" value=${no }>
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글수정</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="title" value=""></td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<textarea id="content" name="contents">
								수정해야 할 글은 고대로 
								이렇게 textarea에 뿌려야 합니다.
								개행문자 변경도 하지마세요.
								하하하하하
								즐건 코딩 되세요~~~~</textarea>
							</td>
						</tr>
					</table>
					<input type="submit" value="수정">
					<div class="bottom">
						<a href="">취소</a>
					</div>	
					
					</form>	
				</div>
				
				<!-- navigation -->
				<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
				
				<!-- footer -->
				<jsp:include page="/WEB-INF/views/includes/footer.jsp" />	
	
			</div>
		

		
	</div>
</body>
</html>