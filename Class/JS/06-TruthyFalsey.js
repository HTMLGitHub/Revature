/*
    Javascript has a special way of coercing all different values into booleans

    We would say that a value coerced into true = truthy and a value coerced intto false = falsey

    There are only a coulpe falsey values, and everything else is truthy.

    the falsey values are:
        -0
        -null
        -empty string
        -false
        -NaN
        -undefinded

    !! (double bang operator) returns a variables truthy value. "!!" = is it truthy?
*/

console.log(!!00);

function checkTruthy(input)
{
    console.log
    (
        `input is ${input} and is of type ${typeof(input)}
It has a truthy value of ${!!input}`
    ); // the !!input will return true or false
}

checkTruthy(0);
checkTruthy(null);
checkTruthy("");
checkTruthy(false);
checkTruthy(NaN);
checkTruthy(undefined);

console.log("TRUETHY VALUES:");

checkTruthy("GME");
checkTruthy(15);
var y = 0;
checkTruthy(y);
checkTruthy({}); // an empty object is still a valid object, its like []. It is NOT null, nor Undefined

var userName = "";
checkTruthy(userName);