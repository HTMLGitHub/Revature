/**
 * Fetch API
 *  What is it? modern interface that allows you to make HTTP requests to servers to browers
 * It is simplier and cleaner then the xhr (XmlHTTPRequest Object)
 */

window.onload=function()
{
    console.log("fetch.js is loaded");

    document.getElementById('btn').addEventListener("click", getPokemon);

    
}
var pokemon;

function getPokemon()
{
    let number = document.getElementById('field').value;

    //the fetch() method requies 1 parameter: the url from which we are retieving data


    //the fetch() method returns a promise
    //a promise is an object that produces a single value at some time in the future.

    //the beauty of promises is that it allows us to process them an do cool things like use the then()
    //or handle errors
    fetch(`https://pokeapi.co/api/v2/pokemon/${number}`)

    

    .then((response)=>response.json())

    .then((data)=>
    {
        console.log(data);

        setPokemonImage(data.sprites.front_default);

        //we're just demostrating that we can now use this global var anywhere in our program
        
        pokemon = data;

    }, (err) =>
    {
        console.log(`Error: ${err}`);
    } 
    );
}

function setPokemonImage(imgsource)
{
    document.getElementById('pokemonImg').src = imgsource;
}