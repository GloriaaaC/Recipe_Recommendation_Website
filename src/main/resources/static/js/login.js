$(document).ready(function () {
    $("#inputButton").click(function () {
        login();
    });
});

/**
 * 登陆。
 * url：/user/loginCheck
 * 方式：post
 * 数据类型：json
 * 传参：username（String类型），password（String类型）
 * 返回：状态码，200是成功; 用户ID，用于记录当前用户
 * 使用local storage存储用户ID
 */
function login() {
    const uname = $("#username").val();
    const psw = $("#password").val();
    if (uname === "" || psw === ""){
        alert("Null values cannot be entered");
    } else {
        $.ajax({
            url:'/users/login',
            type:'post',
            dataType:'json',
            data:{"username":$("#username").val(),"password":$("#password").val()},
            success:function (data) {
                if (data.state === 200){
                    alert(data.state + " login success");
                    localStorage.setItem('userid',data.data.uid);
                    localStorage.setItem('userPassword',psw);
                    window.location.href = "/index";
                } else {
                    alert(data.state + " login failure");
                    window.location.href = "/login";
                }
            }
        })
    }
}