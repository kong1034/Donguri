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
        <div class="group_make img">
          <span>写真</span> <input type="file" name="file" />
        </div>
        <div class="group_make name">
          <span> 場所 </span>
          <input type="text" name ="place" />
        </div>
        <div class="group_make date">
          <span>デート</span>
          <input name="date" type="date" />
        </div>
        <div class="group_make during">
          <span>募集期間 </span>
          <input type="date" /> &nbsp;&nbsp;~&nbsp;&nbsp; <input type="date" />
        </div>
        <div class="group_make info_">
          <span>インフォメーション</span>
          <textarea name="info" id="" cols="49" rows="10"></textarea>
        </div>
      </div>
      <button class="add_btn">登録</button>
    </div>
    </form>
</body>
</html>