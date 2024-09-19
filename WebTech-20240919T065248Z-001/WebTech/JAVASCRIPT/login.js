// DOM Event Handler
// console.log(document.querySelector("button"));

document.querySelector('button').onclick= function(){
    // alert('working'); // message box or alert box  
    var email = document.getElementById('x1').value;
    var pass = document.querySelector('#x2').value;
    // console.log(email);
    // console.log(pass);

    /*
        om@gmail.com
        om@gmail.co.in
        (username)@(domain).(ext1)(.ext2)?

        . meaning in regular expression
        \. normal , character
        a\-z
    */
    var regex_email = /^([a-zA-Z0-9]([a-zA-Z0-9\._]{1,})?[a-zA-Z0-9])@([a-zA-Z0-9]([a-zA-Z0-9\-]{1,})?[a-zA-Z0-9])\.([a-zA-Z]{2,})(\.[a-zA-Z]{2,})?$/

    if( !regex_email.test(email))
    {
        document.getElementById('x4').innerHTML = 'invalid email';
        document.getElementById('x4').className = 'alert alert-danger';

        // . each
        // ()()()().  each group
        // ?= current char onward
        // Hello@#@#123
        // ?=. current char onward lets check each character
        // ?=.* current char onward lets check each character any where in the string zero or more time   
    }
    else{
        // /^()()()().{4,8}$/
        var reg_pass = /^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#\-]).{4,8}$/

        if( !reg_pass.test(pass))
        {
            document.getElementById('x4').innerHTML = 'invalid Password';
            document.getElementById('x4').className = 'alert alert-danger';
        }
        else{
            document.getElementById('x4').innerHTML = 'Success';
            document.getElementById('x4').className = 'alert alert-success';
        }
    }
}
