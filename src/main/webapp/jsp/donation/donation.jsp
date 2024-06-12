<%@ page contentType="text/html; charset=UTF-8" %>
<h1>寄付ページ</h1>
<!-- Display success or failure message -->
<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
        out.println("<div class='message'>" + message + "</div>");
    }
%>
<!-- Buttons to open modals -->
<button id="shareButton">共有</button>
<button id="donateButton">寄付する</button>

<!-- Donation Modal -->
<div id="donationModal" class="modal">
    <div class="modalContent">
        <span class="close">&times;</span>
        <h1>寄付金額を選択</h1>
        <form id="paymentForm" action="/Donguri/DonationLinepayC" method="POST">
            <label for="modalAmount">寄付金額:</label>
            <input type="text" id="modalAmount" name="modal_amount" value="">
            <button type="submit">
                <img src="https://d.line-scdn.net/linepay/merchant/center/images/devcenter/logo/logo_guide_color_default2_1.png" alt="Pay with LINE Pay" style="border: none;">
            </button>
        </form>
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
        <a href="#" id="kakaoShare">KakaoTalk</a>
    </div>
</div>