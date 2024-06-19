<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Epilogue Detail</title>
<link rel="stylesheet" href="css/board/board_epilogue_detail.css" />
</head>
<body>
	<div class="container_ed">
		<div class="epilogue_wrap">
			<div class="epilogue_list" style="font-weight: bold; font-size: 18pt">
				<div class="epilogue title">
					<span>タイトル</span>${epilogues.title }
				</div>
				<div class="epilogue_center">
					<div class="epilogue tag">
						<span>タグ</span> ${epilogues.tag }
					</div>
					<div class="epilogue writer">
						<span>作成者</span> ${epilogues.id }
					</div>
					<div class="epilogue date">
						<span>作成日</span> ${epilogues.date }
					</div>
				</div>
				<div class="epilogue content">
					<span>내용</span>${epilogues.content }
				</div>
			</div>

			<div class="comment-group">
				<p>댓글</p>
				<div class="comment top">
					<c:forEach items="${comments }" var="c">
						<div class="comment_list" id="comment_${c.c_no}">
							<div class="comment_writer" style="font-size: 16pt;">${c.id }</div>
							<div class="comment_contents" style="font-size: 16pt;">${c.c_content }</div>
							<div class="comment_date">
								<fmt:formatDate value="${c.c_date }" pattern="yy.MM.dd hh:mm" />
							</div>
							<div class="comment_delete">
								<a class="btn_delete" onclick="deleteComment(${c.c_no})"><img
									alt="" src="img/local/board/delete_button.png"></a> <input
									type="hidden" id="delete_no" value="${c.c_no}">
							</div>
							<div class="comment_update">
								<a class="btn_update" onclick="updateComment(${c.c_no})">수정</a>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="comment bottom">
					<p>댓글 쓰기</p>
					<p>${id }</p>
					<div class="comment_input">
						<textarea rows="2" cols="70" placeholder="댓글을 남겨주세요 "
							name="reply_contents" id="content"></textarea>
						<button class="btn_register" id="add_btn"
							onclick="saveComment('yuree', '${epilogues.no}')">등록</button>
					</div>
					<div id="add_message">&nbsp;</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/board/board_epilogue_detail.js"></script>
</body>
</html>