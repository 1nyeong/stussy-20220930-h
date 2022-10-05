const registerButton = document.querySelector(".account-button");

registerButton.onclick = () => {
    const accountInput = document.querySelectorAll(".account-input");

    let user = {
        lastName: accountInput[0].value,
        firstName: accountInput[1].value,
        email: accountInput[2].value,
        password: accountInput[3].value
    }

    //JSON.stringfly() -> js 객체를 JSON문자열로 변환
    //JSON.parse()     -> JSON문자열을 js 객체로 변환
    
    $.ajax({
        async: false,                           //필수
        type: "post",                           //필수
        url: "/api/account/register",           //필수
        contentType: "application/json",        //전송 데이터가 json인 경우
        data: JSON.stringify(user),             //전송할 데이터가 있으면
        dataType: "json",                       //json 외 text 등을 사용할 수 있지만 js
        success: (response) => {                //성공시에 실행될 메소드
            alert("회원가입 요청 성공");
            console.log(response);
        },
        error: (error) => {    //실패시 실행될 메소드
            alert("회원가입 요청 실패");
            console.log(error.responseJSON);
        }
    });
}