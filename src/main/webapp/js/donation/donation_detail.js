document.addEventListener('DOMContentLoaded', function() {
    const donateButton = document.getElementById('donate_button');
    const shareButton = document.getElementById('share_button');
    const shareModal = document.getElementById('share_modal');
    const closeButton = document.getElementById('modal_close');
    const loginStatus = "<%=request.getAttribute('loginStatus')%>";

    donateButton.addEventListener('click', function() {
        const amount = document.getElementById('donation_amount').value;
        const donationId = "<%=request.getParameter('id')%>";

        if (amount && donationId) {
            const userLoggedIn = (loginStatus === 'loggedIn'); 
            if (!userLoggedIn) {
                alert('You need to log in to donate.');
                window.location.href = '/Donguri/src/main/java/com/donguri/sign/LoginC';
                return;
            }

            const popup = window.open('', 'LinePay', 'width=800,height=600');

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

    shareButton.addEventListener('click', function(event) {
        document.getElementById('share_link').value = window.location.href;
        shareModal.style.display = "flex"; // Show modal with flex display
    });

    closeButton.addEventListener('click', function() {
        shareModal.style.display = "none";
    });

    window.addEventListener('click', function(event) {
        if (event.target === shareModal) {
            shareModal.style.display = "none";
        }
    });

    document.getElementById('twitter_share').href = `https://twitter.com/intent/tweet?url=${encodeURIComponent(window.location.href)}`;
    document.getElementById('instagram_share').href = `https://www.instagram.com/?url=${encodeURIComponent(window.location.href)}`;
    document.getElementById('line_share').href = `https://line.me/R/msg/text/?${encodeURIComponent(window.location.href)}`;
});

function copyToClipboard(selector) {
    const text = document.querySelector(selector).value;
    const tempInput = document.createElement('input');
    tempInput.value = text;
    document.body.appendChild(tempInput);
    tempInput.select();
    document.execCommand('copy');
    document.body.removeChild(tempInput);
    alert('Link copied to clipboard');
}
