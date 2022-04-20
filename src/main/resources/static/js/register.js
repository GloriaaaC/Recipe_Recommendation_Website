$(document).ready(function () {
    $(".inputButton").click(function () {
        $.register();
    });
});

/**
 * 注册。
 * url：/user/registerCheck
 * 方式：post
 * 数据类型：json
 * 传参：username（String类型），password（String类型）
 * 返回：状态码，200是成功
 */
$.register = function () {
    const uname = $("#username").val();
    const psw = $("#password").val();
    const conpsw = $("#confirmPassword").val();
    if (uname === "" ||  psw === "" || conpsw === ""){
        alert("Null values cannot be entered");
    } else if (psw !== conpsw){
        alert("confirm password is not equal password")
    } else {
        $.ajax({
            url:'/users/reg',
            type:'post',
            dataType:'json',
            data:{"username":$("#username").val(),"password":$("#password").val()},
            success:function (data) {
                if (data.state === 200){
                    alert(data.state + " register success");
                    window.location.href = "/login";
                } else {
                    alert(data.state + " register failure");
                    window.location.href = "/register";
                }
            }
        })
    }
};