/** if user done e-mail vertificate**/
function chkCode() {
	let inputValue = document.querySelector('#input_num').value;
	let registerEmail = document.querySelector('.input_email');
	let modal = document.getElementById("myModal"); 
	
	let params = {
	        code: inputValue,
	    }
	fetch('RegEmailC', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
		},
		body: new URLSearchParams(params).toString()
	})
		.then(response => response.text())
		.then(data => {
			if (data) {
				console.log('Code matched');
				registerEmail = document.querySelector('#input_email').value; // u_email view
				let openModalInput = document.querySelector('#openModal');
			    openModalInput.disabled = true;
		        openModalInput.placeholder = registerEmail;  // placeholder val
			} else {
				console.log('Unmatched');
			} 
		}) 
		.catch(error => {
			console.error('Fetch ERROR: ', error);
		});
}
/** modal **/
// Get the modal
	var modal = document.getElementById("myModal");

	// Get the button that opens the modal
	var btn = document.getElementById("openModal");

	// Get the close button
	var closeBtn = document.getElementById("closeModal");

	// When the user clicks the button, open the modal 
	btn.onclick = function() {
		modal.showModal();
	}

	// When the user clicks on the close button, close the modal
	closeBtn.onclick = function() {
		modal.close();
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.close();
		}
	}
	

 // Email check event listener
	const emailChk = document.querySelector("#chk_btn");
	emailChk.addEventListener("click", async () => {
		const emailval = document.querySelector("#input_email").value;
		
		 try {
		        const response = await fetch("RegEmailC?email=" + encodeURIComponent(emailval), {
		            method: "GET"
		        });

		        const contentType = response.headers.get('content-type');
		        if (contentType && contentType.includes('application/json')) {
		            const data = await response.json();
		            console.log(data); // Log the JSON data received from the server
            // Handle the JSON response data here
		            if (data.message === "Email sent successfully!") {
		                // Add logic for successful email sent
		            } else {
		                console.error('서버에서 오류 메시지를 반환했습니다:', data.message);
		               // Add logic for handling error messages from the server
		            }
		        } else {
		            console.error('JSON 응답을 예상했지만, 받은 내용:', await response.text());
		            // Handle non-JSON response
		        }
		    } catch (error) {
		        console.error('Fetch 오류:', error);
		         // Handle fetch error
		    }
		});
