/*
    2 Main scopes in JS
    1. Global Scope -- variables declared here are accessible from ANYWHERE
        - varibles delcared outside of the function scope with VAR will be declared on a global scope

    2. Functional Scope -- varibles declared within a funciton's block {}

    3. Lexical/Block scoping -- introduces in 2015 by ES6
*/

function funScope()
{
    var x = 'Hello'; //here 'x' is declared on a FUNCTIONAL scope
    
    if(true)
    {
        var y = "Goodbye";
    }

    console.log(y);
}


var scope = "I am global";

function whatIsMyScope()
{
    var scope = "I am local (or functionional)";
    function func()
    {
        console.log(scope);
    }
    return func();
}

whatIsMyScope();

//block scope (or lexical scope) was introduced in 2015 with Ecma Script 6 aka ES6 along with const and let
function blockScope()
{
    let c = "cat";
    if(true)
    {
        let d = "dog"; //we can not access 'd' "dog" because it is confined to the lexical/block
        console.log(d);
    }

    console.log(c);
}

blockScope();