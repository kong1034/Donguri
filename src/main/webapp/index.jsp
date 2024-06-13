<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Donguri</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/footer.css">
</head>
<body>
    <jsp:include page="jsp/common/header.jsp" />
    <jsp:include page="${contentPage}" />
    <jsp:include page="jsp/common/footer.jsp" />
</body>
</html>