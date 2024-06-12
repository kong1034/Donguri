document.addEventListener('DOMContentLoaded', function() {
    var settingsButton = document.getElementById('settings_button');
    var modal = document.getElementById('settings_modal');
    var closeModal = document.getElementsByClassName('close')[0];

    settingsButton.onclick = function() {
        modal.style.display = 'block';
    }

    closeModal.onclick = function() {
        modal.style.display = 'none';
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = 'none';
        }
    }
});