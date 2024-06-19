<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Donation Detail Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/donation/donation_detail.css">
    <script src="${pageContext.request.contextPath}/js/donation/donation_detail.js"></script>
</head>
<body>
    <div class="wrapper">
        <main class="content">
            <div class="donation_container">
                <div class="image_container">
                    <img src="<c:out value='${donation.image_url}'/>" alt="Donation Image">
                </div>
                <div class="details_container">
                    <h2><c:out value="${donation.tag}"/></h2>
                    <p><c:out value="${donation.description}"/></p>
                    <div class="button_container">
                        <button id="share_button" class="share_button">共有する</button>
                        <form id="donation_form" method="post" action="${pageContext.request.contextPath}/DonationC">
                            <label for="donation_amount">金額:</label>
                            <input type="number" id="donation_amount" name="amount" required>
                            <button type="submit" id="process_donation_button" class="donate_button">寄付する</button>
                        </form>
                    </div>
                </div>
            </div>
        </main>
    </div>

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
</body>
</html>