<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<!-- CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/header.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/footer.css" />
<!-- Jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<!-- slick -->
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<!-- font -->
<script type="text/javascript"
	src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&family=RocknRoll+One&family=Zen+Kurenaido&display=swap" rel="stylesheet">
</head>
<body class="rocknroll-one-regular">
	<%@ include file="jsp/common/header.jsp"%>
	<jsp:include page="${contentPage}"/>
	<%@ include file="jsp/common/footer.jsp"%>
	<script src="${pageContext.request.contextPath}/js/index.js"></script>
    <script src="${pageContext.request.contextPath}/js/common/header.js"></script>
    <script src="${pageContext.request.contextPath}/js/common/footer.js"></script>
</body>
</html>