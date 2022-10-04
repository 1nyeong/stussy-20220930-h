const registerButton = document.querySelector(".account-button");

registerButton.onclick = () => {
    const accountInput = document.querySelectorAll(".account-input");

    let user = {
        lastName: accountInput[0].value,
        firstName: accountInput[1].value,
        email: accountInput[2].value,
        password: accountInput[3].value
    }
    
    let ajaxOption = {
        async: false,                   //필수
        type: "post",                   //필수
        url: "/api/account/register",   //필수
        data: user,                     //전송할 데이터가 있으면
        datatype: "json",               //json 외 text 등을 사용할 수 있지만 js
        success: (response) => {         //성공시에 실행될 메소드
            alert("회원가입 요청 성공");
        },
        error: (error) => {             //실패시 실행될 메소드
            alert("회원가입 요청 실패");
        }
    }

    $.ajax(ajaxOption);
}