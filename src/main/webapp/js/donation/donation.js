document.addEventListener('DOMContentLoaded', function() {
    var shareButton = document.getElementById("share_button");
    var donateButton = document.getElementById("donate_button");
    var donationModal = document.getElementById("donation_modal");
    var shareModal = document.getElementById("share_modal");
    var closeButtons = document.querySelectorAll(".close");
    var copyUrlButton = document.getElementById("copy_url");
    var shareUrlInput = document.getElementById("share_url");
    var linepayImage = document.getElementById("linepay_image");

    // Show share modal
    shareButton.addEventListener("click", function() {
        shareModal.style.display = "block";
    });

    // Show donation modal
    donateButton.addEventListener("click", function() {
        donationModal.style.display = "block";
    });

    // Close modals on close button click
    closeButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            donationModal.style.display = "none";
            shareModal.style.display = "none";
        });
    });

    // Close modals on outside click
    window.onclick = function(event) {
        if (event.target == donationModal) {
            donationModal.style.display = "none";
        }
        if (event.target == shareModal) {
            shareModal.style.display = "none";
        }
    };

    // Copy URL to clipboard
    copyUrlButton.addEventListener("click", function() {
        shareUrlInput.select();
        shareUrlInput.setSelectionRange(0, 99999);
        document.execCommand("copy");
        alert("URL has been copied");
    });

    // Handle payment form submission
    document.getElementById("payment_form").addEventListener("submit", handlePaymentSubmit);

    // Handle LINE Pay image click
    linepayImage.addEventListener("click", function() {
        document.getElementById("payment_form").submit();
    });
});

// Function to handle payment form submission
function handlePaymentSubmit(event) {
    event.preventDefault();
    var modalAmount = document.getElementById("modal_amount").value;

    fetch("/Donguri/DonationC", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "modal_amount=" + encodeURIComponent(modalAmount)
    })
    .then(response => response.json())
    .then(data => {
        if (data.status === "success") {
            var linepayPopup = window.open(data.paymentUrl, "linepay_popup", "width=700,height=500");
            if (linepayPopup) {
                linepayPopup.focus();
            } else {
                alert("Please allow pop-ups for this website.");
            }
        } else {
            console.error("Payment failed:", data.message);
            document.getElementById("payment_message").textContent = "Payment failed: " + data.message;
        }
    })
    .catch(error => {
        console.error("Error:", error);
        document.getElementById("payment_message").textContent = "Error: " + error.message;
    });
}