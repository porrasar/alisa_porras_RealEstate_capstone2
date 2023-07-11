// This is my external javascript file

//document.write ("Alisa im writing to document");

// ---------------------------VARIABLES-------------------------------------
// All of these variables used in the home page (home_page_general.html)
const time = new Date().getHours();
const greetingHello = "Hello, our office is open until 9 PM EST!"
const greetingClosed1 = "Sorry, our office is closed, we will open at 8 AM EST. " +
                        " Feel free to still access information through our website.";


// ---------------------------FUNCTIONS------------------------------------- 


function myDateFunction()                      //used in customer maintenance
{
  document.getElementById('demoDate').innerHTML = Date(); 
}


function myGeneralWriteFunction()              //used in Sign In
{
  document.write ("Alisa, I got it, button worked, I'm signed in!");
}


function myThemeSongFunction()                            //used in general home page
{
  document.getElementById('demoThemeSong').innerHTML = Date();
}

function themeSongFunction()                            //used in general home page
{
  document.getElementById('blessedVideo');
}


