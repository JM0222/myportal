<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일업로드</h1>
	<form method="POST"
		action = "${pageContext.request.contextPath }/fileupload/upload"
		enctype = "multipart/form-data">
		<!-- 반드시 enctype 설정 멀티파트 / 폼 데이터 -->
		<label>파일</label>
		<input type="file" name = "uploadfile"><br>
		<input type="submit" value= "upload"/>
	</form>
</body>
</html>