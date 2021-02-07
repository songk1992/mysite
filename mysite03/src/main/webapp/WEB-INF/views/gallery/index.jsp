<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%pageContext.setAttribute( "newLine", "\n" );%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/lightbox.css" rel="stylesheet" type="text/css">
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/ejs/ejs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-3.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/lightbox.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/galleryviewer.js"></script>
<script type="text/javascript">

let startNo = 0;
let isEnd = false;
let contextPath = '${pageContext.request.contextPath }';

const galleryListTemplate = new EJS({
	url: '${pageContext.request.contextPath }/assets/js/ejs/gallery-list-template.ejs'
});

const galleryItemTemplate = new EJS({
	url: '${pageContext.request.contextPath }/assets/js/ejs/gallery-item-template.ejs'
});


const fetchList = function(){
	if(isEnd){
		return;	
	}
	
	$.ajax({
		url: '${pageContext.request.contextPath }/api/gallery/list/' + startNo,
		aync: true,
		type: 'get',
		dataType: 'json',
		data: '',
		success: function(response){
			if(response.result != 'success'){
				console.error(response.message);
				return;
			}
			
			// detect end
			if(response.data.length < 3){
				isEnd = true;
				$('#btn-fetch').prop('disabled', true);
				return;
			}
			
			// rendering
			//response.data.forEach(render);
			const html = galleryListTemplate.render(response);
			$("#list-gallery").append(html);
			
			// startNo = response.data[response.data.length-1]["no"];
			startNo = $('#list-gallery li').last().data('no') || 0;
		},
		error: function(xhr, status, e){
			console.log(status + ':' + e);
		}
	});

}

$(function(){
	const dialogUpload = $( "#dialog-upload-form" ).dialog({
		autoOpen: false,
		height: 280,
		width: 300,
		modal: true,
		buttons: {
			"업로드": function() {
				$( "#dialog-upload-form form" ).submit();
				$( this ).dialog( "close" );
			},
			"취소" : function() {
				$( this ).dialog( "close" );
			}
		},
		close: function() {
			$( "#dialog-upload-form form" ).get(0).reset();	
		}
	});
	
	$("#upload-image").click( function(event) {
		event.preventDefault();
		dialogUpload.dialog( "open" );
	});
	

	// 창스크롤 이벤트
	$(window).scroll(function(){
		const $window = $(this);
		const $document = $(document);
		
		const scrollTop = $window.scrollTop();
		const windowHeight = $window.height();
		const documentHeight = $document.height();
		
		if(windowHeight + scrollTop + 10 > documentHeight){
			fetchList();
		}
	});

	
	fetchList();
	
	
	// 추후 외부 파일로 옮겨보기
	// galleryViewer.init();
});	
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="gallery">
				<div>
					<h1>갤러리</h1>
					<a href="" id="upload-image">이미지 올리기</a>
				</div>
				
				<ul id="list-gallery"></ul>
				
				
				<ul>
						<li>
							<a	href="${pageContext.request.contextPath }/assets/gallery-examples/im1.jpg"
								data-lightbox="gallery"
								class="image"
								style="background-image:url('${pageContext.request.contextPath }/assets/gallery-examples/im1.jpg')">&nbsp;</a>
								
							<a	href="${pageContext.request.contextPath }/gallery/delete/1"
								class="del-button"
								title="삭제">삭제</a>
						</li>
																																	
				</ul>	
			</div>

			<div id="dialog-upload-form" title="이미지 업로드" style="display:none">
  				<p class="validateTips normal">이미지와 간단한 코멘트를 입력해 주세요.</p>
  				<form action="${pageContext.request.contextPath }/gallery/upload " 
  					  method="post"
  					  enctype="multipart/form-data">
					<label>코멘트</label>
					<input type="text" id="input-comments" name=input-comments value="">
					<label>이미지</label>
					<input type="file" id="input-file" name="input-file">
					<input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
  				</form>
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="gallery"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>