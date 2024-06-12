<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/common/header.css">
  <script src="<%= request.getContextPath() %>/js/common/header.js"></script>
</head>
<body>
  <header id="header_container">
    <a href="<%= request.getContextPath() %>/HC" class="header_title">Donguri</a>
    <ul class="header_category_ul">
      <li class="header_category_li"><a href="<%= request.getContextPath() %>/index.jsp">情報一覧</a></li>
      <li class="header_category_li"><a href="<%= request.getContextPath() %>/jsp/donation/donation.jsp">ドネーション</a></li>
      <li class="header_category_li"><a href="<%= request.getContextPath() %>/BoardC">コミュニティ</a></li>
      <li class="header_category_li"><a href="<%= request.getContextPath() %>/jsp/mypage/mypage.jsp">MyPage</a></li>
      <li class="header_category_li"><a href="<%= request.getContextPath() %>/jsp/sign/login.jsp">Login</a></li>
    </ul>
  </header>
</body>
</html>