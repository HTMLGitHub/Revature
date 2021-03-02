let personLiteral =
{
    firstName: "Wilson",
    hairColor: "Hot Pink",
    favoriteFood: "BBQ"
};

/*
JS allows use to create object literals which is nothing more than an object with favFood-value pairs surrounded in curly brackets. 
*/

console.log(personLiteral); //JSON -javascript object notation
console.log(personLiteral.favoriteFood);
console.log(personLiteral["favoriteFood"]); //returns same as above, just accessing the value of hte favFood as a string.
let favFood = "favoriteFood";
let hc = "hairColor";
console.log(personLiteral[favFood]);
//bracket notation is useful when we mioght not remember the name of the favFood when we access the code.

//JS allows us to add properties to an obj literal
personLiteral.age = 35;

//==================================//There is another way to create a 'person' object=============================================
function PersonOldWay(firstName, hairColor, favFood)
{
    this.firstName = firstName;
    this.hairColor = hairColor;
    this.favFood = favFood;

    //this is not best practice to define common functionality for an obj
    this.SayHello = function()
    {
        console.log(`Hello, my name ${firstName}`);
    }
}

//Eventually in ES6 (2015) Classes were added
class Person
{
    constructor(firstName, hairColor, favFood)
    {
        this.firstName = firstName;
        this.hairColor = hairColor;
        this.favFood = favFood;  
    }

    //this is a method
    sayHello()
    {
        console.log(`Hello, my name ${this.firstName}`);
    }
}

//a method is a function that is specific to an object (both are sets of instructions to complete a task)
var harry = new Person("Harry", "Brown", "Green Beans");
console.log("--------------------------------------------")
console.log(harry);
harry.sayHello();

