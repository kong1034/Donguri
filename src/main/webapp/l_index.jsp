<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>l_index</title>
<!-- css -->
<link rel="stylesheet" href="css/l_index.css" />
<!-- font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&family=RocknRoll+One&family=Zen+Kurenaido&display=swap"
	rel="stylesheet">
<!-- Jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
</head>
<body class="rocknroll-one-regular">
	<header class="header_container">
		<p>Donguri</p>
	</header>
	<jsp:include page="${contentPage}"></jsp:include>
</body>
</html>