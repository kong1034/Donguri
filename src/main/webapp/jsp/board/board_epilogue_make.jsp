<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board/board_epilogue_make.css" />
</head>
<body>
 <form action="BoardEpilogueMakeC" method="post" enctype="multipart/form-data">
      <div class="container_em">
        <p>後記作成</p>
        <div class="epilogue_make_list">
          <div class="epilogue_make title">
            <span>タイトル</span>
            <input type="text" name="r_title" id="" />
          </div>
          <div class="epilogue_make tag">
            <span>分類</span>
            <select name="r_tag" id="">
              <option value="子供">#子供</option>
              <option value="老人">#老人</option>
              <option value="環境">#環境</option>
              <option value="動物">#動物</option>
            </select>
          </div>
          <div class="epilogue_make img">
            <span>写真</span> <input type="file" name="r_file" />
          </div>

          <div class="epilogue_make content">
            <span>內容</span>
            <textarea name="r_content" id="" cols="47" rows="20"></textarea>
          </div>
        </div>
        <input type="hidden" name="v_no" value="">
        <input type="hidden" name="g_no" value="">
        <button class="add_btn">登録</button>
      </div>
    </form>
</body>
</html>