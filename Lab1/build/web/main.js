/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


document.querySelector("body").onload = function () {
    document.querySelector("form").action = "";
}

//document.querySelector("#id").onchange = function () {
//    var existedId = document.querySelector("#existedId").value;
//    if (existedId != "") {
//        alert(existedId + " has already existed!");
//    }
//}

document.querySelector('input[type=submit]').onclick = function () {
    var id = document.querySelector('#id').value;
    var name = document.querySelector('#name').value;
    if (id == "" || name == "") {
        alert("The value must not be empty!");
    } else {
        document.querySelector("form").action = "List";
    }
}


