document.addEventListener("DOMContentLoaded", function() {
    var shareButton = document.getElementById("share_button");
    var donateButton = document.getElementById("donate_button");
    var donationModal = document.getElementById("donation_modal");
    var shareModal = document.getElementById("share_modal");
    var closeButtons = document.querySelectorAll(".close");
    var copyUrlButton = document.getElementById("copy_url");
    var shareUrlInput = document.getElementById("share_url");

    shareButton.addEventListener("click", function() {
        shareModal.style.display = "block";
    });

    donateButton.addEventListener("click", function() {
        donationModal.style.display = "block";
    });

    closeButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            donationModal.style.display = "none";
            shareModal.style.display = "none";
        });
    });

    window.onclick = function(event) {
        if (event.target == donationModal) {
            donationModal.style.display = "none";
        }
        if (event.target == shareModal) {
            shareModal.style.display = "none";
        }
    };

    copyUrlButton.addEventListener("click", function() {
        shareUrlInput.select();
        shareUrlInput.setSelectionRange(0, 99999);
        document.execCommand("copy");
        alert("URLがコピーされました");
    });

    document.getElementById("payment_form").addEventListener("submit", function(event) {
        event.preventDefault();
        var modalAmount = document.getElementById("modal_amount").value;

        fetch("/PaymentC", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: "modal_amount=" + encodeURIComponent(modalAmount)
        })
        .then(response => response.json())
        .then(data => {
            if (data.status === "success") {
                window.location.href = data.paymentUrl;
            } else {
                console.error("Payment failed:", data.message);
                document.getElementById("payment_message").textContent = "Payment failed: " + data.message;
            }
        })
        .catch(error => {
            console.error("Error:", error);
            document.getElementById("payment_message").textContent = "Error: " + error.message;
        });
    });
});