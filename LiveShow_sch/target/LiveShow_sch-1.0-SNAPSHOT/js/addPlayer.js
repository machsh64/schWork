function checkName() {
    var name = document.getElementById("name");
    if (name.value == "") {
        alert("请输入姓名");
        return false;
    }
    return true;
}

function checkScore() {
    var score = document.getElementById("score");
    var name = document.getElementById("name");
    if (name.value != "") {
        if (parseInt(score.value) < 0 || parseInt(score.value) > 100 || score.value == "") {
            alert("请输入0-100的分数");
            return false;
        }
        return true;
    }
}
