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
    
    request.open("GET", "http://localhost:8080/Reimbursement/viewPendingRequests");
    request.send();
}

document.addEventListener("DOMContentLoaded", ()=>{loadInformation();});