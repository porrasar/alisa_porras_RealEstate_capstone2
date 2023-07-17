## --------------------------------PURPOSE------------------------------------------
## BTB (Blessed To Bless) Properties, Inc. RealEstate application

BTB (Blessed To Bless) Properties, Inc. RealEstate is a web-based application 
intended to be used in house by a real estate investment business owner and 
customers (tenants).

We have been in business for 22 years, working as a team, each playing our part - doing all of our own rehabbing. 
- Charles: With the lead of my dad who has owned his own construction company for 40+ years,
  built his own house, employed over 75% of the men in our family, and poured a lot of sidewalks, driveways,
  and restaurant and store floors, all over Ohio and surrounding states - he brings the knowledge of the construction
  industry 
- Margie: My mom is the 'cleaner-upper' of our company, which is very important, especially when
  dealing in rehabbing houses. By the time she gets finish cleaning, refurbishing and fixing up items, rooms, 
  floors, walls, bathrooms, stoves, refrigerators, etc., things look brand new! 
- Alisa: So, I have learned a lot from both of my parents, and I help in both area, along with handling 
  the administrative side, finances and the interactions with the tenants.

This is a business which we hope will help my parents and I retire peacefully...but one of our main missions is
to be a blessing to others and use what God have blessed us with to bring glory to Him.  
We work with people that may have a hard time otherwise renting; we provide nice, clean, update residents; we only 
purchase houses, in order to provide the tenant with a place to grow and become stable with their family; and 
we provide superb customer service (no slum-lording here) and most important we pray for and with our tenants.
We appreciate our tenants. Our turn-over rate is very low, the average tenant has been with us for 10+ yrs.  


All that to say, this application will help us (mainly me), since I do the admin side, to keep track of the tenant's
information and payments and allow them to access their information. 

Currently, 
- the owner keeps records of notes and customer transactions in a spreadsheet
- the customer does not have the ability to access their transactions (i.e. payments, repairs made,
  lease, documents, etc).
- payments: there are 3 ways tenants pay...electronic transfer from their bank to ours, 
  direct deposit in our account through drive-thru or inside the bank, and mail in payment

For the customer, this is more of an informational application.
For the admin side, this will allow CRUD (Create, Read, Update, Delete) operations on business information.

The application will be used for the:
- owners: 
    - to add, update, delete customer information
    - list properties available for rent and sale
    - list the approved maintenance providers they can access for repairs 
 
- customer: 
    - view their account information
    - to have the ability to access general information about the company
    - view a list of properties available for rent or sale
    - access our approved maintenance companies for repairs 
 

## --------------------------------USER STORIES------------------------------------------
### Admin
- As an admin, I want to log in with an admin privilege, so I can...
  - edit the list and information of houses (add, update, delete)
  - edit customer information (add, update, delete)
  - add payments to a customer
  - edit maintenance companies available (add, update, delete)
 
### User
Customer(tenant):
  - sign up and make an account (with a username provided by the owner)
  - view their account information
  - to have the ability to access general information about the company
  - view a list of properties available for rent or sale
  - access our approved maintenance companies for repairs

## --------------------------------  CONTENTS ---------------------------------------------

- Overview document (in my zip file with project)

## --------------------------------DAILY PROGRESS  ---------------------------------------------
- Sun. July 16, (100%)
  - update ReadMe file
  - added phone and email field to customer table
  - attempted validation on fields, not very successful
  - added bottom nav bar on certain pages that scrolled vertically
  - add new jpg files that are less than 100 MB 
  - reformatted errors pages to make them a little prettier 
  - refactoring HTML pages
  - added theme music using javascript
 
- Sat. July 15 (90%)
  - worked on formatting navbar on html pages
  - added carousel/slide show 
  - refactoring HTML pages
  - added 'notes' field to payment table
  - added headings to fields 
 
- Fri., July 14 (85% done)
  - fixed sign-up issue (u_id not found), needed to clean out and create new database
  - fixed issue of payments being removed when performing an update on customer 
  - worked on all naming conventions

