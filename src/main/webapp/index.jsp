<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Donguri</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/commom/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/commom/footer.css">
    <script src="${pageContext.request.contextPath}/js/common/header.js"></script>
    <script src="${pageContext.request.contextPath}/js/common/footer.js"></script>
</head>
<body>
    <header id="header_container">
        <jsp:include page="jsp/common/header.jsp" />
    </header>

    <div id="content_container">
        <jsp:include page="${contentPage}" />
    </div>

    <footer id="footer_container">
        <jsp:include page="jsp/common/footer.jsp" />
    </footer>
</body>
</html>