<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Donation Success Page</title>
    <link rel="stylesheet" type="text/css" href="css/donation/donation_detail.css">
</head>
<body>
<div class="container">
    <main class="donation_main">
        <div class="donation_container">
            <div class="details_container">
                <p>寄付が成功しました！</p>
                <p>ご支援ありがとうございます。</p>
                <p>注文ID: ${param.orderId}</p>
                <p>取引ID: ${param.transactionId}</p>
            </div>
        </div>
    </main>
</div>
</body>
</html>