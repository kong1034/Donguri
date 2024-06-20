document.addEventListener('DOMContentLoaded', function() {
    var openDonationModalBtn = document.getElementById('open_donation_modal');
    var donationModal = document.getElementById('donation_modal');
    var donationCloseBtn = document.getElementById('donation_close');
    var donationBtn = document.getElementById('process_donation_button');

    if (openDonationModalBtn) {
        openDonationModalBtn.addEventListener('click', function() {
            donationModal.style.display = "block";
        });
    }

    if (donationCloseBtn) {
        donationCloseBtn.addEventListener('click', function() {
            donationModal.style.display = "none";
        });
    }

    window.addEventListener('click', function(event) {
        if (event.target == donationModal) {
            donationModal.style.display = "none";
        }
    });

    if (donationBtn) {
        donationBtn.addEventListener('click', function() {
            var form = document.getElementById('donation_form');
            var amount = document.getElementById('donation_amount').value;

            if (amount) {
                fetch('/DonationC', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    body: new URLSearchParams(new FormData(form))
                })
                .then(response => response.json())
                .then(data => {
                    if (data.status === 'success') {
                        window.open(data.paymentUrl, 'LinePay', 'width=800,height=600');
                    } else {
                        alert('Payment initiation failed. Please try again.');
                    }
                })
                .catch(error => console.error('Error:', error));
            } else {
                alert('Please enter a valid amount.');
            }
        });
    }
});