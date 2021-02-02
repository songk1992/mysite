<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#join-form').submit(function(e){
		
		e.preventDefault();
		
			if($('#name').val()==''){
				alert('이름이 비어있습니다');
				$('#name').focus();
				return;
			}
	
			if($('#email').val()==''){
				alert('이메일이 비어있습니다');
				$('#email').focus();
				return;
			}
			
			if($('#img-check-email').is(':hidden')){
				alert('이메일 중복체크');
				return;
			}
	
			if(!$('#agree-prov').is(':checked')){
				alert('약관 동의가 필요합니다');
				$('#agree-prov').focus();
				return;
			}
			
			this.submit();
	});
	
	$('email').change(function(){
		$('#img-check-email').hide();
		$('#btn-check-email').show();
	})
	
	$('#btn-check-email').click(function(){
		let email = $("#email").val();
		if(email==''){
			$("#email").focus();
			return;
		}
		
		$.ajax({
			url: '${pageContext.request.contextPath }/api/user/existemail?email=' + email,
			async: true,
			data: '',
			dataType: 'json',
			success: function(response){
				if(response.result != 'success'){
					console.error(response.message);
					return;
				}
				
				if(response.data){
					alert("존재하는 이메일입니다. 다른 이메일을 사용해 주세요~");
					$("email")
						.val('')
						.focus();
					return;
				}
				
				
				$('#img-check-email').show();
				$('#img-check-email').css("display","block");
				$('#btn-check-email').hide();
				
			},
			
			error: function(XHR, status, e){
				consol.error(status + ":" + e);
			}
		})
		
	})
})
</script>


</head>
<body>
	<div id="container">
	
		<!-- header -->
	
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		

		
		
		<div id="content">
		<!--  -->
		
				<form:form 
					modelAttribute="userVo"
					id="join-form" 
					name="joinForm" 
					method="post" 
					action="${pageContext.request.contextPath }/user/join">
					
					<label class="block-label" for="name">이름</label>
					<form:input path="name" />
					<p style="text-align:left; padding:5px 0 0 0; color:#f00">
						<form:errors path="name"/>
					</p>
	
					<label class="block-label" for="email">이메일</label>
					
					<div style='display:flex; flex-direction:row;'>
					<form:input  style='display:block' path="email"/><p id="img-check-email" style='display:none;'>✅</p>
					</div>
					
					<input style='display:;' id="btn-check-email" type='button' value='중복확인' />
					<p style="text-align:left; padding:5px 0 0 0; color:#f00">
						<form:errors path="email"/>
					</p>


					
					<label class="block-label">패스워드</label>
					<form:password path="password" />
					
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <form:radiobutton path="gender" value="female" checked="checked" />
						<label>남</label> <form:radiobutton path="gender" value="male" />
					</fieldset>
					
					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>
					
					<input type="submit" value="가입하기">
					
				</form:form>

		</div>
		
		
		<!-- navigation -->
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

	</div>
</body>
</html>