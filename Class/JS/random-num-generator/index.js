window.onload = function()
{
    console.log("Starting up.....");

    //cache the DOM elements BEFORE we start manipulating them
    let $min=document.getElementById("min");
    let $minOut = document.getElementById("min-output");
    let $max=document.getElementById("max");
    let $maxOut = document.getElementById("max-output");
    let $generate = document.getElementById("generate");

    //2. add event listeners to each elevent
    $min.addEventListener('input', (evt)=>
    {
        $minOut.textContent = evt.target.value;
    });
    $max.addEventListener('input', (evt)=>
    {
        $maxOut.textContent = evt.target.value;
    });
    $generate.addEventListener('click', (evt)=>
    {
        console.log("Clicked.....");
        let min = Number($min.value); //This ensures that my value is indeed a number so I can perform some arithmetic
        let max = Number($max.value);
        
        //insert some control flow to make sure that min is < max before we calculate a random number
        if(min>max)
        {
            $max.value = Number($min.value) + 1;
            $minOut.textContent = Number($min.value);
            $maxOut.textContent = Number($max.value); 
        }

        let output = randomNumber(min, max);
        console.log("Generated number is " + output);
        //getElementsByClassName returns a list of elements
        //Must specify the index
        document.getElementsByClassName('output')[0].innerHTML = output;
    });
}



function randomNumber(min, max)
{
    return Math.round(Math.random()*(max-min) + min);
}