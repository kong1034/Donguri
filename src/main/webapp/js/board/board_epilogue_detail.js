	
	
	function replySave(userId, boardId){
		
	var data = {
		userId : userId,
		boardId : boardId,
		content : $("#content").val()
	}
		
		$.ajax({
			url: "BoardEpilogueDetailC",
			type: "post",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"
			
		}).done(function(result){
			console.log(result)
		});
		
	}
    
    $("#add_btn").click(function() {
		var content = $("#content").val();
		if (content == "") {
			$("#add_message").html("내용을 입력하세요");
			$("#content").focus();
			return;
		}
	})
    
    
    
    