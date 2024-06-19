<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
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
