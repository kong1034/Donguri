<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
     <link rel="stylesheet" href="css/board/board.css" />
</head>
<body>
<header></header>
    <div class="container_board">
      <div class="buttons">
        <button class="btn_make">グループ<br />作り</button>
        <button class="btn_comment">後記 見る</button>
      </div>

      <div class="tags">
        <div class="tags_list">#こども</div>
        <div class="tags_list">#老人</div>
        <div class="tags_list">#環境</div>
        <div class="tags_list">#動物</div>
      </div>

      <div class="search_wrap">
        <input type="text" class="search" placeholder="   search" />
      </div>

      <div class="board_container">
        <div class="board_list">
          <div class="board status">状態</div>
          <div class="board location">場所</div>
          <div class="board group">グループ名</div>
          <div class="board title">タイトル</div>
          <div class="board writer">writer</div>
          <div class="board date">デート</div>
        </div>
        <div div class="board_list">
          <div class="board status">
            <div class="status_welcome">募集中</div>
          </div>
          <div class="board location"></div>
          <div class="board group"></div>
          <div class="board title"></div>
          <div class="board writer"></div>
          <div class="board date"></div>
        </div>
      </div>
      <ul class="number">
        <li><a>&lt;</a></li>
        <li><a>1</a></li>
        <li><a>2</a></li>
        <li><a>3</a></li>
        <li><a>4</a></li>
        <li><a>5</a></li>
        <li><a>&gt;</a></li>
      </ul>
    </div>
</body>
</html>