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
			<a href="InfoAllC?num=0">#Show All</a>
		</div>

		<!-- child -->
		<div class="info_child_container">
			<div class="info_ul_title_box">
				<p class="info_title"># 子供</p>
				<button class="info_all" onclick="goInfo(1)">More</button>
			</div>
			<ul class="info_ul_container">
				<li><img src="" /></li>
				<li><img src="" /></li>
				<li><img src="" /></li>
				<li><img src="" /></li>
			</ul>
		</div>

		<!-- older -->
		<div class="info_older_container">
			<div class="info_ul_title_box">
				<p class="info_title"># 老人</p>
				<button class="info_all" onclick="goInfo(2)">More</button>
			</div>
			<ul class="info_ul_container">
				<li><img src="" /></li>
				<li><img src="" /></li>
				<li><img src="" /></li>
				<li><img src="" /></li>
			</ul>
		</div>

		<!-- animal -->
		<div class="info_animal_container">
			<div class="info_ul_title_box">
				<p class="info_title"># 動物</p>
				<button class="info_all" onclick="goInfo(3)">More</button>
			</div>
			<ul class="info_ul_container">
				<li><img src="" /></li>
				<li><img src="" /></li>
				<li><img src="" /></li>
				<li><img src="" /></li>
			</ul>
		</div>

		<!-- env -->
		<div class="info_env_container">
			<div class="info_ul_title_box">
				<p class="info_title"># 環境</p>
				<button class="info_all" onclick="goInfo(4)">More</button>
			</div>
			<ul class="info_ul_container">
				<li><img src="" /></li>
				<li><img src="" /></li>
				<li><img src="" /></li>
				<li><img src="" /></li>
			</ul>
		</div>
	</section>
	<script src="js/info/info.js"></script>
</body>
</html>