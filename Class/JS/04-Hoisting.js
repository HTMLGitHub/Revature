//A hoisted variable means that it is treated as if it were declared at the top of the global scope

console.log(myVariable); //Output: undefined
var myVariable = "Look I'm defined";
/*if we run the program from here, it won't throw an error



--the above is equivelent to:*/

var myVariable; //here we declare it
console.log(myVariable);
myVariable = "Look I'm defined!";

//What about functions?
var myFunc = function()
{
    console.log("Func variable is: " + funcVariable);
    console.log("If variable is: " + ifVariable);

    var funcVariable = "In function!";

    if(true)
    {
        var ifVariable = "If block!";
    }
};

myFunc();


//Hoisting is a JS mechanism in which variables (and function declaarations) are moved to the top of their scope before code execution.