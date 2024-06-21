
document.addEventListener("DOMContentLoaded", function() {
    const bars = document.querySelectorAll('.mypage_middle .middle.bar');

    bars.forEach(bar => {
        bar.addEventListener('click', function() {
            // Remove 'active' class from all bars
            bars.forEach(b => b.classList.remove('active'));

            // Add 'active' class to the clicked bar
            this.classList.add('active');
        });
    });
});

  document.getElementById('all_history').addEventListener('click', function() {
   displayContent('all_content');
   
  });

  document.getElementById('donation_history').addEventListener('click', function() {
    displayContent('donation_content');
  });

  document.getElementById('participation_history').addEventListener('click', function() {
    displayContent('participation_content');
  });

  document.getElementById('current_meetings').addEventListener('click', function() {
    displayContent('meetings_content');
  });

  function displayContent(contentId) {
    var contents = document.getElementsByClassName('content-section');
    for (var i = 0; i < contents.length; i++) {
      contents[i].style.display = 'none';
    }
    document.getElementById(contentId).style.display = 'block';
  }

  displayContent('all_content');
  
  
  
  
  
  