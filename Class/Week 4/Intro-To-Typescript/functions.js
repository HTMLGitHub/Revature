var myLog = function (message) {
    console.log(message);
};
//long fat-arrow notation
var myLog2 = function (message) { console.log(message); };
//short fat-arrow notation
var myLog3 = function (message) { return console.log(message); };

//this is transpiled in ES5...so no Errors
