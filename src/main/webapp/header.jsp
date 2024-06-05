<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Header Page</title>
<style type="text/css">
body {
 margin: 0;
 padding: 0;
}

#header_container {
 display: flex;
 justify-content: space-between;
 align-items: flex-end; /* 아래 정렬 */
 padding: 10px 20px;
 flex-wrap: nowrap;
 box-sizing: border-box; /* padding 포함 */
 width: 100%; /* 전체 너비 사용 */
 overflow: hidden; /* 내용이 넘치지 않도록 숨김 */
}

.header_title {
 font-size: 50px;
 color: #F6A200;
 text-decoration: none;
 white-space: nowrap; /* 줄바꿈 방지 */
 flex-shrink: 0; /* 수축 방지 */
 margin-right: auto; /* 오른쪽으로 밀기 */
}

.header_title:hover {
 transform: scale(1.2); /* 크기 확대 */
 transition: transform 0.3s, z-index 0.3s; /* 부드러운 전환 */
 z-index: 0; /* 확대된 요소가 위에 표시되도록 함 */
}

.header_categori_ul {
 list-style-type: none;
 padding: 0;
 margin: 0;
 display: flex;
 white-space: nowrap; /* 줄바꿈 방지 */
 margin-left: auto; /* 왼쪽으로 밀기 */
 position: relative; /* 자식 요소의 absolute 위치를 위한 상대 위치 */
}

.header_categori_li {
 margin-left: 10px; /* 간격을 좁혀 화면에 맞춤 */
 font-size: 20px; /* 원하는 크기로 설정하세요 */
 white-space: nowrap; /* 줄바꿈 방지 */
 flex-shrink: 0; /* 수축 방지 */
 position: relative; /* hover시 절대 위치를 위한 상대 위치 */
 transition: transform 0.3s, z-index 0.3s; /* 부드러운 전환 */
}

.header_categori_li a {
 text-decoration: none;
 color: inherit;
 display: block; /* 전체 영역을 클릭 가능하게 함 */
 padding: 5px 10px; /* 클릭 가능한 영역 확대 */
}

.header_categori_li:hover {
 transform: scale(1.5); /* 크기 확대 */
 z-index: 10; /* 확대된 요소가 위에 표시되도록 함 */
}

</style>
</head>
<body>
 <header id="header_container">
   <a href="#" class="header_title">Donguri</a>
   <ul class="header_categori_ul">
    <li class="header_categori_li"><a href="#">情報一覧</a></li>
    <li class="header_categori_li"><a href="#">ドネーション</a></li>
    <li class="header_categori_li"><a href="#">コミュニティ</a></li>
    <li class="header_categori_li"><a href="#">MyPage(img)</a></li>
    <li class="header_categori_li"><a href="#">Login</a></li>
   </ul>
 </header>
 <hr>
</body>
</html>
