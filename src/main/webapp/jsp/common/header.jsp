<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/header.css">
</head>
<body>
<header id="header_container" class="header">
    <a href="${pageContext.request.contextPath}/HC" class="header_title">Donguri</a>
    <nav class="navigation">
        <ul class="nav_list">
            <li class="nav_item"><a href="${pageContext.request.contextPath}/index.jsp">情報一覧</a></li>
            <li class="nav_item"><a href="${pageContext.request.contextPath}/jsp/donation/donation.jsp">ドネーション</a></li>
            <li class="nav_item"><a href="${pageContext.request.contextPath}/BoardC">コミュニティ</a></li>
            <li class="nav_item">
                <a id="auth_link" href="${pageContext.request.contextPath}/LoginC">Login</a>
            </li>
            <li class="nav_item">
                <a id="mypage_link" href="${pageContext.request.contextPath}/MyPage">
                    <img src="${pageContext.request.contextPath}/img/profile.jpg" alt="MyPage" class="profile_img">
                </a>
            </li>
        </ul>
    </nav>
</header>
<script src="${pageContext.request.contextPath}/js/common/header.js"></script>
</body>
</html>