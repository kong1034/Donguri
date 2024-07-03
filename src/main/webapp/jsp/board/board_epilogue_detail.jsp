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
						<span>タイトル</span>
						<div>${epilogues.title }</div>
					
				</div>
				<div class="epilogue_center">
					<div class="epilogue tag">
					<span>分類</span> 
					<p class="tag_class">
						${epilogues.tag } </p>
					</div>
					<div class="epilogue writer">
						<span>作成者</span> <div>${epilogues.id }</div>   
					</div>
					<div class="epilogue date">
						<span>作成日</span> <div>${epilogues.date }</div> 
					</div>
				</div>
				<div class="epilogue_img">
				<img alt="" src="img/local/board/${epilogues.img }">
				</div>
				<div class="epilogue content">
					<span>内容</span><div>${epilogues.content }</div> 
				</div>
			</div>

			<div class="comment-group">
				<p>コメント</p>
				<div class="comment top">
					<c:forEach items="${comments }" var="c">
						<div class="comment_list" id="comment_${c.c_no}">
							<div class="comment_writer" style="font-size: 16pt;">${c.id }</div>
							<div class="comment_contents" style="font-size: 16pt;">${c.c_content }</div>
							<div class="comment_date">
								<fmt:formatDate value="${c.c_date }" pattern="yy.MM.dd HH:mm" />
							</div>
<%-- 								<a class="btn_delete" onclick="deleteComment('${c.c_no}', '${c.id }')"> --%>
								<c:choose>
								<c:when test="${sessionScope.user.u_id eq c.id}">
							<div class="comment_delete">
								<a class="btn_delete" onclick="deleteComment('${c.c_no}', '${c.id }')">
								<img alt="" src="img/local/board/delete_button.png"></a> 
								<input type="hidden" id="delete_no" value="${c.c_no}">
								<input type="hidden" id="user_id" value="${sessionScope.user.u_id }">
								<input type="hidden" id="writer_id" value="${c.id }">
							</div>
							<div class="comment_update">
								<a class="btn_update" onclick="updateComment(this, '${c.c_no}', '${c.c_content}', '${c.id }')">修正</a>
					        </div>
								</c:when>
								<c:otherwise>
<!-- 								<a class="btn_delete"> -->
<!-- 								<img alt="" src="img/local/board/delete_button.png" style="background-color: gray"> -->
<!-- 								</a> -->
								</c:otherwise>
								</c:choose>
							
						</div>
						
					</c:forEach>
						<div id="commentModal_${c.c_no}" class="commentModal" >
							<p>コメント 修正</p>
						<input type="hidden" id="comment_no" value="${contents.c_no }">
						<textarea id="comment_text" rows="3" cols="50"></textarea>
						<button id="modalModBtn">チェック</button>
						<button onclick="closeModal()">キャンセル</button>
					</div>
				</div>
									
				<div class="comment bottom">
					<p>コメントをつける</p>
					<p>${sessionScope.user.u_id }</p>
					<div class="comment_input">
						<textarea rows="2" cols="64" placeholder="コメントを作成してください"
							name="reply_contents" id="content"></textarea>
						<button class="btn_register" id="add_btn"
							onclick="saveComment('${sessionScope.user.u_id }', '${epilogues.no}')">登錄</button>
					</div>
					<div id="add_message">&nbsp;</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/board/board_epilogue_detail.js"></script>
</body>
</html>