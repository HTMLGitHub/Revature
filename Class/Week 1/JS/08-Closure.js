/*
What is closure?
JS' attempt at encapsulation:
    It allows for 2 things:
        1. allows for an inner function to access and enclosing funcitons's variables
        2. allows for an inner function to preserve an enclosing function's scope chain when executing the function.
*/

var x = function cake()
{
    //some variables declared here
    var flour = true;
    var cornMill = false;
    var cupsOfSugar = 1;

    function bake()
    {
        var heat = 350;
        console.log(`Baking the cake at: ${heat}`);
        console.log(`Flour Used: ${flour}`);
        console.log(`Corn Mill used: ${cornMill}`);
        console.log(`Cups of Sugar Needed: ${cupsOfSugar}`);
        
        heat++;
        flour = !flour; // flips the boolean
        cornMill = !cornMill;
        cupsOfSugar++;

        console.log();
    }
    
   return bake;   // '()' = calling the function, without the '()' is essentually just the function expression
}

x = x();

for(let i = 0; i<5; i++)
{
    x();
}

//** // this will invoke  cake -- by invoking cake, we are really calling bake();
//techniaally we are executing the inner function