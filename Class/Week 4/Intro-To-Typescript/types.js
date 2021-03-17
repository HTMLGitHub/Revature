var count = 5;
//We can not reassign variables to different types in Typescript!
//count = 'Apples' <== this will make the complier angry
//TypeScript i sstrictly typed
var a; //We are declaring the types that can be assigned to this variable
var b;
var c;
var d; //the datatype 'any' allows us to give this var ANY type
var f = [1, true, 'apple', false];
var g = [1, 2, 3, 4];
var ColorRed = 0;
var ColorBlue = 1;
var ColorGreen = 2;
//an enum allows us to define named constants
//below, is an easier tway of doing the above
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Blue"] = 1] = "Blue";
    Color[Color["Green"] = 2] = "Green";
})(Color || (Color = {}));
;
var backgroundColor = Color;
