document.addEventListener('DOMContentLoaded', function() {
    var modal = document.getElementById("settings_modal");
    var btn = document.getElementById("settings_button");
    var span = document.getElementsByClassName("close")[0];

    if (btn) {
        btn.onclick = function() {
            if (modal) {
                modal.style.display = "block";
            }
        }
    }

    if (span) {
        span.onclick = function() {
            if (modal) {
                modal.style.display = "none";
            }
        }
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            if (modal) {
                modal.style.display = "none";
            }
        }
    }
});