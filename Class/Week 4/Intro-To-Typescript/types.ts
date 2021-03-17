var count = 5;

//We can not reassign variables to different types in Typescript!
//count = 'Apples' <== this will make the complier angry

//TypeScript i sstrictly typed

let a: number; //We are declaring the types that can be assigned to this variable
let b: boolean;
let c: string;
let d: any; //the datatype 'any' allows us to give this var ANY type
let f: any[] = [1, true, 'apple', false];
let g: number[]=[1,2,3,4];

const ColorRed = 0;
const ColorBlue = 1;
const ColorGreen = 2;

//an enum allows us to define named constants
//below, is an easier tway of doing the above
enum Color{Red, Blue, Green};

let backgroundColor = Color.Blue;
