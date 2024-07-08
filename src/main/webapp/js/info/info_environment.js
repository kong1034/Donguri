function goSite(num) {
    if (num == 1) {
        window.open("https://www.greenpeace.org/international/", "_blank");
    } else if (num == 2) {
        window.open("https://www.conservation.org/", "_blank");
    } else if (num == 3) {
        window.open("https://www.nature.org/", "_blank");
    } else if (num == 4) {
        window.open("https://www.sierraclub.org/", "_blank");
    } else if (num == 5) {
        window.open("https://oceana.org/", "_blank");
    } else if (num == 6) {
        window.open("https://earthjustice.org/", "_blank");
    } else if (num == 7) {
        window.open("https://www.foei.org/", "_blank");
    } else {
        console.log("Invalid site number: " + num);
    }
}
