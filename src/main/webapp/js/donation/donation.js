document.addEventListener("DOMContentLoaded", function() {
    var donationModal = document.getElementById("donation_modal");
    var shareModal = document.getElementById("share_modal");
    var donateBtn = document.getElementById("donate_button");
    var shareBtn = document.getElementById("share_button");
    var closeButtons = document.getElementsByClassName("close");

    donateBtn.onclick = function() {
        donationModal.style.display = "block";
    }

    shareBtn.onclick = function() {
        shareModal.style.display = "block";
    }

    Array.from(closeButtons).forEach(function(btn) {
        btn.onclick = function() {
            btn.parentElement.parentElement.style.display = "none";
        }
    });

    window.onclick = function(event) {
        if (event.target == donationModal) {
            donationModal.style.display = "none";
        }
        if (event.target == shareModal) {
            shareModal.style.display = "none";
        }
    }

    document.getElementById("copy_url").onclick = function() {
        var shareUrl = document.getElementById("share_url");
        shareUrl.select();
        document.execCommand("copy");
        alert("URL copied.");
    }

    document.getElementById("kakao_share").onclick = function() {
        Kakao.Link.sendDefault({
            objectType: 'feed',
            content: {
                title: '寄付ページ',
                description: 'このページを共有',
                link: {
                    mobileWebUrl: document.getElementById("share_url").value,
                    webUrl: document.getElementById("share_url").value
                }
            }
        });
    }
});