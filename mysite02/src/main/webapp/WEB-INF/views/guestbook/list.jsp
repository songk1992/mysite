<%@page import="java.util.List"%>
<%@page import="com.bitacademy.mysite.vo.GuestbookVo"%>
<%@page import="com.bitacademy.mysite.repository.GuestbookRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	List<GuestbookVo> list = new GuestbookRepository().findAll();
%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/assets/css/guestbook.css" rel="stylesheet" type="text/css">


</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		
		
		
		<!-- 등록 구간 -->
		
		<div id="content">
			<div id="guestbook">
				<form action="<%=request.getContextPath() %>/guestbook" method="post">
					<input type="hidden" name="a" value="insert">
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
				<%
					int indexNumber = 1;
				
					for (GuestbookVo vo : list) {
				%>
				
				<ul>
					<li>
						<table>
							<tr>
								<td>[<%=indexNumber++%>]</td>
								<td><%=vo.getName()%></td>
								<td><%=vo.getDatetime()%></td>
								<td>
								<form action="<%=request.getContextPath()%>/guestbook" method="post">
									<input type='hidden' name='a' value='deleteform' />
									<input type='hidden' name='no' value=<%=vo.getNo()%> />
									<input type="submit" value="삭제">
								</form>
								</td>
							</tr>
							<tr>
								<td colspan=4>
									<%=vo.getMessage()%>
								</td>
							</tr>
						</table>
						<br>
					</li>
				</ul>
				
				<%
					}
				%>
				
			</div>
		</div>
		
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>