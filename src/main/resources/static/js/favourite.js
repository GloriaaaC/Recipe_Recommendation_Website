window.onload=initiatePage;

function initiatePage(){
    let temp = document.getElementById("folder_name");
    temp.innerText = localStorage.getItem("folderName");

    fetch("/users/favorites/recipes?folderId=" + (localStorage.getItem("currentFolder") ? localStorage.getItem("currentFolder") : "1"), {
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
            initiate_favourite(item["rid"], item["recipeName"], item["imageUrl"], item["recipeId"]);
        }
    }).catch(function(error) {
        console.log(error);
    });

}

function initiate_favourite(id, name, imageUrl, recipeid) {

    let recipeList = document.getElementById('recipe_list');
    let newFolder1 = document.createElement("div");
    let newFolder2= document.createElement("div");
    let newFolder3 = document.createElement("div");
    let imageDiv = document.createElement("div");
    newFolder1.classList.add("col-6", "col-md-4", "col-lg-3");
    newFolder2.classList.add("recipe-custom", "my-3", "border-white");
    imageDiv.classList.add("card-custom-img", "position-relative");
    imageDiv.style.backgroundImage = "url(" + imageUrl + ")";
    let imageButton = document.createElement("a");
    imageButton.classList.add("stretched-link");
    imageButton.href = "/recipe?id=" + recipeid;
    imageButton.setAttribute("recipeID", recipeid);
    imageDiv.appendChild(imageButton);
    newFolder3.classList.add("card-footer", "row", "justify-content-between");
    newFolder3.style.background = "inherit";
    newFolder3.style.borderColor = "inherit";
    let h = document.createElement("h5");
    let t = document.createTextNode(name);
    h.appendChild(t);
    h.classList.add("card-title");
    newFolder3.appendChild(h);
    let newFolder4 = document.createElement("div");
    newFolder4.classList.add("col-1", "col");
    let deleteButton = document.createElement("button");
    deleteButton.classList.add("close");
    let mySpan = document.createElement("span");
    //mySpan.setAttribute('aria-hidden', 'true');
    mySpan.innerHTML = "&times;";
    mySpan.onclick=delete_recipe;
    mySpan.setAttribute("recipeID", id);
    deleteButton.appendChild(mySpan);
    newFolder1.appendChild(newFolder2);
    newFolder2.appendChild(imageDiv);
    newFolder2.appendChild(newFolder3);
    newFolder3.appendChild(newFolder4);
    newFolder4.appendChild(deleteButton);
    recipeList.appendChild(newFolder1);
    newFolder1.setAttribute("id", "recipe_num_" + id)
}

function delete_recipe(e){
    console.log(e.target);
    let id = e.target.getAttribute("recipeID");
    let delete_element = document.getElementById("recipe_num_" + id);
    delete_element.parentNode.removeChild(delete_element);

    fetch("/users/favorites/recipes?folderId=" + (localStorage.getItem("currentFolder") ? localStorage.getItem("currentFolder") : "1") + "&recipeId=" + e.target.getAttribute("recipeId"), {
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

function folders(){
    window.location="/account";
}

function view_history(){
    window.location="/history";
}

function reset_password(){
    window.location="/password";
}

function signout(){
    window.location="/login";
}

function into_recipe(recipeid){
    window.location="/recipe?id=" + recipeid;
}