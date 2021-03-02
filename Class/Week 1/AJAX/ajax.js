/**
 * JSON = JavaScript Object Notation
 *  JSON is a starndart data interchange format. It sends human-readable text
 *  to store and transmit data objects.
 *  These objects have properties made of key-value pairs
 */

 let button = document.getElementById("btn");
 
 //add an event Listener to our button ("click", ajaxCall)
button.addEventListener("click", ajaxCall);

//capture the <p>
let input = document.getElementById("input");

 //define a function for WHAT our ajax call actually does
 function ajaxCall()
 {
    let number = document.getElementById("field").value;
    //get this number and append it to the url

    //STEP 1: 
    let xhr = new XMLHttpRequest();

    //this object is used for asynchronous requests to a server


    /*
        What is the ready state property of the XMLHttpRequest

        it is a property that signals the state that the request is in
    */
    //STEP 2:
    xhr.onreadystatechange = function()
    {
        if(this.readyState==4 && this.status == 200)    //ready state: 4 = ; status: 200 = 
        {
            let data = JSON.parse(xhr.responseText);

            console.log(data);

            //we'll make a function called renderHTML
            renderHTML(data);
        }
    }

    //STEP 3:
    //Open the request
    xhr.open('GET', `https://pokeapi.co/api/v2/pokemon/${number}`);
    //this is the request to the server: it includes the method and the url

    //STEP 4:
    //send the request to the server
    xhr.send();
 }

 //this function will render teh data of the pokemon recieved
 function renderHTML(data)
 {
    input.append("Name: " + data.name );
    input.append(document.createElement("br"));
    input.append("Id: " + data.id);
    input.append(document.createElement("br"));
    let image = document.createElement("img");
    image.setAttribute("src", data.sprites.front_default);
    image.setAttribute("alt", `${data.name} front_default`);
    
    //set the height attribiture to 300
    image.setAttribute("height", "300");
    
    //set the width attribute to 300

    image.style.width = "300px";
    image.style.backgroundColor = "black";
    
    //stick it to the page
    input.append(image);
    input.append(document.createElement("hr"));
 }