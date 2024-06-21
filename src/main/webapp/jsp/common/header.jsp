<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<<<<<<< HEAD
<head>
    <meta charset="UTF-8">
    <title>Header Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/header.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/header.js"></script>
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
      <li class="header_categori_li"><img src="https://item.kakaocdn.net/do/296cc3e891afb5542018b43229eb30ccac8e738cb631e72fdb9a96b36413984e"
	style=" 
	width: 2.5em;
    height: 2.5em;
    border: 1px solid black;
    border-radius: 50%;"
    onclick="location.href='MyPageC'" class="login"></li>
      <li class="header_categori_li"><button onclick="location.href='LogoutC'" class="login" style="width: 4em;
    height: 2em;">Logout</button><span id="unlogin"><a href="LoginC">Login</a></span></li>
      </ul>
    </header>
  </body>
<script>
/* unlogged user viewer  */
    // Find Cookie
	function get_cookie(jwtToken) {
    var value = document.cookie.match('(^|;) ?' + jwtToken + '=([^;]*)(;|$)');
    return value? value[2] : null;
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
<<<<<<< HEAD
</html>
>>>>>>> 7083ef022313c2998a96074e89b108b8619ed78d
=======
</html>
>>>>>>> 44a4924fc1e3648f63ef504c1eed662225a99be3
