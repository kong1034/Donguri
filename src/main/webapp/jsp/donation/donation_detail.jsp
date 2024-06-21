<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Donation Detail Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/donation/donation_detail.css">
    <script src="${pageContext.request.contextPath}/js/donation/donation_detail.js" defer></script>
</head>
<body>
    <header>
        <div class="header_container">
            <h1>Donguri</h1>
            <nav>
                <ul>
                    <li>情報一覧</li>
                    <li>ドネーション</li>
                    <li>コミュニティ</li>
                </ul>
                <div class="user_options">
                    <button class="mypage_button">MyPage</button>
                    <button class="login_button">Login</button>
                </div>
            </nav>
        </div>
    </header>
    <main>
        <div class="donation_container">
            <div class="image_container">
                <img src="${pageContext.request.contextPath}/img/donation_image.jpg" alt="Donation Image">
            </div>
            <div class="details_container">
                <h2>寄付する</h2>
                <p>ここに説明が入ります。</p>
                <div class="amount_container">
                    <span>#環境</span>
                    <span class="amount">12,345 円</span>
                    <span class="percentage">60%</span>
                    <div class="progress_bar">
                        <div class="progress" style="width: 60%;"></div>
                    </div>
                </div>
                <div class="period_container">
                    <div>募金期間</div>
                    <div>2023.01.01 ~ 2023.12.31</div>
                </div>
                <div class="button_container">
                    <button class="share_button">共有する</button>
                    <button id="open_donation_modal" class="donate_button">寄付する</button>
                </div>
            </div>
        </div>
        <div id="donation_modal" class="modal">
            <div class="modal_content">
                <span id="donation_close" class="close">&times;</span>
                <h2>寄付する</h2>
                <form id="donation_form">
                    <label for="donation_amount">金額: </label>
                    <input type="number" id="donation_amount" name="amount" min="1" required>
                    <input type="hidden" id="donation_id" value="<%=request.getParameter("id")%>">
                    <button type="button" id="process_donation_button" class="donate_button">寄付する</button>
                </form>
            </div>
        </div>
    </main>
</body>
</html>