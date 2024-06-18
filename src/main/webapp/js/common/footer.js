document.addEventListener('DOMContentLoaded', function() {
  var modal = document.getElementById("settings_modal");
  var btn = document.getElementById("settings_button");
  var span = document.getElementsByClassName("close")[0];
  var deviceSettings = document.getElementById("device_settings");
  var lightMode = document.getElementById("light_mode");
  var darkMode = document.getElementById("dark_mode");

  btn.onclick = function() {
    modal.style.display = "block";
  }

  span.onclick = function() {
    modal.style.display = "none";
  }

  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }

  deviceSettings.onclick = function() {
    setTheme("device");
  }

  lightMode.onclick = function() {
    setTheme("light");
  }

  darkMode.onclick = function() {
    setTheme("dark");
  }
});

function setTheme(theme) {
  if (theme === "dark") {
    document.body.classList.add("dark-mode");
    document.querySelector("header").classList.add("dark-mode");
    document.querySelector("footer").classList.add("dark-mode");
  } else {
    document.body.classList.remove("dark-mode");
    document.querySelector("header").classList.remove("dark-mode");
    document.querySelector("footer").classList.remove("dark-mode");
  }
  // Save theme to local storage
  localStorage.setItem("theme", theme);
}

// Load theme from local storage
document.addEventListener("DOMContentLoaded", function() {
  var savedTheme = localStorage.getItem("theme");
  if (savedTheme) {
    setTheme(savedTheme);
    if (savedTheme === "dark") {
      document.getElementById("dark_mode").checked = true;
    } else if (savedTheme === "light") {
      document.getElementById("light_mode").checked = true;
    } else {
      document.getElementById("device_settings").checked = true;
    }
  }
});