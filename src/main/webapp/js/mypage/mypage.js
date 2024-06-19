




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

  // Initialize the first tab to be displayed
  displayContent('all_content');