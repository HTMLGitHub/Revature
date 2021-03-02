let button = document.getElementById("btn");
button.addEventListener("click", getQuote);

let input = document.getElementById("quote");

function getQuote()
{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function()
    {
        if(this.readyState == 4 && this.status == 200)
        {
            let data = JSON.parse(xhr.responseText);
            
            console.log(data);

            renderHTML(data);
        }
    }

    xhr.open('GET', 'https://quotes.rest/qod?category=inspire');

    xhr.send();
}

function renderHTML(data)
{
    var title = data.contents.quotes[0].title;
    document.getElementById("header").innerHTML=title;

    input.append(`Quote: ${data.contents.quotes[0].quote}`);
    input.append(document.createElement("br"));
    input.append(document.createElement("hr"));
    input.append(`Author: ${data.contents.quotes[0].author}`);

    let image = document.getElementById("photo");
    image.setAttribute("src", data.contents.quotes[0].background);
    image.setAttribute("alt", data.contents.quotes[0].background);
}