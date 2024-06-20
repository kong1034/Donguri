document.addEventListener('DOMContentLoaded', function() {
    var shareBtn = document.getElementById('share_button');
    var shareModal = document.getElementById('share_modal');
    var shareCloseBtn = document.getElementById('share_close');

    if (shareBtn) {
        shareBtn.addEventListener('click', function() {
            shareModal.style.display = "block";
        });
    }

    if (shareCloseBtn) {
        shareCloseBtn.addEventListener('click', function() {
            shareModal.style.display = "none";
        });
    }

    window.addEventListener('click', function(event) {
        if (event.target == shareModal) {
            shareModal.style.display = "none";
        }
    });
    
    // Change footer border color on scroll
    window.addEventListener('scroll', function() {
        var footer = document.getElementById('footer_container');
        if (window.scrollY + window.innerHeight >= document.body.offsetHeight) {
            footer.style.borderColor = '#4CAF50'; /* Change to green */
        } else {
            footer.style.borderColor = '#ddd'; /* Default color */
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