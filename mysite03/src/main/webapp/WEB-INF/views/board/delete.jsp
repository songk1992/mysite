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

				<form action="${pageContext.request.contextPath }/board/delete" method="post">
					<input type='hidden' name='no' value=${no }>
					<table>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
							<td><input type="submit" value="확인"></td>
							<td><a href='${pageContext.request.contextPath }/board'>메인으로 돌아가기</a></td>
						</tr>
					</table>
				</form>		
					
			</div>
		</div>
		
		<!-- navigation -->
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
		
		</div>

</body>
</html>