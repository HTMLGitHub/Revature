/**
 * JavaScript has 2 equality operator which are == vs. ===
 * 
 * Both compare the object on either side
 * 
 * - == preforms something called "Type Coersion" ... in other words - "10" == 10 is true
 * 
 * - === is alot stricter. "10" === 10 is false, because "10" is a string, and 10 is a number;
 */
function compare(first, second)
{
    console.log(
        `first = ${first}, and is of type ${typeof(first)}
second = ${second}, and is of type ${typeof(second)}
first == second evaluates to ${first==second}
first === second evaluates to ${first===second}`)
}

compare(15, "15");
compare("10", "ten");
compare([], null);
compare({},{}); //In javascript 2 different object instances are NEVER equal to each other

var z =
{
    a:1,
    b:1
};
var u = 
{
    d:1,
    e:1
};
compare(z.a, u.d);

var product = 4 * 'hi'; // we can not do this because 'hi' is a string, not a number
console.log(product);

console.log(parseInt("blablabla"));

if(isNaN(product))
{
    console.log("Can not multiply a string");
}
else
{
    console.log(product);
}

var s = 5 / 'hi'; //NAN is a property of the global object
compare(s, NaN);
