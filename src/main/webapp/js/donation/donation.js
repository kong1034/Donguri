// Function to open modal
function openModal(modalId) {
    document.getElementById(modalId).style.display = "block";
}

// Function to close modal
function closeModal(modalId) {
    document.getElementById(modalId).style.display = "none";
}

// Function to copy URL to clipboard
function copyToClipboard(elementId) {
    var copyText = document.getElementById(elementId);
    copyText.select();
    copyText.setSelectionRange(0, 99999); // For mobile devices
    document.execCommand("copy");
    alert("Copied the URL: " + copyText.value);
}

document.addEventListener("DOMContentLoaded", function() {
    // Open share modal
    document.getElementById("shareButton").onclick = function() {
        openModal("shareModal");
    };
    // Open donation modal
    document.getElementById("donateButton").onclick = function() {
        openModal("donationModal");
    };
    // Close modals
    document.querySelectorAll(".close").forEach(function(element) {
        element.onclick = function() {
            closeModal(element.closest(".modal").id);
        };
    });
    // Copy URL to clipboard
    document.getElementById("copyUrl").onclick = function() {
        copyToClipboard("shareUrl");
    };

    // Submit donation form
    document.getElementById("linePayButton").onclick = function(event) {
        event.preventDefault();
        var modalAmount = document.getElementById("modalAmount").value;
        document.getElementById("errorMessage").style.display = "none"; // Hide error message

        fetch('/Donguri/DonationLinepayC', {
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
                closeModal('donationModal'); // Close the modal
                window.open(data.paymentUrl, '_blank'); // Open payment URL in a new tab
            } else {
                document.getElementById("errorMessage").innerText = "Error: " + data.message;
                document.getElementById("errorMessage").style.display = "block";
            }
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById("errorMessage").innerText = "Server error occurred.";
            document.getElementById("errorMessage").style.display = "block";
        });
    };
});