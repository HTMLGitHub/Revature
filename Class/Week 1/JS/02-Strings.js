"use strict" 
//strict mode will not allow us to declare a variable in JavaScript Without a keyword
//it must be declared with 'var', 'const', 'let'
//strict mode allows more "secure" javascript

var a = 'Hello'; // by default this variable is declared with var
a = "Goodbye";
console.log(a);

const unchangeableWord = "Never"; //kind of like final keyword in Java


let templateLiteral = ``;
//template lieteral allow for String interpolation

templateLiteral = `This is a multi-line template literal... this is
one of the benefits of a template literal
`;

console.log(templateLiteral);

templateLiteral = `Five plus Five = ${5+5}`;
let age = 97;
//this is sting concatentation (doesn't provide us as much flexibility as string literal)
let mySentance = "Hello, I am " + age + " years old";

let food = 'Hamburger';
food = 'Salad';

templateLiteral = `I would like 1 ${food}`;
console.log(templateLiteral);