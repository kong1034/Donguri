<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Information Page</title>
<link rel="stylesheet" href="css/info/info.css" />
</head>
<body>
	<section class="info_container">
		<div class="info_title_box">
			<h1>情報一覧</h1>
			<a href="InfoAllC">#전체보기</a>
		</div>
		
		<div class="info_ul_title_box">
			<p class="info_title"># 아동</p>
			<button class="info_all" onclick="goInfoAll()">더보기</button>
		</div>
		<ul class="info_ul_container">
			<li>
				<img src=""/>
			</li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
		
		<div class="info_ul_title_box">
			<p class="info_title"># 노인</p>
			<button class="info_all" onclick="goInfoAll()">더보기</button>
		</div>
		<ul class="info_ul_container">
			<li>
				<img src=""/>
			</li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
		
		<div class="info_ul_title_box">
			<p class="info_title"># 동물</p>
			<button class="info_all" onclick="goInfoAll()">더보기</button>
		</div>
		<ul class="info_ul_container">
			<li>
				<img src=""/>
			</li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
		
		<div class="info_ul_title_box">
			<p class="info_title"># 환경</p>
			<button class="info_all" onclick="goInfoAll()">더보기</button>
		</div>
		<ul class="info_ul_container">
			<li>
				<img src=""/>
			</li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</section>
	<script src="/js/info/info.js"></script>
</body>
</html>