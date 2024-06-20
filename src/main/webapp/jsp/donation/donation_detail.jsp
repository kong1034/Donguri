<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>寄付詳細ページ</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/donation/donation_detail.css">
    <script src="${pageContext.request.contextPath}/js/donation/donation_detail.js" defer></script>
</head>
<body>
    <main>
        <div class="donation_container">
            <div class="image_container">
                <img src="${pageContext.request.contextPath}/img/donation_image.jpg" alt="Donation Image">
            </div>
            <div class="details_container">
                <h2>寄付する</h2>
                <button id="open_donation_modal" class="donate_button">寄付する</button>
            </div>
        </div>

        <div id="donation_modal" class="modal">
            <div class="modal_content">
                <span id="donation_close" class="close">&times;</span>
                <h2>寄付する</h2>
                <form id="donation_form">
                    <label for="donation_amount">金額: </label>
                    <input type="number" id="donation_amount" name="amount" min="1" required>
                    <button type="button" id="process_donation_button" class="donate_button">寄付する</button>
                </form>
            </div>
        </div>
    </main>
</body>
</html>