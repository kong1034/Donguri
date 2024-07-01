document.addEventListener('DOMContentLoaded', function() {
    var donationBtn = document.getElementById('process_donation_button');
    var shareBtn = document.getElementById('share_button');
    var shareModal = document.getElementById('share_modal');
    var shareCloseBtn = document.getElementById('share_close');
    var donationAmountInput = document.getElementById('donation_amount');
    var userId = document.querySelector('.u_id').value;

    // Handle donation button click
    if (donationBtn) {
        donationBtn.addEventListener('click', function() {
            if (userId) {
                processLinePay();
            } else {
                alert('Please log in.');
                window.location.href = '/login'; // Adjust the login URL as necessary
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

    // Process Line Pay
    function processLinePay() {
        var amount = donationAmountInput.value;
        var donationId = 'donation123'; // Set your donation ID

        if (amount && parseFloat(amount) > 0 && donationId) {
            var width = 800;
            var height = 600;
            var left = (screen.width - width) / 2;
            var top = (screen.height - height) / 2;
            var popup = window.open('', 'LinePay', `width=${width},height=${height},top=${top},left=${left}`);

            fetch('/Donguri/DonationC', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    amount: amount,
                    id: donationId
                })
            })
            .then(response => response.json())
            .then(data => {
                console.log("Server response: ", data);
                if (data.info && data.info.paymentUrl) {
                    popup.location.href = data.info.paymentUrl.web;
                    setTimeout(() => {
                        popup.close();
                    }, 10000); // Close the popup after 10 seconds
                } else {
                    alert('Failed to initiate payment: ' + (data.message || 'Unknown error'));
                    popup.close();
                }
            })
            .catch(error => {
                console.error('An error occurred: ', error);
                alert('An error occurred: ' + error);
                popup.close();
            });
        } else {
            alert('Please enter a valid amount.');
        }
    }
});

function copyToClipboard(element) {
    var copyText = document.querySelector(element);
    copyText.select();
    document.execCommand("copy");
    alert("URLがコピーされました: " + copyText.value);
}
