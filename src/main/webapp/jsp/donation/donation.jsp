<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Donation Page</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/donation/donation.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/footer.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js"
        integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
    <script src="<%= request.getContextPath() %>/js/donation/donation.js"></script>
</head>
<body>
    <div class="wrapper">
        <jsp:include page="/header.jsp" />

        <div class="content">
            <h1>Donation Page</h1>
            <!-- Buttons to open modals -->
            <button id="shareButton">Share</button>
            <button id="donateButton">Donate</button>

            <!-- Donation Modal -->
            <div id="donationModal" class="modal">
                <div class="modalContent">
                    <span class="close">&times;</span>
                    <h1>寄付金額を選択してください</h1>
                    <form id="paymentForm">
                        <label for="modalAmount">寄付金額:</label>
                        <input type="text" id="modalAmount" name="modalAmount" value="">
                        <img id="linePayImage" src="https://d.line-scdn.net/linepay/merchant/center/images/devcenter/logo/logo_guide_color_default2_1.png" alt="Pay with LINE Pay" style="border: none; cursor: pointer;">
                    </form>
                    <div id="result"></div> <!-- Place for error or success messages -->
                </div>
            </div>

            <!-- Share Modal -->
            <div id="shareModal" class="modal">
                <div class="modalContent">
                    <span class="close">&times;</span>
                    <h1>このページを共有する</h1>
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

        <jsp:include page="/footer.jsp" />
    </div>
</body>
</html>