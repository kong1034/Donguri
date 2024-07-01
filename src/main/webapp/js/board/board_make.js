
function previewImage(event) {
    var reader = new FileReader();
    reader.onload = function(){
        var preview = document.getElementById('preview');
        preview.src = reader.result;
        preview.style.display = 'block'; // 미리보기 이미지 표시
    };
    reader.readAsDataURL(event.target.files[0]);
}



// start_date와 end_date 비교
document.querySelector('input[name="start_date"]').addEventListener('input', function() {
    var startDate = new Date(this.value);
    var endDate = new Date(document.querySelector('input[name="end_date"]').value);

    if (endDate <= startDate) {
        alert("募集期間の終了日は開始日より後に設定してください。");
    }
});

document.querySelector('input[name="end_date"]').addEventListener('input', function() {
    var endDate = new Date(this.value);
    var startDate = new Date(document.querySelector('input[name="start_date"]').value);
    var meetDate = new Date(document.querySelector('input[name="meet_date"]').value);

    if (endDate <= startDate) {
        alert("募集期間の終了日は開始日より後に設定してください。");
    } else if (meetDate <= endDate) {
        alert("募集日の日付は募集終了日より後に設定してください。");
    }
});

document.querySelector('input[name="meet_date"]').addEventListener('input', function() {
    var meetDate = new Date(this.value);
    var endDate = new Date(document.querySelector('input[name="end_date"]').value);

    if (meetDate <= endDate) {
        alert("募集日の日付は募集終了日より後に設定してください。");
    }
});