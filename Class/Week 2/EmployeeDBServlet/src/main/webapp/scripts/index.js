function sendLogin()
{
    console.log("sendLogin() fired");
    //save some variables here
    let uName = document.getElementById("uName").value; 
    let pWord = document.getElementById("pWord").value;

    //builiding an obj literal with the user credentials
    let loginTemplate = 
    {
        username: uName,
        password: pWord
    };

    //begin some AJAX workflow...

    //1. get the XMLHttpRequest Object i.e. let xhr = ...
    let xhr = new XMLHttpRequest();
    
    //2. xhr.onreadystatechange
    xhr.onreadystatechange = function()
    {
        if(this.readyState == 4 && this.status == 200)
        {
            console.log("success");
            sessionStorage.setItem('currentUser', this.responseText);

            let xhrGet = new XMLHttpRequest();
            xhrGet.open("Get", "http://localhost:8080/EmployeeDBServlet/login");
            xhrGet.onreadystatechange = function()
            {
                if(this.readyState===4 && this.status===200)
                {
                    console.log("Getting");
                    sessionStorage.setItem('currentState', this.responseText);

                    console.log(sessionStorage.getItem('currentState'));
                }
            }
            //window.location = "http://localhost:8080/EmployeeDBServlet/home.html";

            console.log(sessionStorage.getItem('currentUser'));
        }

        if(this.readyState == 4 && this.status == 204) // 204 means NO CONTENT FOUND (but connection was made)
        {
            console.log("Failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login! Username and/or Password is incorrect";
        }
    };

    //3. xhr.open("POST", "http:/localhost")
    xhr.open("POST", "http://localhost:8080/EmployeeDBServlet/login");

    //4. xhr.send();
    xhr.send(JSON.stringify(loginTemplate));
}