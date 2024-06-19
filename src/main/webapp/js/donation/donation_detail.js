document.addEventListener('DOMContentLoaded', function() {
    var shareBtn = document.getElementById('share_button');
    var shareModal = document.getElementById('share_modal');
    var shareCloseBtn = document.getElementById('share_close');

    shareBtn.addEventListener('click', function() {
        shareModal.style.display = "block";
    });

    shareCloseBtn.addEventListener('click', function() {
        shareModal.style.display = "none";
    });

    window.addEventListener('click', function(event) {
        if (event.target == shareModal) {
            shareModal.style.display = "none";
        }
    });
});

function copyToClipboard(selector) {
    var text = document.querySelector(selector).value;
    var tempInput = document.createElement('input');
    tempInput.value = text;
    document.body.appendChild(tempInput);
    tempInput.select();
    document.execCommand('copy');
    document.body.removeChild(tempInput);
    alert('Link copied to clipboard');
}