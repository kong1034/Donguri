document.addEventListener('DOMContentLoaded', function() {
    var loginChk = '<%=request.getAttribute("loginChk")%>';
    var header = document.getElementById('header_container');

    if (loginChk === 'login') {
        document.querySelectorAll('#unlogin').forEach(function(span) {
            span.style.display = 'none';
        });
    }

    header.addEventListener('mouseenter', function() {
        header.classList.add('hover');
    });

    header.addEventListener('mouseleave', function() {
        header.classList.remove('hover');
    });

    // Logo img animation
    $(".header_logo_img").css("transform", "translateX(81%) rotate(1110deg)");
    $(".header_logo_img").css("transition", "all 3s ease");

    let check = setInterval(function() {
        var rect = $('.header_logo_img')[0].getBoundingClientRect();

        if (rect.right > 282) {
            $(".header_logo_img").css("transform", "translateX(80%) rotate(1080deg)");
            $(".header_logo_img").css("transition", "all 3s linear");
        }
    }, 100);

    setTimeout(function() {
        clearInterval(check);
    }, 5000);
});

$(function () {
    // Find Cookie
    function getCookie(name) {
        var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
        return value ? value[2] : null;
    }

    var jwtToken = getCookie("jwtToken");
    const spans = document.querySelectorAll('#unlogin'); 
    var loginElements = document.querySelectorAll('.login');

    // Login
    if (jwtToken != null) {
        spans.forEach(function(span) {
            span.style.display = 'none';
        });
        loginElements.forEach(function(element) {
            element.style.display = 'block';
        });
    }
    // Unlogin
    if (jwtToken == null) {
        spans[0].style.display = 'block';
        loginElements.forEach(function(element) {
            element.style.display = 'none';
        });
    }
});