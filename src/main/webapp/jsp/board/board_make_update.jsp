<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="css/board/board_make.css" />
</head>
<body>
    <div class="container_b">
<form action="BoardUpdateC" method="post" enctype="multipart/form-data" >
   <p>マイコミュニティを作る</p>
      <div class="group_make_list">
        <div class="group_make title">
          <span>タイトル</span>
          <input type="text" name="title" value="${boardlists.title }"/>
        </div>
        <div class="group_make tag">
          <span>分類</span>
          <select name="tag" id="" value="${boardlists.tag }">
            <option value="子供">#子供</option>
            <option value="老人">#老人</option>
            <option value="環境">#環境</option>
            <option value="動物">#動物</option>
          </select>
        </div>
        <div class="group_make img">
          <span>写真</span>
          	<div class="img_wrap">
          <img name="img" src="img/local/board/${boardlists.img }" alt=""
						style="height: 300px; width: 300px;" />
		  <input name="oldFile" value="${boardlists.img }" readonly="readonly">
          &nbsp 変更するイメージ:<input type="file" name="newFile">
          	</div>	
        </div>
        <div class="group_make name">
          <span> 場所 </span>
          <input type="text" name ="place" value="${boardlists.place }"/>
        </div>
        <div class="group_make during">
          <span>募集期間 </span>
          <input type="date" name="start_date" value="${boardlists.startdate }"/> &nbsp;&nbsp;~&nbsp;&nbsp; <input type="date" name="end_date" value="${boardlists.enddate }" />
        </div>
        <div class="group_make date">
          <span>デート</span>
          <input name="meet_date" type="date" value="${boardlists.date }"/>
        </div>
        <div class="group_make info_">
          <span>インフォメーション</span>
          <textarea name="info" id="" cols="49" rows="10">${boardlists.content }</textarea>
        </div>
      <button class="add_btn">修正する</button>
      </div>
       <input name="status" type="hidden" value="O" />
       <input name="no" type="hidden" value="${param.no }" />
    </form>
    <div class="cancel_btn">
      <button onclick="location.href='MyPageC'"><img class="goback_img" alt="" src="img/local/board/back-arrow.png"></button>
    </div>
    </div>
     <script type="text/javascript" src="js/board/board_make.js"></script>
</body>
</html>