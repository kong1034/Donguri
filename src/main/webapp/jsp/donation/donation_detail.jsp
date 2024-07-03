<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/donation/donation_detail.css" />
    <script src="<%=request.getContextPath()%>/js/donation/donation_detail.js"></script>
</head>
<body>
    <div class="wrapper">
        <main class="donation_main">
            <div class="donation_container">
                <div class="left_section">
                    <div class="image_container">
                        <c:choose>
                            <c:when test="${not empty selected_info.thumnail}">
                                <img src="${selected_info.thumnail}" alt="Donation Image" style="width: 75%;">
                            </c:when>
                        </c:choose>
                    </div>
                    <span class="categori_tag"># 環境</span>
                    <div class="donation_goal">
                        <div class="amount">
                            <span>${not empty selected_info.amount ? selected_info.amount : 0}</span>
                            <span>円</span>
                        </div>
                        <div class="percentage">
                            <div class="percentage_img_box">
                                <img alt="donguri" src="<%=request.getContextPath()%>/img/local/dongguri.svg">
                            </div>
                            <span data-percentage="${not empty selected_info.amount && selected_info.amount != 0 ? (selected_info.sum / selected_info.amount * 100) : 0}%">
                                ${not empty selected_info.sum ? (selected_info.sum / selected_info.amount * 100) : 0}%
                            </span>
                        </div>
                    </div>
                    <div class="company_period_container">
                        <div class="company_container">
                            <p>
                                <span>募金機関</span>
                                <span>${not empty selected_info.publisher ? selected_info.publisher : '募金機関'}</span>
                            </p>
                        </div>
                        <div class="period_container">
                            <p>
                                <span>募金期間</span>
                                <span>${not empty selected_info.created_date ? selected_info.created_date : 'YYYY-MM-DD'}</span>
                                <span>~</span>
                                <span>${not empty selected_info.d_date ? selected_info.d_date : 'YYYY-MM-DD'}</span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="right_section">
                    <div class="donation_actions">
                        <div class="right_first_area">
                            <p>寄付する</p>
                            <p>${not empty selected_info.content ? selected_info.content : 'ここに説明が入ります。'}</p>
                        </div>
                        <div class="right_second_area">
                            <div class="button_container">
                                <div class="button_box">
                                    <input type="number" id="donation_amount" name="amount" min="1" placeholder="金額を入力" required>
                                    <button id="process_donation_button" class="donate_button">寄付する</button>
                                    <button id="share_button" class="share_button">共有する</button>
                                </div>
                                <div id="amount_options" class="amount_options">
                                    <div class="amount_option">直接入力</div>
                                    <div class="amount_option">100円</div>
                                    <div class="amount_option">500円</div>
                                    <div class="amount_option">1000円</div>
                                    <div class="amount_option">5000円</div>
                                    <div class="amount_option">10000円</div>
                                    <div class="amount_option">50000円</div>
                                    <div class="amount_option">100000円</div>
                                    <div class="amount_option">500000円</div>
                                    <div class="amount_option">1000000円</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <input class="u_id" type="hidden" value="<%=session.getAttribute("user.u_id")%>"/>
    </div>

    <!-- Share Modal -->
    <div id="share_modal" class="modal">
        <div class="modal_content">
            <span id="share_close" class="close">&times;</span>
            <div class="share_container">
                <div class="share_title">共有する</div>
                <div class="share_link_container">
                    <input type="text" value="" id="share_link" readonly>
                    <button onclick="copyToClipboard('#share_link')" class="copy_button">コピー</button>
                </div>
            </div>
            <div class="sns_links">
                <button class="sns_button" onclick="window.open('https://www.facebook.com/sharer/sharer.php?u=' + document.getElementById('share_link').value, '_blank')">Share on Facebook</button>
                <button class="sns_button" onclick="window.open('https://twitter.com/intent/tweet?url=' + document.getElementById('share_link').value + '&text=Check%20out%20this%20donation%20page!', '_blank')">Share on Twitter</button>
                <button class="sns_button" onclick="window.open('https://social-plugins.line.me/lineit/share?url=' + document.getElementById('share_link').value, '_blank')">Share on LINE</button>
            </div>
        </div>
    </div>
</body>
</html>