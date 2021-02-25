//1. create an array of objects (each object will have a name, color, cheese)
var arr =
[
    {
        firstName:  'Vision',
        color:      'purple',
        cheese:     'Blue'
    },
    {
        firstName:  'Wanda',
        color:      'red',
        cheese:     'Pepperjack'
    },
    {
        firstName:  'Agnes',
        color:      'green',
        cheese:     'Cheddar'
    }
];

//2. create a function to populate our table with each obj inside our arr

function populateTable(someArray)
{
    var myTable = document.getElementById("myTable");

    someArray.forEach((obj)=>
    {
        //1. for each object, create a new row (<tr>)
        let tr = document.createElement("tr");
        myTable.appendChild(tr);

        //2. for each object, enter some data (<td>)
        let td = document.createElement("td");
            //  -   firstName <td>
            tr.appendChild(td);
            td.innerHTML = obj.firstName;
            //  -   color <td>
            td = document.createElement("td");
            tr.appendChild(td);
            td.innerHTML = obj.color;
            td.style.backgroundColor=obj.color;
            //  -   cheese <td>
            td = document.createElement("td");
            tr.appendChild(td);
            td.innerHTML = obj.cheese;
    });
}

window.onload = populateTable(arr);