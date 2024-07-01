<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/common/header.css" />
    <script src="<%=request.getContextPath()%>/js/common/header.js"></script>
</head>
<body>
<header id="header_container">
    <a href="HC" class="header_title">Donguri</a>
    <div class="header_logo_box">
        <img class="header_logo_img" src="<%=request.getContextPath()%>/img/local/dongguri.svg" />
    </div>
    <ul class="header_categori_ul">
        <li class="header_categori_li">
            <a href="<%=request.getContextPath()%>/index.jsp">情報一覧</a>
        </li>
        <li class="header_categori_li">
            <a href="<%=request.getContextPath()%>/jsp/donation/donation.jsp">ドネーション</a>
        </li>
        <li class="header_categori_li"><a href="BoardC">コミュニティ</a></li>
        <li class="header_categori_li login">
            <img src="https://item.kakaocdn.net/do/296cc3e891afb5542018b43229eb30ccac8e738cb631e72fdb9a96b36413984e"
                 class="profile_img"
                 onclick="location.href='MyPageC'">
        </li>
        <li class="header_categori_li">
            <button onclick="location.href='LogoutC'" class="login">Logout</button>
            <span id="unlogin" class="unlogin"><a href="LoginC">Login</a></span>
        </li>
    </ul>
</header>
</body>
</html>