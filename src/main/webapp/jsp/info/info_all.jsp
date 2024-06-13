<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info All Page</title>
<link rel="stylesheet" href="css/info/info_all.css" />
</head>
<body>
	<section class="info_all_container">
		<div class="info_all_content_container">
			<ul class="info_ul_title_box">
				<li><p class="info_title" id="all"># 全体</p></li>
				<li><p class="info_title" id="child"># 子供</p></li>
				<li><p class="info_title" id="older"># 老人</p></li>
				<li><p class="info_title" id="animal"># 動物</p></li>
				<li><p class="info_title" id="env"># 環境</p></li>
			</ul>
			<jsp:include page="${contents }"></jsp:include>
		</div>
	</section>
	<script src="js/info/info_all.js"></script>
</body>
</html>