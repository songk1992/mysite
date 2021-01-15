<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">


</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		
		

		<div id="content">
			<div id="guestbook">		
				<!-- 등록 구간 -->
				
		
					<form action="${pageContext.request.contextPath }/guestbook/add" method="post">
						<table>
							<tr>
								<td>이름</td><td><input type="text" name="name" value=""></td>
								<td>비밀번호</td><td><input type="password" name="password" value=""></td>
							</tr>
							<tr>
								<td colspan=4><textarea name="message" id="content"></textarea></td>
							</tr>
							<tr>
								<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
							</tr>
						</table>
					</form>
	

				<!-- 보여주기 + 삭제 구간 -->
				
				<c:forEach items='${list }' var='vo' varStatus='status'>
				<ul>
					<li>
						<table>
							<tr>
								<td>${status.count } </td>
								
								<td>${vo.name } </td>
								<td>${vo.datetime } </td>
								<td>
									<a href="${pageContext.request.contextPath }/guestbook/delete/${vo.no }">삭제</a>
								</td>
							</tr>
							<tr>
								<td colspan=4>
									${vo.message }
								</td>
							</tr>
						</table>
					</li>
				</ul>
				</c:forEach>
			</div>	
		</div>				
		
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>