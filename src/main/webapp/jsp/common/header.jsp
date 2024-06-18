<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Header</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/header.css">
    <script src="${pageContext.request.contextPath}/js/common/header.js"></script>
</head>
<body>
    <header id="header_container">
        <a href="${pageContext.request.contextPath}/HomeController" class="header_title">Donguri</a>
        <ul class="header_category_ul">
            <li class="header_category_li"><a href="${pageContext.request.contextPath}/index.jsp">情報一覧</a></li>
            <li class="header_category_li"><a href="${pageContext.request.contextPath}/jsp/donation/donation.jsp">ドネーション</a></li>
            <li class="header_category_li"><a href="${pageContext.request.contextPath}/BoardC">コミュニティ</a></li>
            <li class="header_category_li"><a href="${pageContext.request.contextPath}/jsp/mypage/mypage.jsp">MyPage</a></li>
            <li class="header_category_li">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <a href="${pageContext.request.contextPath}/LogoutC">Logout</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/jsp/sign/login.jsp">Login</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </header>
</body>
</html>