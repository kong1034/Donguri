$(document).ready(function() {
    // Show the donation modal
    $("#donateButton").click(function() {
        $("#donationModal").show();
    });

    // Close the modal when the 'x' is clicked
    $(".close").click(function() {
        $(".modal").hide();
    });

    // Handle the image click event
    $("#linePayImage").click(function(event) {
        event.preventDefault();
        $.ajax({
            type: "POST",
            url: "/Donguri/DonationC",
            data: { modal_amount: $("#modalAmount").val() },
            dataType: "json",
            success: function(response) {
                if (response.status === "success") {
                    // Redirect within the modal to the payment URL
                    window.open(response.paymentUrl, 'linePayWindow');
                } else {
                    $("#result").html("Payment failed: " + response.message);
                }
            },
            error: function() {
                $("#result").html("Server error occurred.");
            }
        });
    });
});