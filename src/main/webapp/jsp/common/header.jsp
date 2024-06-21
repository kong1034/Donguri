<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Header Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/header.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/header.js" defer></script>
</head>
<body>
    <header id="header_container" class="header">
        <a href="HC" class="header_title">Donguri</a>
        <ul class="header_categori_ul">
            <li class="header_categori_li"><a href="<%=request.getContextPath()%>/index.jsp">情報一覧</a></li>
            <li class="header_categori_li"><a href="<%=request.getContextPath()%>/jsp/donation/donation.jsp">ドネーション</a></li>
            <li class="header_categori_li"><a href="BoardC">コミュニティ</a></li>
            <c:choose>
                <c:when test="${not empty loginStatus and loginStatus eq 'loggedIn'}">
                    <li class="header_categori_li"><a href="LogoutC" class="login_link">Logout</a></li>
                </c:when>
                <c:otherwise>
                    <li class="header_categori_li"><a href="LoginC" class="login_link">Login</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </header>
</body>
</html>