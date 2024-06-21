document.addEventListener('DOMContentLoaded', function() {
    var header = document.getElementById('header_container');

    // Change header border color on scroll
    window.addEventListener('scroll', function() {
        if (window.scrollY > 50) {
            header.style.borderColor = '#4CAF50'; /* Change to green */
        } else {
            header.style.borderColor = '#ddd'; /* Default color */
        }
    });

    // Check login status
    var loginStatus = '<%=request.getAttribute("loginStatus")%>';

    if (loginStatus === 'loggedIn') {
        document.getElementById('unlogin').style.display = 'none';
    } else {
        document.getElementById('logout').style.display = 'none';
    }
});