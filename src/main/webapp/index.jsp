<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<%@ include file="/header.jsp" %>

<h1>Main Page</h1>

<%@ include file="/footer.jsp" %>
</body>
</html>