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
				<div class="epilogue tag">
					<span>タグ</span>
				</div>
				<div class="epilogue title">
					<span>タイトル</span>
				</div>
				<div class="epilogue writer">
					<span>作成者</span>
				</div>
				<div class="epilogue date">
					<span>作成日</span>
				</div>
				<div class="epilogue content">
					<span>내용</span>
				</div>
			</div>
			<div class="comment-group">
				<p>댓글</p>
				<div class="comment">
					<c:forEach items="${comments }" var="c">
						<div class="comment_list">
							<div class="comment_writer">${c.id }</div>
							<div class="comment_contents">${c.c_content }</div>
							<fmt:formatDate value="${c.c_date }" pattern="yy.MM.dd hh:mm:ss" />
						</div>
					</c:forEach>
					<div class="comment_input">
					<textarea rows="2" cols="60" placeholder="댓글을 남겨주세요 "
						name="reply_contents" id="content" required="required"></textarea>
					<button class="btn_reg" id="add_btn"
						onclick="replySave('yrr', '')">등록</button>
					<div id="add_message">&nbsp;</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/board/board_epilogue_detail.js">
		
	</script>
</body>
</html>