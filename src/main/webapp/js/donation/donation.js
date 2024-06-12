document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("paymentForm").onsubmit = function(event) {
        event.preventDefault();
        var modalAmount = document.getElementById("modalAmount").value;
        
        fetch('DonationLinepayC', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams({
                modal_amount: modalAmount
            })
        })
        .then(response => response.json())
        .then(data => {
            if (data.status === 'success') {
                window.location.href = data.paymentUrl;
            } else {
                alert("Error: " + data.message);
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    };
});