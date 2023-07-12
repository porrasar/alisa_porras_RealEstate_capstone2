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
  document.getElementById('demoThemeSong').innerHTML = firstNickName + " " + lastNickName + " " + message;
}

function themeSongFunction()                            //used in general home page
{
  document.getElementById('blessedVideo');
}

function dateDisplayFunction()                            //used in general home page
{
document.getElementById('dateDisplay').innerHTML = Date();
}

// ----------------------------- Carousel ----------------------------
/*
let slideIndex = 1;
showSlides(slideIndex);
*/


// --- MAKES IT AUTOMATIC
let slideIndex = 0;
showSlides();
// --- end - MAKES IT AUTOMATIC



// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

// --- MAKES IT AUTOMATIC
function showSlides() {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}
  slides[slideIndex-1].style.display = "block";
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}
// --- end - MAKES IT AUTOMATIC



/*
function showSlides(n) {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
}
*/
// ----------------------------- Carousel End-----------------------------

