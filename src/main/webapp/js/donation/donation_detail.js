document.addEventListener('DOMContentLoaded', function() {
    var shareBtn = document.getElementById('share_button');
    var donateBtn = document.getElementById('donate_button');
    var shareModal = document.getElementById('share_modal');
    var donateModal = document.getElementById('donate_modal');
    var shareCloseBtn = document.getElementById('share_close');
    var donateCloseBtn = document.getElementById('donate_close');
    var processDonationBtn = document.getElementById('process_donation_button');

    shareBtn.addEventListener('click', function() {
        shareModal.style.display = "block";
    });

    donateBtn.addEventListener('click', function() {
        donateModal.style.display = "block";
    });

    shareCloseBtn.addEventListener('click', function() {
        shareModal.style.display = "none";
    });

    donateCloseBtn.addEventListener('click', function() {
        donateModal.style.display = "none";
    });

    window.addEventListener('click', function(event) {
        if (event.target == shareModal) {
            shareModal.style.display = "none";
        }
        if (event.target == donateModal) {
            donateModal.style.display = "none";
        }
    });

    processDonationBtn.addEventListener('click', function() {
        var amount = document.getElementById('donation_amount').value;

        if (!amount) {
            alert('Please enter a valid amount.');
            return;
        }

        fetch('/Donguri/DonationC', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                modal_amount: amount
            })
        })
        .then(response => response.json())
        .then(data => {
            if (data.status === 'success') {
                window.open(data.paymentUrl, '_blank');
            } else {
                alert('Payment failed: ' + data.message);
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('An error occurred during payment processing.');
        });
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