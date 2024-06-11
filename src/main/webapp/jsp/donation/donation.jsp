<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Donation Page</title>
    <link rel="stylesheet" type="text/css" href="/Donguri/css/header.css">
    <link rel="stylesheet" type="text/css" href="/Donguri/css/footer.css">
    <link rel="stylesheet" type="text/css" href="/Donguri/css/donation/donation.css">
    <script src="/Donguri/js/header.js"></script>
    <script src="/Donguri/js/footer.js"></script>
    <script src="/Donguri/js/donation/donation.js"></script>
</head>
<body>
    <jsp:include page="/header.jsp" />
    <div class="wrapper">
        <div class="content">
            <h1>寄付ページ</h1>
            <!-- Buttons to open modals -->
            <button id="shareButton">共有</button>
            <button id="donateButton">寄付する</button>

            <!-- Donation Modal -->
            <div id="donationModal" class="modal">
                <div class="modalContent">
                    <span class="close">&times;</span>
                    <h1>寄付金額を選択</h1>
                    <form id="paymentForm">
                        <label for="modalAmount">寄付金額:</label>
                        <input type="text" id="modalAmount" name="modal_amount" value="">
                        <img id="linePayButton" src="https://d.line-scdn.net/linepay/merchant/center/images/devcenter/logo/logo_guide_color_default2_1.png" alt="Pay with LINE Pay" style="border: none; cursor: pointer;">
                    </form>
                    <div id="errorMessage" style="color: red; display: none;"></div>
                </div>
            </div>

            <!-- Share Modal -->
            <div id="shareModal" class="modal">
                <div class="modalContent">
                    <span class="close">&times;</span>
                    <h1>このページを共有</h1>
                    <input type="text" id="shareUrl" value="<%= request.getRequestURL().toString() %>" readonly>
                    <button id="copyUrl">URLをコピー</button>
                    <br>
                    <a href="https://twitter.com/share?url=<%= request.getRequestURL().toString() %>" target="_blank">Twitter</a>
                    <a href="https://www.instagram.com/?url=<%= request.getRequestURL().toString() %>" target="_blank">Instagram</a>
                    <a href="https://line.me/R/msg/text/?<%= request.getRequestURL().toString() %>" target="_blank">LINE</a>
                    <a href="https://share.naver.com/web/shareView.nhn?url=<%= request.getRequestURL().toString() %>" target="_blank">Naver</a>
                    <a href="https://sharer.kakao.com/talk/friends/picker/link?url=<%= request.getRequestURL().toString() %>" target="_blank">KakaoTalk</a>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/footer.jsp" />
</body>
</html>