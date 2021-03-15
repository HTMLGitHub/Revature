const dataBody = document.querySelector(".mydatatable > tbody");

function loadInformation()
{
    let storage = sessionStorage.getItem('currentUser');
    storage = JSON.parse(storage);     
    
    var Data;

    const request = new XMLHttpRequest();

    request.onload = function()
    {
        if(this.readyState==4&&this.status==200)
        {
            console.log("Loading Data");
            sessionStorage.setItem('userData', this.responseText);
            
            Data = JSON.parse(request.responseText);
        }
        if(this.readyState==4 &&this.status==204)
        {
            console.log("Failed to load data");
            let childDiv = document.getElementById('welcome');
            childDiv.textContent="Failed to load Data";
        }
        
        try
        {
            populateTable(Data);
        }
        catch(e)
        {
            console.warn("Could not load data");
            console.warn(e.message);
        }
    }; 
    
    request.open("GET", "http://localhost:8080/Reimbursement/findEmployeeRequest");
    request.send();
}

function populateTable(json)
{
    for(row in json)
    {
        let tr = document.createElement("tr");

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
        
            let btnApprove = document.createElement("button");
            
            btnApprove.setAttribute("value", "Approved");
            btnApprove.setAttribute("onclick", ApproveForm());
            
            let btnDeny = document.createElement("button");
            btnDeny.setAttribute("value", "Denied");
            btnDeny.setAttribute("onclick", DenyForm);
            td.appendChild(btnApprove);
            td.appendChild(btnDeny);
            tr.appendChild(td);
        }
        dataBody.appendChild(tr);
    }
    
    
}

function ApproveForm(){}
function DenyForm(){}

document.addEventListener("DOMContentLoaded", ()=>{loadInformation();});