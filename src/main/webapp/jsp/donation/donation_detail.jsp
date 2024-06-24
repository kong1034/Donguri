<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Donation Detail Page</title>
    <link rel="stylesheet" href="<c:url value='css/donation/donation_detail.css'/>">
</head>
<body>
    <header>
        <h1>寄付詳細ページ</h1>
        <nav>
            <ul>
                <li><a href="home.jsp">ホーム</a></li>
                <li><a href="about.jsp">紹介</a></li>
                <li><a href="contact.jsp">連絡先</a></li>
            </ul>
        </nav>
        <div class="header_right">
            <a href="mypage.jsp" class="mypage_button">マイページ</a>
            <a href="login.jsp" class="login_button">ログイン</a>
        </div>
    </header>
    <main>
        <div class="donation_container">
            <div class="image_container">
                <img src="<c:out value='${donation.imageUrl}'/>" alt="Donation Image">
            </div>
            <div class="details_container">
                <h2><c:out value="${donation.tag}"/></h2>
                <p><c:out value="${donation.description}"/></p>
                <div class="button_container">
                    <button id="share_button" class="share_button">共有する</button>
                    <button id="donate_button" class="donate_button">寄付する</button>
                </div>
            </div>
        </div>
    </main>

    <!-- Share Modal -->
    <div id="share_modal" class="modal">
        <div class="modal_content">
            <span id="share_close" class="close">&times;</span>
            <h2>共有リンク</h2>
            <p>以下のリンクをコピーして共有してください。</p>
            <div>
                <input type="text" value="https://yourdomain.com/donation/${donation.id}" id="share_link" readonly>
                <button onclick="copyToClipboard('#share_link')">コピー</button>
            </div>
        </div>
    </div>

    <!-- Donate Modal -->
    <div id="donate_modal" class="modal">
        <div class="modal_content">
            <span id="donate_close" class="close">&times;</span>
            <h2>寄付する</h2>
            <form id="donation_form">
                <label for="donation_amount">金額:</label>
                <input type="number" id="donation_amount" name="amount" required>
                <button type="button" id="process_donation_button">寄付</button>
            </form>
        </div>
    </div>

    <script src="<c:url value='js/donation/donation_detail.js'/>"></script>
</body>
</html>