<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/common/footer.css">
  <script src="<%= request.getContextPath() %>/js/common/footer.js"></script>
</head>
<body>
  <div id="footer_container">
    <footer>
      <div class="footer">
        <ul class="footer_links">
          <li><a>参考サイト</a></li>
          <li><a> | </a></li>
          <li><a href="https://www.newneek.co/">Newneek</a></li>
          <li><a> | </a></li>
          <li><a href="https://www.campuspick.com/">Campuspick</a></li>
          <li><a> | </a></li>
          <li><a href="https://www.2030.go.kr/main">2030</a></li>
          <li><a> | </a></li>
          <li><a href="https://www.friendscube.com/">friendscube</a></li>
          <li><a> | </a></li>
          <li><a href="https://donation.yahoo.co.jp/">Yahoo ネット募金</a></li>
          <li><a> | </a></li>
          <li><a href="https://together.kakao.com/">カカオ 一緒に価値</a></li>
        </ul>
        <ul class="footer_links">
          <li><a href="https://github.com/kong1034/Donguri">GitHub</a></li>
          <li><a> | </a></li>
          <li><a href="https://www.notion.so/SBT-f8df8e7c8206416d9fd67f2c683deb77">Notion</a></li>
          <li><a> | </a></li>
          <li><a href="https://www.figma.com/board/egaIqhDnIGE7n0tI4r3O8j/SBT-semi-project?t=wYsdR1aaq2kwlz81-1">Figma</a></li>
          <li><a> | </a></li>
          <li><a>All For My Neighbors</a></li>
          <li><a> | </a></li>
          <li><a>&copy; 2024 Donguri. All rights reserved.</a></li>
        </ul>
        <div class="footer_nav">
          <a href="#top">Top</a>
          <a href="#" id="settings_button">Settings</a>
        </div>
      </div>
    </footer>
  </div>

  <!-- Modal for settings -->
  <div id="settings_modal" class="modal">
    <div class="modal_content">
      <span class="close">&times;</span>
      <h2>Settings</h2>
      <form>
        <label for="device_settings">Device Settings:</label>
        <input type="radio" id="device_settings" name="theme" value="device" checked> Default<br>
        <label for="light_mode">Light Mode:</label>
        <input type="radio" id="light_mode" name="theme" value="light"> Light Mode<br>
        <label for="dark_mode">Dark Mode:</label>
        <input type="radio" id="dark_mode" name="theme" value="dark"> Dark Mode<br>
        <button type="submit">Apply</button>
      </form>
    </div>
  </div>
</body>
</html>