- Thurs., July 13 (82% done)
  - worked on formatting navbar on html pages
  - worked on all naming conventions
  - added comments 
  - worked on fixing GIT issues 

- Wed., July 12 (80% done)
  - worked on navbar for all html pages
  - worked on javascript
 
- Tues., July 11 (77% done)
  - added nav bars on html pages 
  - worked on some javascript 

- Mon., July 10 (75% done) 
  - added unit testing for each query in customer repository
  - added a parameterized test for maintenance serviceImpl  
    
- Sun., July 9 (70% done)
  - added unit test in each ServiceImpl class, autowired in the Service class 
  - attempted parameterized test, no success
  - added 3 custom finder queries to RestCustomerController! Originally, I was
      trying to add it to the MVC Customer Controller, but I could not figure 
      the HTML Thymeleaf 'form' tag format. Finally, realized it was easier to add
      it to the Rest Controller, if only I would've known this 48 hours ago! :) 

- Sat., July 8 (67% done)
  - try custom queries again ...uuughhh accomplished nothing can't figure this out!

- Fri., July 7 (67% done)
- used Spring data binding (@Null, @Size, @Digits)

- Thrus.July 6 (65% done)
  - working on exception handling
  - updating README.md file
  - create a logging file (error.log)
  - added @Transactional annotation to customerService class
  - making sure to have two ways to create beans (@Bean in application and 
    @ComponentScanning (through using @SpringBootApplication)  

- Wed., July 5 (60% done)
  - added 4th model (maintenance) and all classes, html, tables, etc. that goes with it
  - worked on separating the customer and admin permissions page flow

- Tues., July 4 (52% done)
  - webpages: cleaned up format of home page, customer, and adin page 
  - attempted to add custom queries to customer repository, no success 

- Fri., July 30 (50% done)
  - add Spring security login. I originally wanted to have the home page to display first,
    then provide the option to sign in or browse website as a guess. At this point, we
    have not learned how to do that, it was also time-consuming to learn, so I decided
    to have sign-in or sign-up display first, then allow access per username and password.
   

## ------------------------- TECHNICAL CHALLENGES ---------------------------------

- Knowing enough to accomplish what I had in my mind. I knew what I wanted to do, I could see it in my mind, 
  but just could not figure out how to write the logic to accomplish that goal. 
- Security: being able to allow a guest to access home page and then when they click on something the flow works correctly
- How to validate fields 
- Thymeleaf: when to use it vs. just regular html
- MySQL: if add or delete a field in a table, you have to re-build the table, you will continue to get the error 
  'cannot find the field'...and the name of the field is not the name in your entity, it's the name MySQL created   
- Carousel: how to get it to start automatically
- GIT
- Command line
- How to add audio 

## ------------------------- LESSONS LEARNED -------------------------------------
- One small issue, can take hours and sometimes days to figure out...and it's been sitting right in you face the whole
  time. So, it's good to have someone else take a look at your logic with fresh eyes 
- Model: that is like a middleman between the controller and html files  
- CSS: if you use a CSS file, makes it easy to maintain and change several page formats from one file  
- Javascript: if you use a JS file, makes it easy to maintain and change activity on several pages from one file  
- Spring Boot: the ease of creating a SQL table
- Time management: Never have as much time as you think, so start early
- Learning to scale back on my hugh dreamy goals, and focus on the requirements...then come back and do enhancements
- Learning from my classmates and realizing that a lot of other people may be going through the same issues, 
  don't be afraid to ask questions   
- MP4 files: intellij will not let you have a file bigger than 100 MB 


## ------------------------- FUTURE IMPROVEMENTS ---------------------------------
- Add functionality for:
  - Owners:
    - add customer documents to their account    
    - search customer from html page and get all needed info (payments, appointments, etc)
    - Update and Delete operations on payment table
 
  - customer :
    - make appointments (talk to owners, to repair an issue, inspections, etc.) 
    - make payments to their account 
    - ability to change certain fields in customer record 

 
  - General
    - add error messages in varies places (i.e. login)  
    - allow guest into home page
    - add message for success sign-in
    - how to play soft music in background
    - add links to the maintenance companies
    - add sql and schema files to keep permanent data!





