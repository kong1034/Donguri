<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<!-- CSS -->
<link rel="stylesheet" href="css/index.css" />
<!-- Jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<!-- <script>
function requestPayment() {
    var amount = $("#amount").val();
    $.ajax({
        type: "POST",
        url: "DonationC",
        data: { amount: amount },
        success: function(response) {
            var jsonResponse = JSON.parse(response);
            if (jsonResponse.status === "success") {
                window.open(jsonResponse.paymentUrl, "PaymentPopup", "width=800,height=600");
            } else {
                alert("Error: " + jsonResponse.message);
            }
        },
        error: function() {
            alert("Payment request failed.");
        }
    });
}
</script> -->
</head>
<body>
<%@ include file="jsp/common/header.jsp" %>

<h1>Main Page</h1>

<div class="container_wrapper">
      <div class="container_slide">
        <div class="mySlides fade">
          <img src="img/local/animal.webp" />
        </div>

        <div class="mySlides fade">
          <img src="img/local/racooncun.png" />
        </div>

        <div class="mySlides fade">
          <img src="img/local/racooncun.png" />
        </div>
      </div>
      <div class="container_items">
        <div class="item_left">
          <a href="">
            <div class="item left"></div>
          </a>
          <a href="">
            <div class="item_left_sub">コミュニティー</div>
          </a>
        </div>
        <div class="centers">
          <div class="center top">
            <div class="slogan">All For My Neighbors</div>
          </div>
          <div class="center bottom">
            <a href="">
              <div class="item center_left"></div>
            </a>
            <a href="">
              <div class="item center_center">情報一覧</div>
            </a>
            <a href="">
              <div class="item center_right"></div>
            </a>
          </div>
        </div>
        <div class="item_right">
          <a href="">
            <div class="item right"></div>
          </a>
          <a href="">
            <div class="item_right_sub">ドネーション</div>
          </a>
        </div>
      </div>
      <div class="container_community_info">
        <div class="community_info_top">Community</div>
        <div class="community_info_wrap">
          <a href="">
            <div class="community info">
              <div class="acorn"></div>
            </div>
          </a>
          <a href="">
            <div class="community info">
              <div class="acorn"></div>
            </div>
          </a>
          <a href="">
            <div class="community info">
              <div class="acorn"></div>
            </div>
          </a>
          <a href="">
            <div class="community info">
              <div class="acorn"></div>
            </div>
          </a>
          <a href="">
            <div class="community info">
              <div class="acorn"></div>
            </div>
          </a>
          <a href="">
            <div class="community info">
              <div class="acorn"></div>
            </div>
          </a>
          <a href="">
            <div class="community info">
              <div class="acorn"></div>
            </div>
          </a>
          <a href="">
            <div class="community info">
              <div class="acorn"></div>
            </div>
          </a>
          <a href="">
            <div class="community info">
              <div class="acorn"></div>
            </div>
          </a>
        </div>
      </div>
      <div class="container_aboutus">
        <div class="aboutus_top">About us</div>
        <div class="aboutus_middle">
          donation + めぐり <br />
          don + ぐり <br />
          <br />
          <span> Donguri </span>
        </div>
        <div class="aboutus_bottom">
          <div class="aboutus_icon">
            <img src="img/local/icon/united_4086231.png" alt="" />
          </div>
          <div class="aboutus_icon">
            <img src="img/local/icon/dog_2064847.png" alt="" />
          </div>
          <div class="aboutus_icon">
            <img src="img/local/icon/tree_3337698.png" alt="" />
          </div>
        </div>
      </div>
    </div>
<jsp:include page="jsp/common/footer.jsp"></jsp:include>
    <script src="js/index.js"></script>
</body>
</html>