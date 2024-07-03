$(function() {
    // get url
    const urlSearch = new URLSearchParams(location.search);
    const num = urlSearch.get('num');
    
    // get html element
    const all = $("#all");
    const child = $("#child");
    const older = $("#older");
    const animal = $("#animal");
    const env = $("#env");
    
    // number
    if (num == 0) {
        all.css("background-color","#F6A200");
        all.css("color","#fff");
    } else if (num == 1) {
        child.css("background-color","#F6A200");
        child.css("color","#fff");
    } else if (num == 2) {
        older.css("background-color","#F6A200");
        older.css("color","#fff");
    } else if (num == 3) {
        animal.css("background-color","#F6A200");
        animal.css("color","#fff");
    } else if (num == 4) {
        env.css("background-color","#F6A200");
        env.css("color","#fff");
    }
    
    // event
    all.click(function() {
        location.href="InfoAllC?num="+0;
    });
    child.click(function() {
        location.href="InfoAllC?num="+1;
    });
    older.click(function() {
        location.href="InfoAllC?num="+2;
    });
    animal.click(function() {
        location.href="InfoAllC?num="+3;
    });
    env.click(function() {
        location.href="InfoAllC?num="+4;
    });
});
