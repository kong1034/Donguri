<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<<<<<<< HEAD
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
=======
  <head>
    <meta charset="UTF-8" />
    <link
      rel="stylesheet"
      href="<%=request.getContextPath()%>/css/common/header.css"
    />
    <script src="<%=request.getContextPath()%>/js/common/header.js"></script>
  </head>
  <body>
    <header id="header_container">
      <a href="HC" class="header_title">Donguri</a>
      <div class="header_logo_box">
        <img class="header_logo_img" src="img/local/dongguri.svg" />
      </div>
      <ul class="header_categori_ul">
        <li class="header_categori_li">
          <a href="<%=request.getContextPath()%>/index.jsp">情報一覧</a>
        </li>
        <li class="header_categori_li">
          <a href="<%=request.getContextPath()%>/jsp/donation/donation.jsp"
            >ドネーション</a>
        </li>
        <li class="header_categori_li"><a href="BoardC">コミュニティ</a></li>
      <li class="header_categori_li" class="login"><img src="https://item.kakaocdn.net/do/296cc3e891afb5542018b43229eb30ccac8e738cb631e72fdb9a96b36413984e"
	style=" 
	width: 2.5em;
    height: 2.5em;
    border: 1px solid black;
    border-radius: 50%;"
    onclick="location.href='MyPageC'" class="login"></li>
      <li class="header_categori_li"><button onclick="location.href='LogoutC'" class="login" style="width: 4em;
    height: 2em;">Logout</button><span id="unlogin"><a href="LoginC">Login</a></span></li>
      </ul>
>>>>>>> ec3016d492cd9a64b6abd71989189da98e76e809
    </header>
</body>
</html>