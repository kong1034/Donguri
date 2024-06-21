document.addEventListener('DOMContentLoaded', function() {
    var footer = document.getElementById('footer_container');

    footer.addEventListener('mouseenter', function() {
        footer.classList.add('hover');
    });

    footer.addEventListener('mouseleave', function() {
        footer.classList.remove('hover');
    });

    // Change footer border color on scroll
    window.addEventListener('scroll', function() {
        if (window.scrollY + window.innerHeight >= document.body.offsetHeight) {
            footer.style.borderColor = '#4CAF50'; /* Change to green */
        } else {
            footer.style.borderColor = '#ddd'; /* Default color */
        }
    });
});

document.addEventListener('DOMContentLoaded', function() {
    var shareBtn = document.getElementById('share_button');
    var shareModal = document.getElementById('share_modal');
    var shareCloseBtn = document.getElementById('share_close');

    if (shareBtn) {
        shareBtn.addEventListener('click', function() {
            document.getElementById('share_link').value = window.location.href;
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

    // Set up share links
    document.getElementById('twitter_share').href = 'https://twitter.com/intent/tweet?url=' + encodeURIComponent(window.location.href);
    document.getElementById('instagram_share').href = 'https://www.instagram.com/?url=' + encodeURIComponent(window.location.href);
    document.getElementById('line_share').href = 'https://line.me/R/msg/text/?' + encodeURIComponent(window.location.href);
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