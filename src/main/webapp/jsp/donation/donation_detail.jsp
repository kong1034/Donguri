<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Donation Detail Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/donation/donation_detail.css">
</head>
<body>
<main>
    <section class="donation_section">
        <div class="left_section">
            <div class="image_wrapper">
                <img src="${pageContext.request.contextPath}/img/donation_image.jpg" alt="Donation Image">
            </div>
            <div class="category_tag"><p># 環境</p></div>
            <div class="donation_goal">
                <p class="goal_amount">募金目標: <c:out value="${donation.amount}"/> 円</p>
                <p class="goal_percentage">
                    <img src="${pageContext.request.contextPath}/img/acorn.png" alt="Acorn">
                    <img src="${pageContext.request.contextPath}/img/acorn.png" alt="Acorn">
                    <img src="${pageContext.request.contextPath}/img/acorn.png" alt="Acorn">
                    <img src="${pageContext.request.contextPath}/img/acorn.png" alt="Acorn">
                    <img src="${pageContext.request.contextPath}/img/acorn.png" alt="Acorn">
                    <img src="${pageContext.request.contextPath}/img/acorn.png" alt="Acorn"> 60%
                </p>
            </div>
            <div class="donation_period">
                <p>募金期間: 2023.01.01 ~ 2023.12.31</p>
            </div>
        </div>
        <div class="right_section">
            <div class="donation_description">
                <h2 class="section_title">寄付する</h2>
                <p>ここに説明が入ります。</p>
            </div>
            <div class="donation_actions">
                <input type="number" id="donation_amount" name="amount" min="1" placeholder="金額を入力" required>
                <button id="donate_button" class="action_button donate_button">寄付する</button>
                <button id="share_button" class="action_button share_button">共有する</button>
            </div>
        </div>
    </section>
</main>
<!-- Share Modal -->
<div id="share_modal" class="modal">
    <div class="modal_content">
        <span id="modal_close" class="close_button">&times;</span>
        <h2 class="section_title">共有する</h2>
        <input type="text" id="share_link" value="" readonly>
        <button onclick="copyToClipboard('#share_link')" class="copy_button">リンクコピー</button>
        <div class="social_buttons">
            <a id="twitter_share" href="#" target="_blank" class="social_button">Twitter</a>
            <a id="instagram_share" href="#" target="_blank" class="social_button">Instagram</a>
            <a id="line_share" href="#" target="_blank" class="social_button">LINE</a>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/donation/donation_detail.js"></script>
</body>
</html>