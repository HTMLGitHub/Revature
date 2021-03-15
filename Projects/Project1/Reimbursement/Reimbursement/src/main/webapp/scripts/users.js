//capture the welcome element and modify it so that it says 'Welcome, *username*
let welcome = document.getElementById('welcome');
   
//capture the userString by accessing the session...
let userString = sessionStorage.getItem('currentUser');

//set up some logic...
//IF the user is null...redirect them to the index.html page ("")
if(userString === null)
 {
     window.location = "http://localhost:8080/Reimbursement/";
 }
 else
 {
     //parse the data we set equal to that attribute
     let currentUser = JSON.parse(userString);

     console.log(currentUser);

     if(currentUser!=null)
     {
         welcome.innerHTML = "Welcome, " + currentUser.user.firstName + " " + currentUser.user.lastName;
     }
 }