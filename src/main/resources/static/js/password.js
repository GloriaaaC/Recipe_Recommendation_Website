function change_password() {
    let oldPass = document.getElementById('inputPasswordOld');
    let newPass = document.getElementById('inputPasswordNew');
    let pass = document.getElementById('inputPasswordNewVerify');
    oldPass = oldPass.value;
    newPass = newPass.value;
    pass = pass.value;

    let currentPass = localStorage.getItem("userPassword");
    if (oldPass.length == 0 || newPass.length == 0 || pass.length == 0) {
        alert('Please fill all the details');
        return;
    } else if (oldPass == newPass) {
        alert("Old password and New Password cannot be same");
        return;
    } else if (newPass != pass) {
        alert("password mismatch");
        return;
    } else if (currentPass != oldPass){
        alert("Old password incorrect, Please check your current password");
        return;
    }
    fetch("/users/changePassword?userId=" + (localStorage.getItem("userid") ? localStorage.getItem("userid") : "1") + "&newPassword=" + newPass, {
        method: 'REQUEST',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(function(response) {
            if (response.status != 200) {
                throw Error(response.statusText);
            }
            localStorage.setItem("userPassword", pass);
            alert("Change Password Successfully!");
            document.getElementById('inputPasswordOld').value = "";
            document.getElementById('inputPasswordNew').value = "";
            document.getElementById('inputPasswordNewVerify').value = "";
            return null;
        })
        .catch(function(error) {
            console.log(error);
            alert("Change Password Failed!");

        });
}

function folders_on(){
    window.location="/account";
}

function history_on(){
    window.location="/history";
}

function password_on(){
    window.location="/password";
}

function sign_on(){
    window.location="/login";
}