<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board_make</title>
<link rel="stylesheet" href="css/board/board_make.css" />
</head>
<body>
<form action="BoardMakeC" method="post" enctype="multipart/form-data" >
    <div class="container_b">
   <p>マイコミュニティを作る</p>
      <div class="group_make_list">
        <div class="group_make title">
          <span>タイトル</span>
          <input type="text" name="title" />
        </div>
        <div class="group_make tag">
          <span>分類</span>
          <select name="tag" id="">
            <option value="子供">#子供</option>
            <option value="老人">#老人</option>
            <option value="環境">#環境</option>
            <option value="動物">#動物</option>
          </select>
        </div>
       <!--  <div class="group_make img">
          <span>写真</span> <input type="file" name="file" />
        </div> -->
        <div class="group_make img">
    	<span>写真</span> 
   			 <div  class="img_wrap">	
  			  <img id="preview" src="#" alt="미리보기 이미지" style="max-width: 300px; max-height: 300px; display: none;" />
   			 <input type="file" name="file" id="fileInput" accept="image/*" onchange="previewImage(event);" />
   			 </div>
		</div>
        <div class="group_make name">
          <span> 場所 </span>
          <input type="text" name ="place" />
        </div>
        <div class="group_make during">
          <span>募集期間 </span>
          <input type="date" name="start_date"/> &nbsp;&nbsp;~&nbsp;&nbsp; <input type="date" name="end_date" />
        </div>
        <div class="group_make date">
          <span>募集日</span>
          <input name="meet_date" type="date" />
        </div>
        <div class="group_make info_">
          <span>インフォメーション</span>
          <textarea name="info" id="" cols="49" rows="10"></textarea>
        </div>
      </div>
       <input name="status" type="hidden" value="O" />
      <button class="add_btn">登録</button>
    </div>
    </form>
    <script type="text/javascript" src="js/board/board_make.js"></script>
</body>
</html>