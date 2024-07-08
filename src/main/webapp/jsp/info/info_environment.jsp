<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Environmental Donation Sites</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/info/info.css">
<script src="<%=request.getContextPath()%>/js/info/info_environment.js"></script>
</head>
<body>
    <div class="info_all_content_box">
        <div class="info_all_content">
            <img src="https://www.greenpeace.org/korea/wp-content/themes/planet4-master-theme/images/Greenpeace-logo.png" onclick="goSite(1)" class="content_img">
            <div class="content_text_box">
                <p>Greenpeace</p>
                <p>TEL: +31 20 718 2000</p>
            </div>
        </div>
        <div class="info_all_content">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/CIlogo.svg/1200px-CIlogo.svg.png" onclick="goSite(2)" class="content_img">
            <div class="content_text_box">
                <p>Conservation International</p>
                <p>TEL: 1-800-429-5660</p>
            </div>
        </div>
        <div class="info_all_content">
            <img src="https://www.nature.org/content/dam/tnc/nature/en/logos/tnc-logo-primary-registered-dark-text.svg" onclick="goSite(3)" class="content_img">
            <div class="content_text_box">
                <p>The Nature Conservancy</p>
                <p>TEL: 1-800-628-6860</p>
            </div>
        </div>
        <div class="info_all_content">
            <img src="https://www.sierraclub.org/sites/default/themes/custom/bootpt/logo.svg" onclick="goSite(4)" class="content_img">
            <div class="content_text_box">
                <p>Sierra Club</p>
                <p>TEL: 415-977-5500</p>
            </div>
        </div>
        <div class="info_all_content">
            <img src="https://oceana.org/wp-content/uploads/sites/18/logo_en_full.png" onclick="goSite(5)" class="content_img">
            <div class="content_text_box">
                <p>Oceana</p>
                <p>TEL: +1.202.833.3900</p>
            </div>
        </div>
        <div class="info_all_content">
            <img src="https://earthjustice.org/wp-content/uploads/ej_logo.svg" onclick="goSite(6)" class="content_img">
            <div class="content_text_box">
                <p>Earthjustice</p>
                <p>TEL: 202-518-0044</p>
            </div>
        </div>
        <div class="info_all_content">
            <img src="https://www.foei.org/wp-content/uploads/2020/12/logo-EN.svg" onclick="goSite(7)" class="content_img">
            <div class="content_text_box">
                <p>Friends of the Earth</p>
                <p>TEL: +44 (0)20 7490 1555</p>
            </div>
        </div>
    </div>
</body>
</html>