<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<title>mysite</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.request.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
</head>

<body>
	<div id="container">

		<!-- header -->
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		
		
		
		<!--  -->
		<div id="content">
			<div id="user">
				<form id="join-form" name="joinForm" method="post" action="${pageContext.request.contextPath }/user">
					<input type='hidden' name='a' value='update' />
					<input type='hidden' name='no' value="${userVo.no }" />
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="${authUser.name }">

					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="${userVo.email }">

					
					<label class="block-label">비밀번호</label>
					<input name="password" type="password" value="">

					
					<fieldset>
						<legend>성별</legend>
						<c:choose>
							<c:when test='${"female" == userVo.gender}'>
								<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
								<label>남</label> <input type="radio" name="gender" value="male">
							</c:when>
							<c:otherwise>
								<label>여</label> <input type="radio" name="gender" value="female">
								<label>남</label> <input type="radio" name="gender" value="male"  checked="checked">
							</c:otherwise>
						</c:choose>
					</fieldset>

					<input type="submit" value="수정하기">
				</form>
			</div>
		</div>


		<!-- navigation -->
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		
		<!-- footer -->
		<c:import url="/WEB-INF/views/includes/footer.jsp" />

	</div>
</body>
</html>