<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <link
      rel="stylesheet"
      href="<%=request.getContextPath()%>/css/header.css"
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
            >ドネーション</a
          >
        </li>
        <li class="header_categori_li"><a href="BoardC">コミュニティ</a></li>
        <li class="header_categori_li">
          <a href="MyPageC"
            ><jsp:include page="${MyPage}"></jsp:include
            ><span id="hidden">MyPage</span></a
          >
        </li>
        <li class="header_categori_li">
          <a href="LoginC"
            ><jsp:include page="${LoginBtn}"></jsp:include
            ><span id="hidden">Login</span></a
          >
        </li>
      </ul>
    </header>
  </body>
</html>
