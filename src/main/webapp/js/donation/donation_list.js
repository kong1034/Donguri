function reviewMovePage(no) {
    location.href = "DonationMovePageC?p=" + no;
}

function movePage() {
    location.href = "DonationAdminC";
}

function call(num) {
    console.log("check => " + num);
    location.href = "DonationDetailC?no=" + num;
}

function moveUpdatePage(no) {
    location.href = "DonationUpAdminC?no=" + no;
}
