<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>기부 페이지</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <form id="paymentForm">
        <label for="amount">기부 금액:</label>
        <input type="text" id="amount" name="amount" required>
        <button type="submit">기부하기</button>
    </form>
    <div id="result"></div>

    <script>
        $(document).ready(function() {
            $("#paymentForm").submit(function(event) {
                event.preventDefault();
                $.ajax({
                    type: "POST",
                    url: "<%=request.getContextPath()%>/DonationC", // URL 경로 수정
                    data: { amount: $("#amount").val() },
                    success: function(response) {
                        if (response.status === "success") {
                            window.location.href = response.paymentUrl;
                        } else {
                            $("#result").html("결제 실패: " + response.message);
                        }
                    },
                    error: function() {
                        $("#result").html("서버 오류가 발생했습니다.");
                    }
                });
            });
        });
    </script>
</body>
</html>
