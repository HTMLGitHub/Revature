//1. create function called "ChangeTheText"
//      in which I take in some input, and change it to "Changed Text"

function changeTheText()
{
    var e = document.getElementById("my_paragraph");

    //change the elements text!
    e.textContent="Changed Text!";//another way is e.innerHTML
}
//2. we will grab the button element from the document, and then add an eventListener
//      so, when we click the button, we change the text (thus invoking our custom function)

var btn = document.querySelector("input");

//can also use
var myButton=document.getElementById("my_button");

btn.addEventListener("click", changeTheText); // we are passing a function as a parameter (this is a callback function)

console.log(document);