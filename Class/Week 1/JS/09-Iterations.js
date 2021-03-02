"use strict"

let a = "ten";
let b = 10;
let c = true; //boolean
let d = {}; //object
let e = null;
let f = ""; //falsey string
let g = (0/0); //falsey number
let h = []; //empty array = object
let i = function(){};//function is also an object and a datatype

var list = [a,b,c,d,e,f,g,h,i];

//standard for loop
for(let j = 0; j < list.length; j++)
{
    console.log(list[j]);
}

//enhanced for loop
for(let element in list)
{
    //enhances 'for loop' in JS iterates through the indices (indexes) rather then values
    console.log(list[element]);
}

//For each function (takes in a callback funtion which is what we perform on each element within the array)
list.forEach(element => {
    console.log(element);
});

list.forEach(
    
    function(value)
    {
        console.log(value)
        console.log('--------------------------------');
    }
);

console.log('-------------------------------');

//For each with => (fat arrow (not ->) notation)
list.forEach
(item => 
    {
        console.log(item);
        console.log('-----------------------------------')
    }
);