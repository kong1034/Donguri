<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/donation/donation_update.css" />
</head>
<body>
	<section class="donation_container">
		<p class="donation_title_txt">寄付修正</p>
		<form id="donation_update_form" value="${selected_info.no }">
		<div class="donatio_update_list doantion_input">
			<div class="donation_update">
				<span>タイトル</span> <input type="text" id="title" value="${selected_info.title }"/>
			</div>
			<div class="donation_update donation_update_content">
				<p class="donation_content_title">内容</p>
				<textarea id="content" name="content">${selected_info.content }</textarea>
			</div>
			<div class="donation_update">
				<span>終わりデート</span> <input type="date" id="date" value="${selected_info.date }">
			</div>
			<div class="donation_update">
				<span>代表写真</span> <input type="file" id="thumbnail" value="${selected_info.thumnail }">
			</div>
			<div class="donation_update">
				<span>目標寄付金</span> <input type="number" id="amount" value="${selected_info.amount }">
			</div>
			<div class="donation_update">
				<span>期間名</span> <input type="text" id="publisher" value="${selected_info.publisher }">
			</div>
			<div class="donation_update">
				<span>種類</span> 
				<select id="tag" value="${selected_info.tag }">
					<option value="1">#子供</option>
					<option value="2">#老人</option>
					<option value="3">#環境</option>
					<option value="4">#動物</option>
				</select>
			</div>
		</div>
		<button id="donation_update_btn" type="submit"
			class="donation_update_btn">修正</button>
		</form>
		
	</section>

	<script src="js/donation/donation_update.js"></script>
</body>
</html>