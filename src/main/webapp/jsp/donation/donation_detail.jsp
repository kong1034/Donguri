<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Donation Detail Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/donation/donation_detail.css">
    <script src="${pageContext.request.contextPath}/js/donation/donation_detail.js" defer></script>
</head>
<body>
    <jsp:include page="/jsp/common/header.jsp" />
    <main>
        <div class="donation_container">
            <div class="left_first_area">
                <div class="image_container">
                    <div class="image_item">
                        <img src="${pageContext.request.contextPath}/img/donation_image.jpg" alt="Donation Image">
                    </div>
                </div>
            </div>
            <div class="left_second_area">
                <div class="categori_tag"># 環境</div>
            </div>
            <div class="donation_goal">
                <div class="amount">募金目標: 12,345 円</div>
                <div class="percentage" data-percentage="50">60%</div>
            </div>
            <div class="period_container">
                <div>募金期間</div>
                <div>2023.01.01 ~ 2023.12.31</div>
            </div>
            <div class="details_container">
                <div class="right_first_area">
                    <h2>寄付する</h2>
                    <p>ここに説明が入ります。</p>
                </div>
                <div class="right_second_area">
                    <div class="button_container">
                        <input type="number" id="donation_amount" name="amount" min="1" placeholder="金額を入力" required>
                        <button id="process_donation_button" class="donate_button">寄付する</button>
                        <button id="share_button" class="share_button">共有する</button>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <!-- Share Modal -->
    <div id="share_modal" class="modal">
        <div class="modal_content">
            <span id="share_close" class="close">&times;</span>
            <h2>共有する</h2>
            <input type="text" id="share_link" value="" readonly>
            <button onclick="copyToClipboard('#share_link')" class="share_option_button">リンクコピー</button>
            <div class="sns_buttons">
                <a id="twitter_share" href="#" target="_blank" class="sns_button">Twitter</a>
                <a id="instagram_share" href="#" target="_blank" class="sns_button">Instagram</a>
                <a id="line_share" href="#" target="_blank" class="sns_button">LINE</a>
            </div>
        </div>
    </div>

    <jsp:include page="/jsp/common/footer.jsp" />
</body>
</html>