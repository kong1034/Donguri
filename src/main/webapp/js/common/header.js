document.addEventListener('DOMContentLoaded', function() {
    const header = document.getElementById('header_container');

    // Check login status
    const loginStatus = '<%=request.getAttribute("loginStatus")%>';
    const authLink = document.getElementById('auth_link');
    const mypageLink = document.getElementById('mypage_link');

    if (loginStatus === 'loggedIn') {
        authLink.textContent = 'Logout';
        authLink.href = '${pageContext.request.contextPath}/LogoutC';
        authLink.style.display = 'block';
        mypageLink.style.display = 'block';
    } else {
        authLink.textContent = 'Login';
        authLink.href = '${pageContext.request.contextPath}/LoginC';
        authLink.style.display = 'block';
        mypageLink.style.display = 'none';
    }
});