<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
	
		<!-- header -->
	
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		
		
		
		<!--  -->
		
				<form id="join-form" name="joinForm" method="post" action="<%=request.getContextPath() %>/user">
					<input type='hidden' name='a' value='UPDATE' />
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="">

					<h4> kims example email</h4>
					
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
						<label>남</label> <input type="radio" name="gender" value="male">
						
						<label>여</label> <input type="radio" name="gender" value="female">
						<label>남</label> <input type="radio" name="gender" value="male"  checked="checked">
						
					</fieldset>
					
					<fieldset>
						<legend>수정하기</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>수정하기</label>
					</fieldset>
					
					<input type="submit" value="가입하기">
					
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