document.addEventListener('DOMContentLoaded', function() {
    const footer = document.getElementById('footer_container');

    // Change footer border color on scroll
    window.addEventListener('scroll', function() {
        if (window.scrollY + window.innerHeight >= document.body.offsetHeight) {
            footer.style.borderColor = '#4CAF50'; /* Change to green */
        } else {
            footer.style.borderColor = '#ddd'; /* Default color */
        }
    });

    // Add hover effect
    footer.addEventListener('mouseenter', function() {
        footer.style.borderColor = '#4CAF50';
    });

    footer.addEventListener('mouseleave', function() {
        footer.style.borderColor = '#ddd';
    });
});