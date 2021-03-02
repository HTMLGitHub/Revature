//Object Oriented Programming in JavaScript

/*
*   OOP Concepts taht we will cover
        1.Defining a class
        2.Instantiating a class
        3.Inheriting from a class
 */

 //first we have to consider that EVERYTHING is treated as an object
 //I mean: strings, functions, numbers....when we covered closures, we saw that we can encapsulate data/states/properties/fields within a function 
 //(so the function itself is kind of like a class)
 
 function Computer(compName, ramSizeGb, cpuCores, cpuSpeedInGhz)
 {
    this.compName = compName;
    this.ramSizeGb = ramSizeGb;
    this.cpuCores = cpuCores;
    this.cpuSpeedInGhz = cpuSpeedInGhz;

    this.printSpecs=function()
    {
        console.log(`This computer's name is: ${compName}. It has ${ramSizeGb} GB RAM, and 
        a ${cpuCores} -core ${cpuSpeedInGhz} GHz processor.`);
    }

    //notice there is no return statement!!!
 };

var myComputer = new Computer("My PC", 4, 4, 4.2);
myComputer.printSpecs();

/*Things to note:
    1. The function 'Computer' is a constructor funtion that doubles 
        as a class definintion (practically speaking)
    2. The 'new' keyword creates a NEW, empty object, and then fills our the properties
    according to the 'Computer' function. The 'new' keyword is what calls the Constructor 
    in context to that particular object that is created, and sets those properties that we defined.


*/
//This is not typical
function ComputerReWrite(compName, ramSizeGb, cpuCores, cpuSpeedInGhz)
 {
    var obj={};

    obj.compName = compName;
    obj.ramSizeGb = ramSizeGb;
    obj.cpuCores = cpuCores;
    obj.cpuSpeedInGhz = cpuSpeedInGhz;

    obj.printSpecs=function()
    {
        console.log(`obj computer's name is: ${compName}. It has ${ramSizeGb} GB RAM, and 
        a ${cpuCores} -core ${cpuSpeedInGhz} GHz processor.`);
    }

    return obj;
 };
 //and use the rewrite like so:
 var myComputerRewrite = ComputerReWrite("MyBetterPC", 8,8,10);
 myComputerRewrite.printSpecs();

 console.log(myComputer);

 //putting a function IN a constructor is NOT a good idea, because we can't actually see it when we print the object

 //This is what the prototype property is for...

 //We use prototype whenever we want every instance of an object
 //to have the same functionality. We attach the function to the prototype

 function ComputerProto(compName, ramSizeGb, cpuCores, cpuSpeedInGhz)
 {
    //this is a proper constructor
    this.compName = compName;
    this.ramSizeGb = ramSizeGb;
    this.cpuCores = cpuCores;
    this.cpuSpeedInGhz = cpuSpeedInGhz;

    //notice no functions! we're doing good....
 }

 //every 'ComputerProto' object MUST have a 'printSpecs' function
 ComputerProto.prototype.printSpecs = function()
 {
    console.log(`obj computer's name is: ${this.compName}. It has ${this.ramSizeGb} GB RAM, and a ${this.cpuCores} -core ${this.cpuSpeedInGhz} GHz processor.`);   
 }
console.log("=========================================");
 var myComputerProto = new ComputerProto("My PC", 4, 4, 4.2);
 myComputerProto.printSpecs();

 //Now that we have an object with a configured prototype
 //we can even inherit from it. In order to inherit, we use the call(),
 //call() allows us to define "this" in the context of the function.

 //let's define a laptop child class

 function Laptop(compName, ramSizeGb, cpuCores, cpuSpeedInGhz, weight)
 {
    //think of this as a super() keyword
    ComputerProto.call(this, compName, ramSizeGb, cpuCores, cpuSpeedInGhz);
    
    this.weight = weight;
 }
console.log("============================================");
 var myLaptop = new Laptop("My Laptop", 1000, 16, 500, 5);
 //myLaptop.printSpecs(); //this wont work!

 /*
    We were able to inherit the properties, we defined for ComputerProto, but not the funcitons.
    That's because we defined teh functions on the PROTOTYPE of ComputerProto

    In order to inherit functions properties, we need to do 2 things:
        1.set the prototype of the child = to taht of the paretnt by useing Object.create();

        2.We have to set our constructor to equal that of our child, rather than our parent.
 */

 //this is call "parasitic combination inheritance"
 var computerCopy = Object.create(ComputerProto.prototype); //copy ComputerProto's protoType into a new obj
 computerCopy.constructor = Laptop;                         //set this prototype's constructor = to Laptop's
 Laptop.prototype = computerCopy;                           //set Laptop's prototype == to computerCopy (has constructor + functionality from prototype)


console.log("============================================");
var myLaptop2 = new Laptop("My Laptop", 1000, 16, 500, 5, .5);
myLaptop2.printSpecs();

//we need to overwriting the printSpecs() for laptop()...
Laptop.prototype.printSpecs = function()
{
    console.log(`obj computer's name is: ${this.compName}. It has ${this.ramSizeGb} GB RAM, and a ${this.cpuCores} -core ${this.cpuSpeedInGhz} GHz processor. Weight: ${this.weight} lbs`);    
};

myLaptop2.printSpecs();