function doSomething() {
    for (var i = 0; i < 5; i++) {
        console.log(i);
    }
    console.log("Finally i is: " + i); //according to lexical/block scopes, I can not print 'i'
    //The TypeScript compiler is telling us so
}
doSomething();