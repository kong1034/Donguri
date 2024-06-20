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
      <li class="header_categori_li"><jsp:include page="${MyPage}"></jsp:include><span class="hidden"><a href="MyPageC">MyPage</a></span></li>
      <li class="header_categori_li"><jsp:include page="${LoginBtn}"></jsp:include><span class="hidden"><a href="LoginC">Login</a></span></li>
      </ul>
    </header>
  </body>
      <script>
    /* unlogged user viewer  */
    var loginChk = '${loginChk}';
    console.log(loginChk);

    const spans = document.querySelectorAll('.hidden');
    if (loginChk != 'logout') {
        spans.forEach(function(span) {
        span.style.display = 'none';
      });
    }
    if(loginChk == '') {
       spans[1].style.display = 'block';
    	
    }
</script>
</html>
>>>>>>> 7083ef022313c2998a96074e89b108b8619ed78d
