<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/header.css">
  <script src="<%= request.getContextPath() %>/js/header.js"></script>
  <script type="text/javascript">
  /* unlogged user viewer  */
  document.addEventListener('DOMContentLoaded', function() {
      var loginChk = '<%= request.getAttribute("loginChk") %>';
      console.log(loginChk)
      if (loginChk　!= 'null') {
          document.querySelectorAll('#hidden').forEach(function(span) {
              span.style.display = 'none';
          });
      }
  });
  </script>
</head>
<body>
  <header id="header_container">
    <a href="HC" class="header_title">Donguri</a>
    <ul class="header_categori_ul">
      <li class="header_categori_li"><a href="<%= request.getContextPath() %>/index.jsp">情報一覧</a></li>
      <li class="header_categori_li"><a href="<%= request.getContextPath() %>/jsp/donation/donation.jsp">ドネーション</a></li>
      <li class="header_categori_li"><a href="BoardC">コミュニティ</a></li>
      <li class="header_categori_li"><jsp:include page="${MyPage}"></jsp:include><a id=hidden href="MyPageC">MyPage</a></li>
      <li class="header_categori_li"><jsp:include page="${LoginBtn}"></jsp:include><a id=hidden href="LoginC">Login</a></li>
    </ul>
  </header>
</body>
</html>