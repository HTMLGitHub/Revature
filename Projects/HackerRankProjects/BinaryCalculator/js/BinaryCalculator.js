let result = document.getElementById("res");
var number1;
var number2;
var total;
var operation;

function adding0Function()
{
    result.innerHTML += "0";
}

function adding1Function()
{
    result.innerHTML += "1";
}

function additionFunction()
{
    firstNumber();
    operation = "+";
    result.innerHTML += "+";
}

function subtractionFunction()
{
    firstNumber();
    operation = "-";
    result.innerHTML += "-";
}

function multiplicationFunction()
{
    firstNumber();
    operation = "*";
    result.innerHTML += "*";
}

function divionFunction()
{
    firstNumber();
    operation = "/";
    result.innerHTML+="/"
}

function clearFunction()
{
    result.innerHTML = "";
}

function firstNumber()
{
    number1 = result.innerHTML;
    
}

function binaryToDigit(num)
{
    return parseInt(num,2);
}

function secondNumber(num)
{
    var locator = num.indexOf(operation);
    number2 = num.substring(locator + 1);
    result.innerHTML = number2;
}

function equalFunction()
{
    secondNumber(result);
}
