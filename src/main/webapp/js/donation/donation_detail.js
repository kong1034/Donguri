document.addEventListener('DOMContentLoaded', function() {
    var openDonationModalBtn = document.getElementById('open_donation_modal');
    var donationModal = document.getElementById('donation_modal');
    var donationCloseBtn = document.getElementById('donation_close');
    var donationBtn = document.getElementById('process_donation_button');

    // Open modal
    if (openDonationModalBtn) {
        openDonationModalBtn.addEventListener('click', function() {
            var userLoggedIn = /* Check if user is logged in */;
            if (!userLoggedIn) {
                alert('You need to log in to donate.');
                window.location.href = '/Donguri/src/main/java/com/donguri/sign/LoginC';
                return;
            }
            donationModal.style.display = "block";
        });
    }

    // Close modal
    if (donationCloseBtn) {
        donationCloseBtn.addEventListener('click', function() {
            donationModal.style.display = "none";
        });
    }

    // Close modal when clicking outside of it
    window.addEventListener('click', function(event) {
        if (event.target == donationModal) {
            donationModal.style.display = "none";
        }
    });

    // Handle donation button click
    if (donationBtn) {
        donationBtn.addEventListener('click', function() {
            var amount = document.getElementById('donation_amount').value;
            var donationId = document.getElementById('donation_id').value;

            if (amount && donationId) {
                fetch('/Donguri/DonationC', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    body: `id=${donationId}&amount=${amount}`
                })
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    if (data.status === 'success') {
                        window.open(data.paymentUrl, 'LinePay', 'width=800,height=600');
                    } else {
                        alert('Payment initiation failed. Please try again.');
                    }
                })
                .catch(error => console.error('Error:', error));
            } else {
                alert('Please enter a valid amount and donation ID.');
            }
        });
    }
});
