

function filterByTag(tag) {
	const xhr = new XMLHttpRequest();
	xhr.open('GET', 'BoardTagC?tag=' + encodeURIComponent(tag), true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			console.log(xhr.responseText);
			const response = JSON.parse(xhr.responseText);
			console.log(response);

			const boardContainer = document.getElementById('boardContainer');
			const boardHeader = `
                    <div class="board_list" style="font-weight: bold; font-size:17pt;">
                        <div class="board status">状態</div>
                        <div class="board location">場所</div>
                        <div class="board group">分類</div>
                        <div class="board title">タイトル</div>
                        <div class="board writer">作成者</div>
                        <div class="board date">作成日</div>
                    </div>`;

			let boardItems = '';

			response.forEach(b => {
				boardItems += `
                        <div class="board_list">
                            <div class="board status">
                                <div class="status_welcome">`+ b.status + `</div>
                            </div>
                            <div class="board location">`+ b.place + `</div>
                            <div class="board group"><span>#`+ b.tag + `</span></div>
                            <div class="board title"><a href="BoardDetailC?no=`+ b.no + `"><span>` + b.title + `</span></a></div>
                            <div class="board writer">`+ b.id + `</div>
                            <div class="board date" style="font-size: 14pt;">`+ b.date + `</div>
                        </div>`;
			});
			boardContainer.innerHTML = boardHeader + boardItems;
		}
	};
	xhr.send();
}

function goToPage(pageNumber) {
	document.getElementById("paginationForm").querySelector("input[name='p']").value = pageNumber;
	document.getElementById("paginationForm").submit();

}
