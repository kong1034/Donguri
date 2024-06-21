document.addEventListener('DOMContentLoaded', function() {
    var donationBtn = document.getElementById('process_donation_button');
    var shareBtn = document.getElementById('share_button');
    var shareModal = document.getElementById('share_modal');
    var shareCloseBtn = document.getElementById('share_close');
    var loginStatus = "<%=request.getAttribute('loginStatus')%>";

    // Handle donation button click
    if (donationBtn) {
        donationBtn.addEventListener('click', function() {
            var amount = document.getElementById('donation_amount').value;
            var donationId = "<%=request.getParameter('id')%>";

            if (amount && donationId) {
                var userLoggedIn = (loginStatus === 'loggedIn'); // Replace this with your actual login check logic
                if (!userLoggedIn) {
                    alert('You need to log in to donate.');
                    window.location.href = '/Donguri/src/main/java/com/donguri/sign/LoginC';
                    return;
                }

                var popup = window.open('', 'LinePay', 'width=800,height=600');

                fetch('/Donguri/DonationC', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    body: new URLSearchParams({
                        amount: amount,
                        id: donationId
                    })
                })
                .then(response => response.json())
                .then(data => {
                    if (data.status === 'success') {
                        popup.location.href = data.paymentUrl;
                    } else {
                        alert('Failed to initiate payment.');
                        popup.close();
                    }
                })
                .catch(error => {
                    alert('An error occurred: ' + error.message);
                    popup.close();
                });
            } else {
                alert('Please enter a valid amount.');
            }
        });
    }

    // Handle share button click
    if (shareBtn) {
        shareBtn.addEventListener('click', function() {
            document.getElementById('share_link').value = window.location.href;
            shareModal.style.display = "block";
        });
    }

    // Handle close modal
    if (shareCloseBtn) {
        shareCloseBtn.addEventListener('click', function() {
            shareModal.style.display = "none";
        });
    }

    // Close modal if clicked outside
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