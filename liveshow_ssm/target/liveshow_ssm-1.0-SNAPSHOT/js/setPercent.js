function checkPercent() {
    var percent = document.getElementById("percent");
    if (parseInt(percent.value)<0||parseInt(percent.value)>100||percent.value=="") {
        alert("请输入0-100的晋级百分比");
        return false;
    }
    return true;
}