// 이름 유효성 검사
function checkName() {
    var name = document.getElementById('inputName').value;

    if(name == "") {
        document.getElementById('nameError').innerHTML = "이름을 입력해주세요."
        return false;
    } else {
        document.getElementById('nameError').innerHTML = ""
        return true;
    } // if-else

} // checkName


// 비밀번호 유효성 검사
function checkPassword() {
    var password = document.getElementById('inputPassword').value;
    var passwordConfirm = document.getElementById('inputPasswordConfirm').value;

    if(password != passwordConfirm) {
        document.getElementById('passwordError2').innerHTML = "비밀번호가 일치하지 않습니다.";
        return false;
    } else if(password == "" || passwordConfirm == "") {
        document.getElementById('passwordError1').innerHTML = "비밀번호를 입력해주세요.";
        return false;
    } else {
        document.getElementById('passwordError1').innerHTML = "";
        document.getElementById('passwordError2').innerHTML = "";
        return true;
    } // if-else if-else

} // checkPassword






// 초기화
function resetForm() {
    document.myForm.reset();
} // resetForm