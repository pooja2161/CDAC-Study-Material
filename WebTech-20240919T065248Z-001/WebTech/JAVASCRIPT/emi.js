function myfunc(){
    console.log('testing');
    console.log(document);
    //select elements
    // console.log(document.getElementById('x1'));
    // console.log(document.getElementById('x1').value);

    var P = document.getElementById('x1').value;
    var R = document.getElementById('x2').value;
    var N = document.getElementById('x3').value;

    // console.log(P , typeof P);
    // console.log(R);
    // console.log(N);

    console.log(isNaN(P)); // is not a number -- true , false

    if ( P=='' || R=='' || N==''  ){
        // console.log(document.getElementById('x4'));
        // document.getElementById('x4').innerText = ' <i>values Required </i>';
        document.getElementById('x4').innerHTML = ' <i>values Required </i>';
        document.getElementById('x4').className = ' alert alert-danger ';
    }
    else if( isNaN(P) || isNaN(R) || isNaN(N) )
    {
        document.getElementById('x4').innerHTML = ' <i>values Must Be a Number </i>';
        document.getElementById('x4').className = ' alert alert-danger ';
    }
    else{
        // console.log(P + R); // concat

        // P = parseInt(P);
        // console.log(P , typeof P);

        // P = parseFloat(P);
        // console.log(P  , typeof P);

        // P = Number(P);
        // console.log(P , typeof P);

        P =   +P;
        // console.log(P  , typeof P);
        R =   +R;
        N =   +N;

        var ansEMI = homeLoanEmi(P, N,R);
        console.log(ansEMI);

        console.log(Math);

        document.getElementById('x4').innerHTML = ' <i>Success</i>';
        document.getElementById('x4').className = ' alert alert-success ';


        document.querySelector('.m1').innerHTML = 
        ` EMI : &#8377; ${Math.round(ansEMI)} `;

        document.querySelector('.m2').innerHTML = `
            Loan Amount : ${P}
        `;

        document.querySelector('.m3').innerHTML = `
            Total Payable Amount : ${ansEMI * N *12 }
        `;
        document.querySelector('.m4').innerHTML = `
            Total Interest Amount : ${ansEMI * N *12 - (P) }
        `;
    }
}


function homeLoanEmi(P,N,R) //parameters
{
    N = N*12;
    R = R/12/100;
    //P x R x (1+R)^N / [(1+R)^N-1]
    // 3**4 => 3*3*3*3
    var EMI = P * R * (1+R)**N / ((1+R)**N-1);
    // console.log(EMI);
    return EMI;
}