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
					 if (resData.success) {
					 console.log(resData);
                     location.href="HC";
                    }else{
					 console.log("ログイン失敗: " + resData.message);
					 alert(resData.message);
                     location.href = "LoginC";
					}
				},
				error: function (xhr, status, error) {
		              console.log("ERROR");
		              console.log("xhr : " + xhr);
		              console.log("status : " + status);
		              console.log("error : " + error);
		              location.href = "LoginC";
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