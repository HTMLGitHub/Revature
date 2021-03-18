function populateTable(json)
{
    //creating table dynamically
    var arrHead = new Array();
    
    arrHead = ['ID', 'Date Submitted', 'Date Finished', 'Reason', 'Specified Reason', 'Amount', 'Submitted', 'Assigned', 'Pending'];//table headers

    //first create the table structure by adding a few headers
    var table = document.createElement('table');
    table.setAttribute('class', 'table table-striped table-bordered mydatatable');

    var dataHeader = document.createElement("thead");
    var tr = document.createElement("tr");//Table Row

    for(var h = 0; h < arrHead.length; h++)
    {
        var th = document.createElement('th'); //the header object
        th.innerHTML = arrHead[h];
        tr.appendChild(th);
    }
    dataHeader.appendChild(tr);
    table.appendChild(dataHeader);
    
    var dataBody = document.createElement("tbody");

    for(row in json)
    {
       tr = document.createElement("tr");

        let td = document.createElement("td");
        td.textContent = json[row].id;
        tr.appendChild(td); 
        
        td = document.createElement("td");
        td.textContent = json[row].submitted;
        tr.appendChild(td);

        td = document.createElement("td");
        td.textContent = json[row].finished;
        tr.appendChild(td);

        td = document.createElement("td");
        td.textContent = json[row].reason;
        tr.appendChild(td);

        td = document.createElement("td");
        td.textContent = json[row].otherReason;
        tr.appendChild(td);

        td = document.createElement("td");
        td.textContent = json[row].amount;
        tr.appendChild(td);

        td = document.createElement("td");
        td.textContent = json[row].submittedBy;
        tr.appendChild(td);

        td = document.createElement("td");
        td.textContent = json[row].finishedBy;
        tr.appendChild(td);

        td = document.createElement("td");
        td.textContent = json[row].pending;
        tr.appendChild(td); 

        if(json[row].pending==true)
        {
            td = document.createElement("td");
        
            let btnApprove = document.createElement("input");
            
            btnApprove.setAttribute("type", "button");
            btnApprove.setAttribute("value", "Approved");
            btnApprove.setAttribute("onclick", ApproveForm());
            
            let btnDeny = document.createElement("input");
            btnDeny.setAttribute("type", "button");
            btnDeny.setAttribute("value", "Denied");
            btnDeny.setAttribute("onclick", DenyForm());
            td.appendChild(btnApprove);
            td.appendChild(btnDeny);
            tr.appendChild(td);
        }
        dataBody.appendChild(tr);
    }    
        table.appendChild(dataBody);

        var dataFooter = document.createElement("tfoot");

        tr = document.createElement("tr");

        for(var h = 0; h < arrHead.length; h++)
        {
            var th = document.createElement('th'); //the header object
            th.innerHTML = arrHead[h];
            tr.appendChild(th);
        }
    
        dataFooter.appendChild(tr);
        table.appendChild(dataFooter);
        document.getElementById('myTable').append(table);
}

function ApproveForm(){}
function DenyForm(){}