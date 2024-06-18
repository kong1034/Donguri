document.addEventListener('DOMContentLoaded', function() {
    var modal = document.getElementById("settings_modal");
    var btn = document.getElementById("settings_button");
    var span = document.getElementsByClassName("close")[0];
    var deviceSettings = document.getElementById("device_settings");
    var lightMode = document.getElementById("light_mode");
    var darkMode = document.getElementById("dark_mode");

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

    if (deviceSettings) {
        deviceSettings.onclick = function() {
            setTheme("device");
        }
    }

    if (lightMode) {
        lightMode.onclick = function() {
            setTheme("light");
        }
    }

    if (darkMode) {
        darkMode.onclick = function() {
            setTheme("dark");
        }
    }

    function setTheme(theme) {
        if (theme === "dark") {
            document.body.classList.add("dark_mode");
            var header = document.querySelector("header");
            var footer = document.querySelector("footer");
            if (header) {
                header.classList.add("dark_mode");
            }
            if (footer) {
                footer.classList.add("dark_mode");
            }
        } else {
            document.body.classList.remove("dark_mode");
            var header = document.querySelector("header");
            var footer = document.querySelector("footer");
            if (header) {
                header.classList.remove("dark_mode");
            }
            if (footer) {
                footer.classList.remove("dark_mode");
            }
        }
        // Save theme to local storage
        localStorage.setItem("theme", theme);
    }

    // Load theme from local storage
    var savedTheme = localStorage.getItem("theme");
    if (savedTheme) {
        setTheme(savedTheme);
        if (savedTheme === "dark" && darkMode) {
            darkMode.checked = true;
        } else if (savedTheme === "light" && lightMode) {
            lightMode.checked = true;
        } else if (deviceSettings) {
            deviceSettings.checked = true;
        }
    }
});