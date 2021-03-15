function logout()
{
     let xhr = new XMLHttpRequest();
     xhr.open("POST", "http://localhost:8080/Reimbursement/logout");
     xhr.send();
     
     sessionStorage.removeItem('currentUser');
     window.location = "http://localhost:8080/Reimbursement/";
}