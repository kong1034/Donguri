$(function() {
    showSlides();

    //headrt hover
    $("#heart_icon").mouseenter(function() {
        $("#heart_color").css("visibility", "visible");
        $("#heart_color").addClass("icon_color");
    })
    $("#heart_icon").mouseleave(function() {
        $("#heart_color").css("visibility", "hidden");
        $("#heart_color").removeClass("icon_color");
    })
    //dog hover
    $("#dog_icon").mouseenter(function() {
        $("#dog_color").css("visibility", "visible");
        $("#dog_color").addClass("icon_color");
    })
    $("#dog_icon").mouseleave(function() {
        $("#dog_color").css("visibility", "hidden");
        $("#dog_color").removeClass("icon_color");
    })
    //tree hover
    $("#tree_icon").mouseenter(function() {
        $("#tree_color").css("visibility", "visible");
        $("#tree_color").addClass("icon_color");
    })
    $("#tree_icon").mouseleave(function() {
        $("#tree_color").css("visibility", "hidden");
        $("#tree_color").removeClass("icon_color");
    })
    //elder hover
    $("#elder_icon").mouseenter(function() {
        $("#elder_color").css("visibility", "visible");
        $("#elder_color").addClass("icon_color");
    })
    $("#elder_icon").mouseleave(function() {
        $("#elder_color").css("visibility", "hidden");
        $("#elder_color").removeClass("icon_color");
    })
})

function showSlides() {
    let slideIndex = 0;
    const slides = document.getElementsByClassName("mySlides");

    function displayNextSlide() {
        for (let i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slideIndex = (slideIndex + 1) % slides.length;
        slides[slideIndex].style.display = "block";
        setTimeout(displayNextSlide, 3000); // Change image every 3 seconds
    }

    displayNextSlide();}
