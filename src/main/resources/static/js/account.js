// Get the modal
var modal = document.getElementById("myModal");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
function display_modal () {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
var folder_id = 5;
var delete_ready = false;

window.onload=initiatePage;

function initiatePage(){
    folder_id = 5;
    let list = document.getElementById("folder_list");

    while (list.childNodes.length > 2){
        list.removeChild(list.lastChild);
    }
    fetch("/users/favorites?userId=" + (localStorage.getItem("userid") ? localStorage.getItem("userid") : "1"), {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(function(response) {
            if (response.status != 200) {
                throw Error(response.statusText);
            }
            return response.json();
        }).then(function(response) {
            console.log(response);
        if (response.data == null) {
            return;
        }
        for (let i = 0; i < response.data.length; ++i) {
            let item = response.data[i];
            initiate_folder(item["id"], item["folderName"]);
        }
    }).catch(function(error) {
        console.log(error);
    });

}



function addFolder() {
    let folder_name = document.getElementById("folder_name").value;
    if (folder_name == "" || folder_name == null) {
        alert("Can not be empty name.");
        return;
    }
    let folderList = document.getElementById('folder_list');
    let newFolder1 = document.createElement("div");
    let newFolder2= document.createElement("div");
    let newFolder3 = document.createElement("div");
    newFolder1.classList.add("col-4", "col-md-3", "col-lg-2");
    newFolder2.classList.add("folder-custom", "my-3");
    newFolder1.appendChild(newFolder2);
    let bigImg = document.createElement("img");
    let deleteImg = document.createElement("img");
    bigImg.src="https://icons-for-free.com/iconfiles/png/512/bakery+svglinecolor+recipe+book-1319964872908984700.png";
    deleteImg.src="https://icon-library.com/images/x-mark-icon/x-mark-icon-5.jpg";
    bigImg.style.width="100%";
    bigImg.onclick = into_folder;
    deleteImg.classList.add("delete-img");
    deleteImg.setAttribute("id", folder_id);
    deleteImg.onclick=delete_onclick;
    newFolder3.classList.add("static-rating-stars");
    let h = document.createElement("h4")
    let t = document.createTextNode(folder_name);
    h.appendChild(t);
    h.classList.add("card-title");
    newFolder2.appendChild(bigImg);
    newFolder3.appendChild(h);
    newFolder2.appendChild(deleteImg);
    newFolder2.appendChild(newFolder3);
    folderList.appendChild(newFolder1);
    newFolder1.setAttribute("id", "folder_num_" + folder_id);
    modal.style.display = "none";
    fetch("/users/favorites?userId=" + (localStorage.getItem("userid") ? localStorage.getItem("userid") : "1") + "&folderName=" + folder_name, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(function(response) {
            if (response.status != 200) {
                throw Error(response.statusText);
            }
            return response.json();
        }).then(function(response) {
        bigImg.setAttribute("id", response.data);
        bigImg.setAttribute("name", folder_name);
        deleteImg.setAttribute("folderID", response.data);
    }).catch(function(error) {
        console.log(error);
    });
    folder_id+=1;
}


function into_folder(e){
    localStorage.setItem("currentFolder", e.target.getAttribute("id"));
    localStorage.setItem("folderName", e.target.getAttribute("name"));
    window.location= "/favourite";
}

function initiate_folder(id, name) {
    let folderList = document.getElementById('folder_list');
    let newFolder1 = document.createElement("div");
    let newFolder2= document.createElement("div");
    let newFolder3 = document.createElement("div");
    newFolder1.classList.add("col-4", "col-md-3", "col-lg-2");
    newFolder2.classList.add("folder-custom", "my-3");
    newFolder1.appendChild(newFolder2);
    let bigImg = document.createElement("img");
    let deleteImg = document.createElement("img");
    bigImg.src="https://icons-for-free.com/iconfiles/png/512/bakery+svglinecolor+recipe+book-1319964872908984700.png";
    deleteImg.src="https://icon-library.com/images/x-mark-icon/x-mark-icon-5.jpg";
    bigImg.style.width="100%";
    bigImg.setAttribute("id", id);
    bigImg.setAttribute("name", name);
    bigImg.onclick = into_folder;
    deleteImg.classList.add("delete-img");
    deleteImg.setAttribute("id", folder_id);
    deleteImg.onclick=delete_onclick;
    deleteImg.setAttribute("folderID", id);
    newFolder3.classList.add("static-rating-stars");
    let h = document.createElement("h4")
    let t = document.createTextNode(name);
    h.appendChild(t);
    h.classList.add("card-title");
    newFolder2.appendChild(bigImg);
    newFolder3.appendChild(h);
    newFolder2.appendChild(deleteImg);
    newFolder2.appendChild(newFolder3);
    folderList.appendChild(newFolder1);
    newFolder1.setAttribute("id", "folder_num_" + folder_id);
    modal.style.display = "none";
    folder_id+=1;
}


function delete_onclick(e){
    console.log(e.target);
    let id = e.target.getAttribute("id");
    let delete_element = document.getElementById("folder_num_" + id);
    delete_element.parentNode.removeChild(delete_element);
    // let delete_data = {"userID": localStorage.getItem("userID"), "folderID": e.target.getAttribute("folderID")};
    // let delete_data = {"userID": 5, "folderID": e.target.getAttribute("folderID")};
    fetch("/users/favorites?userId=" + (localStorage.getItem("userid") ? localStorage.getItem("userid") : "1") +  "&folderId=" + e.target.getAttribute("folderId"), {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(function(response) {
            if (response.status != 200) {
                throw Error(response.statusText);
            }
            return null;
        })
        .catch(function(error) {
            console.log(error);

        });
}

function manage_delete() {
    let list_child = document.getElementsByClassName('delete-img');
    let add_button = document.getElementById('add_folder_button');
    if (delete_ready){
        add_button.style.opacity = '1';
        add_button.onclick = display_modal;
    } else {
        add_button.style.opacity = '0.3';
        add_button.removeAttribute("onclick");
    }

    for (let i = 0; i < list_child.length; ++i) {
        let item = list_child[i];
        if (delete_ready){
            item.style.display = "none";
        } else {
            item.style.display = "block";
        }
    }
    delete_ready = !delete_ready;
}

function folders_onclick(){
    window.location="/account";
}

function history_onclick(){
    window.location="/history";
}

function password_onclick(){
    window.location="/password";
}

function sign_onclick(){
    window.location="/login";
}