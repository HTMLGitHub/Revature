var choice = document.getElementById('sel1');
choice.value = selectedIndex;
if(choice.value == 'Other')
{
    Other.style.visiblity="visible";
}

function ClearFrom()
{
	document.getElementById('other').visibility="hidden";
    document.getElementById('other').value="";
    document.getElementById('amount').value="";
    document.getElementById('sel1').selectedIndex=1;
}

function submitRequest()
{
    //save some variables here
    let reason = document.getElementById('sel1').selectedIndex.value; 
    let otherReason = document.getElementById('Other').value;
    let amount = document.getElementById('amount').value;

    //builiding an obj literal with the user credentials
    if(otherReason!="")
    {
        let ReimbursementRequest = 
        {
            ReimbursementReason: reason,
            ReimbursementOtherReason: otherReason,
            ReimbursementAmount: amount      
        };  
    }
    else
    {
        let ReimbursementRequest =
        {
            ReimbursementReason: reason,
            ReimbursementAmount: amount 
        };
    }
    
    //begin some AJAX workflow...

    //1. get the XMLHttpRequest Object i.e. let xhr = ...
    let xhr = new XMLHttpRequest();
    
    //2. xhr.onreadystatechange
    xhr.onreadystatechange = function()
    {
        if(this.readyState == 4 && this.status == 200)
        {
            console.log("success");
            sessionStorage.setItem('reimbursementrequest', this.responseText);
            
            console.log(sessionStorage.getItem('reimbursementrequest'));
            console.log("Request Submitted");
            console.log("Redirecting you back to homepage");
            window.location = "http://localhost:8080/Reimbursement/Employee.html";
        }

        if(this.readyState == 4 && this.status == 204) // 204 means NO CONTENT FOUND (but connection was made)
        {
            console.log("Failed to submit request");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to submit request";
        }
    };

    //3. xhr.open("POST", "http:/localhost")
    xhr.open("POST", "http://localhost:8080/Reimbursement/submitRequest", true);

    //4. xhr.send();
    xhr.send(JSON.stringify(ReimbursementRequest));
 }