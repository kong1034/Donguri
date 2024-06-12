document.addEventListener("DOMContentLoaded", function() {
    // Add any common JS functionality here

    // Example for modal handling
    function openModal(modalId) {
        document.getElementById(modalId).style.display = "block";
    }

    function closeModal(modalId) {
        document.getElementById(modalId).style.display = "none";
    }

    document.querySelectorAll(".close").forEach(function(element) {
        element.onclick = function() {
            closeModal(element.closest(".modal").id);
        };
    });

    document.getElementById("shareButton").onclick = function() {
        openModal("shareModal");
    };

    document.getElementById("donateButton").onclick = function() {
        openModal("donationModal");
    };

    document.getElementById("copyUrl").onclick = function() {
        var copyText = document.getElementById("shareUrl");
        copyText.select();
        document.execCommand("copy");
        alert("URL copied: " + copyText.value);
    };

    // KakaoTalk Share Button
    document.getElementById("kakaoShare").onclick = function() {
        // Add KakaoTalk sharing functionality here
        alert("KakaoTalk sharing is not yet implemented.");
    };
});