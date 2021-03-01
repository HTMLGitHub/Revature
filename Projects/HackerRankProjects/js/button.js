var button = document.getElementById("btn");
button.addEventListener("click", Update);

var addOne = (function()
{
    var counter = 0;
    return function(){counter++; return counter;}
})();

function Update()
{
    button.innerHTML = addOne();
}
