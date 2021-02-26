/*
    JavaScript is by default synchronous.

    This means that it executes our code line by line, block by block, in order.
    EXCEPT when var or funcitons are hoisted
*/

console.log('1');
console.log('2');
console.log('3');

/**
 * Asynchronous means that something will wait for a timer to finish 
 * or REQUEST to RESPOND  while the rest of code continues to execute
 */

console.log('1');

//this takes in a callback function
setTimeout(function afterTwoSeconds()
{
    console.log('2');
}, 2000);

console.log('3');

/**
 * our application isn't hanging around waiting for our function to finish!
 * instead it keeps executing the rest of the code until the time out is finished
 */