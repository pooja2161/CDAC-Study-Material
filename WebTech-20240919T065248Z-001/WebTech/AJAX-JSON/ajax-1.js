//onclick event handler in javascript
document.querySelector('button').onclick = function(){
    // console.log('onclick event handler working');

    //check xmlhttprequest object is exist or not -  to peform ajax
    var xmlhttp = new XMLHttpRequest();  //xhr
    // console.log(typeof xmlhttp);
    console.log(xmlhttp);
    
    //its a life cycle of ajax
    // 0 No Request initialized by End User (Client)

    // status==> 404 , 200 (HTTP STATUS CODE)
    console.log(xmlhttp.readyState , xmlhttp.status);

    //onreadystatechange event will detects the readystate values
    xmlhttp.onreadystatechange = function(){
        // console.log(xmlhttp.readyState , xmlhttp.status);
        if(xmlhttp.readyState==4 && xmlhttp.status==200){
            //responseText it will hold data which is received from server side lang or api
            // console.log(xmlhttp.responseText);
            var answer = JSON.parse(xmlhttp.responseText);
            // console.log(answer);

            // remove dummy content from the given div tag
            document.querySelector('.all-countries').innerHTML = '';


            var allDiv = ``;
           
            answer.forEach((values)=>{
                // console.log(values);
                // console.log(values.flags.png);
                // console.log(values.name.common);
                //  x=x+10;
                //  x+=10;
                allDiv += `
                    <div class='col-lg-3 col-6'>
                        <img src='${values.flags.png}' class='img-fluid' />
                        <h2>${values.name.common}</h2>
                    </div>
                `; 
            });

            console.log(allDiv);
            document.querySelector('.all-countries').innerHTML = allDiv;
        }
    }

    //this open(method name , api path) method will help us to connect a server side web page
    xmlhttp.open("GET","https://restcountries.com/v3.1/all",true);
    // readyState 1 - request has been setup successfully

    xmlhttp.send();
    // readyState 2 - request has been sent successfully to server
    // readyState 3 - request its in process
    // readyState 4 - request cycle completed successfully

}