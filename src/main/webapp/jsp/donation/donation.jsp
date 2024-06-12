<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.donguri.donation.DTODonation" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Donation Page</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/donation/donation.css">
    <script src="<%= request.getContextPath() %>/js/donation/donation.js"></script>
</head>
<body>
    <h1>寄付ページ</h1>

    <!-- Buttons to open modals -->
    <button id="share_button">共有</button>
    <button id="donate_button">寄付する</button>

    <!-- Donation Modal -->
    <div id="donation_modal" class="modal">
        <div class="modal_content">
            <span class="close">&times;</span>
            <h1>寄付金額を選択</h1>
            <form id="payment_form" action="<%= request.getContextPath() %>/DonationLinepayC" method="POST" target="linepay_popup" onsubmit="return handlePaymentSubmit(event)">
                <label for="modal_amount">寄付金額:</label>
                <input type="text" id="modal_amount" name="modal_amount" value="">
                <button type="submit">
                    <img src="https://d.line-scdn.net/linepay/merchant/center/images/devcenter/logo/logo_guide_color_default2_1.png" alt="Pay with LINE Pay" style="border: none;">
                </button>
                <p id="payment_message" class="message"></p>
            </form>
        </div>
    </div>

    <!-- Share Modal -->
    <div id="share_modal" class="modal">
        <div class="modal_content">
            <span class="close">&times;</span>
            <h1>このページを共有</h1>
            <input type="text" id="share_url" value="<%= request.getRequestURL().toString() %>" readonly>
            <button id="copy_url">URLをコピー</button>
            <br>
            <a href="https://twitter.com/share?url=<%= request.getRequestURL().toString() %>" target="_blank">Twitter</a>
            <a href="https://www.instagram.com/?url=<%= request.getRequestURL().toString() %>" target="_blank">Instagram</a>
            <a href="https://line.me/R/msg/text/?<%= request.getRequestURL().toString() %>" target="_blank">LINE</a>
            <a href="#" id="kakao_share">KakaoTalk</a>
        </div>
    </div>

    <!-- Donation list display -->
    <h2>寄付一覧</h2>
    <table>
        <thead>
            <tr>
                <th>寄付番号</th>
                <th>ユーザーID</th>
                <th>寄付タイトル</th>
                <th>寄付内容</th>
                <th>寄付日</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<DTODonation> donations = (List<DTODonation>) request.getAttribute("donations");
                if (donations != null && !donations.isEmpty()) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    for (DTODonation donation : donations) {
            %>
            <tr>
                <td><%= donation.getD_no() %></td>
                <td><%= donation.getUser_id() %></td>
                <td><%= donation.getDonation_title() %></td>
                <td><%= donation.getDonation_content() %></td>
                <td><%= dateFormat.format(donation.getDonation_date()) %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">寄付がありません。</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <script src="<%= request.getContextPath() %>/js/donation/donation.js"></script>
</body>
</html>