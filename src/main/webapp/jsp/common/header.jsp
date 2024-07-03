<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <img class="header_logo_img" src="img/local/dongguri.svg" />
        </div>
        <ul class="header_categori_ul">
            <li class="header_categori_li"><a href="<%=request.getContextPath()%>/index.jsp">情報一覧</a></li>
            <li class="header_categori_li"><a href="<%=request.getContextPath()%>/jsp/donation/donation.jsp">ドネーション</a></li>
            <li class="header_categori_li"><a href="BoardC">コミュニティ</a></li>
            <c:choose>
                <c:when test="${sessionScope.user.u_profileimg != null }">
                <li class="header_categori_li" class="login"><img src="img/server/${sessionScope.user.u_profileimg }"
                style="width: 2.5em; height: 2.5em; border: 1px solid black; border-radius: 50%;"
                onclick="location.href='MyPageC'" class="login"></li>
                </c:when>
                <c:otherwise>
                <li class="header_categori_li" class="login"><img src="img/local/default_icon.png"
                style="width: 2.5em; height: 2.5em; border: 1px solid black; border-radius: 50%;"
                onclick="location.href='MyPageC'" class="login"></li>
                </c:otherwise>
            </c:choose>
            <li class="header_categori_li"><button onclick="location.href='LogoutC'" class="login"
                style="width: 4em; height: 2em;">Logout</button>
                <span id="unlogin"><a href="LoginC">Login</a></span></li>
        </ul>
    </header>
</body>
<script>
    /* unlogged user viewer  */
    // Find Cookie
    function get_cookie(jwtToken) {
        var value = document.cookie.match('(^|;) ?' + jwtToken + '=([^;]*)(;|$)');
        return value ? value[2] : null;
    }

    var jwtToken = get_cookie("jwtToken");
    console.log(jwtToken);
    const spans = document.querySelectorAll('#unlogin');
    var loginElements = document.querySelectorAll('.login');

    // login
    if (jwtToken != null) {
        spans.forEach(function(span) {
            span.style.display = 'none';
            console.log('include viewer clear');
        });
        loginElements.forEach(function(element) {
            element.style.display = 'block';
        });
    }
    // Unlogin
    if (jwtToken == null) {
        spans[0].style.display = 'block';
        console.log('unuser viewer');
        loginElements.forEach(function(element) {
            element.style.display = 'none';
        });
    }
</script>
</html>