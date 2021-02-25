//4 main ways we can declare functions in javascript

//1. Function Declaration
function divide(a,b)
{
    return a/b;
}
//2. Function Expression
const divide2 = function(a,b)
{
    return a/b;
}
//3. Arrow function Expression
const divide3 = (a,b) =>
{
    return a/b;
}
//4. Arrow funciton Expression - concise
const divide4 = (a,b) => a/b;

var value = divide4(10,5);
console.log(value);
//Callback function: is a function that we difine to be called by another function

function startup()
{
    console.log("We started the thing");
}

//window.onload = startup();// <== this is a callback function

//window.onload = () => {console.log("We started the thing");} // <== same as the 'startup' function

//objects constants ***
//the KEY of an object's property is a string value
//KEYS are Strings
var objLiteral = 
{
    firstName: 'Bob',
    lastName: 'Smith'
};

var secondObj =
{
    "firstName": "Bob",
    "lastName": "Smith"
};
//There are several ways to access the same value
console.log(objLiteral["firstName"]); //output of this statement should be 'Bob'
console.log(objLiteral);