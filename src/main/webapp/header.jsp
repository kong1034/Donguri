<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/header.css">
  <script src="<%= request.getContextPath() %>/js/header.js"></script>
</head>
<body>
  <header id="header_container">
    <a href="<%= request.getContextPath() %>/" class="header_title">Donguri</a>
    <ul class="header_categori_ul">
      <li class="header_categori_li"><a href="<%= request.getContextPath() %>/index.jsp">情報一覧</a></li>
      <li class="header_categori_li"><a href="<%= request.getContextPath() %>/jsp/donation/donation.jsp">ドネーション</a></li>
      <li class="header_categori_li"><a href="<%= request.getContextPath() %>/jsp/community/community.jsp">コミュニ티</a></li>
      <li class="header_categori_li"><a href="<%= request.getContextPath() %>/jsp/mypage/mypage.jsp">MyPage</a></li>
      <li class="header_categori_li"><a href="<%= request.getContextPath() %>/jsp/sign/login.jsp">Login</a></li>
    </ul>
  </header>
</body>
</html>