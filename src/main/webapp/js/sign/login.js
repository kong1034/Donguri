/* Donguri Login ajax*/
	$(function(){
		var loading = $('#load_image').hide();
		
		$('.login_don').click(function(){
			$.ajax({
					url: 'LoginC',
					type: 'POST',
					data: {
						id: $('#input_id').val(),
						pw: $('#input_pw').val()
					},
			beforeSend: function() {
       				loading.show();
      				},
      		complete: function() {
       				 loading.hide();
     				 },
				success: function (resData){
					console.log(resData);
					console.log(JSON.stringify(resData));
					location.href="HC";
				},
				error: function (xhr, status, error) {
		              console.log("서버에러 발생!");
		              console.log("xhr : " + xhr);
		              console.log("status : " + status);
		              console.log("error : " + error);
		            },
			});
		});
/* Login Enter Key press */
		$("#login_container").keypress(function (e){
			if (e.keyCode === 13) {
				$('.login_don').click();
			}
		});
		
	});