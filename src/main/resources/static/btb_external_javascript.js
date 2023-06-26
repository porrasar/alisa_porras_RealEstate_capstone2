// This is my external javascript file

//document.write ("Alisa im writing to document");

// ---------------------------VARIABLES------------------------------------- 

var firstNickName = "Boo";
let lastNickName = "Whoperler :)";
var message = "...Glad we go by Blessed To Bless instead!'";
const time = new Date().getHours();
let greeting;

// ---------------------------FUNCTIONS------------------------------------- 


function myDateFunction()                      //used in maintenance 
{
  document.getElementById('demoDate').innerHTML = Date(); 
}


function myGeneralWriteFunction()              //used in Sign In
{
  document.write ("Alisa, I got it, button worked, I'm signed in!");
}


function myNickNameFunction()                            //used in about 
{
  document.getElementById('demoNickName').innerHTML = firstNickName + " " + lastNickName + " " + message; 
}


