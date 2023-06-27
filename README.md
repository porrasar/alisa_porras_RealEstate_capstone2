## --------------------------------PURPOSE------------------------------------------
## BTB (Blessed To Bless) Properties, Inc. RealEstate application

BTB (Blessed To Bless) Properties, Inc. RealEstate is a web-based application 
intended to be used in house by a real estate investment business owner and 
customers (current tenants and potential tenants).

Currently, the owner keeps records of notes and customer transactions in a spreadsheet.
The customer does not have the ability to access their transactions (i.e. payments, repairs made, lease, etc.).

The application will be used for the:
- owners: 
    - to add, update, delete customer information
    - list properties available for rent and sale
    - 
- customer (current): 
    - to have the ability to access general information about the company
    - view a list of properties available for rent or sale
    - access our approved maintenance companies for repairs 
    - view their account information
    - update certain information in their account (i.e. phone number, etc.)        

- customer (potential): 
   - to have the ability to access general information about the company
   - view a list of properties available for rent or sale 


## ------------------------------------------------------------------------------------------
##    ////////////come back to this part//////////////  
The design of this app is very similar to a general shopping app having products, 
shopping carts, orders, and customer
information, so it can be modified to be used with any type of products.
##

##    /////////  come back to this part///////////////////

## --------------------------------USER STORIES------------------------------------------
### Admin

- As an admin, I want to log in with an admin privilege, so I can...
  - edit the list and information of houses (add, update, delete)
  - edit customer information (add, update, delete)
  - edit maintenance companies available (add, update, delete)
  - receive a payment from a customer (via phone)
  - search customer and get all needed info (payments, appointments, etc)

## ////////////come back to this part//////////////
- Tasks:
1. Create a database and a User table containing username, password and privilege.
2. Login screen asking for username and password.
3. Check if the username exists in the User table
4. Check if the password matches the entry in the table
5. Assign the privilege to the current user login session
6. If login is successful, show the main screen with options according to login privilege.
- Question: How to encrypt the password?

### User
Current Customer(tenant):
- to have the ability to access general information about the company
- access our approved maintenance company list
- set up appointments (talk to owners, repair an issue, inspections, etc)
- access, update and make payments to their account
- sign up and make an account


Potential Customer (someone visiting the web page or interested in our properties for some reason):
- to have the ability to access general information about the company
- make appointments (talk to owners, tour of houses, etc)
- make payments for application fees (make a payment as a guest, without having to sign in)


## --------------------------------  CONTENTS ---------------------------------------------

- [Case Study Rubrics](https://docs.google.com/document/d/1vX3oHn2rudg7hKWhudUCl5nQ-k447fwGf1XPg2YYBh0/edit)  -- Please contact [Supamas Sirichotiyakul](mailto:supamas.sirichotiyakul@gmail.com) to access this file
- [Presentation Slides](doc/Presentation.pdf)
- [Daily Progress](#daily-progress)
- [User Stories](#user-stories)
  - [Admin](#admin)
  - [User](#user)
- [Technical Architecture](doc/Cater%20Mate%20Technical%20Architecture.pdf)
- [Wire Frame](doc/Cater%20Mate-wireframe.pdf)
- [Schema Diagram](Sirichotiyakul_Supamas_Schema.pdf)
- [Jira](https://javacourse-2.atlassian.net/jira/software/projects/CM/boards/2) -- Please contact [Supamas Sirichotiyakul](mailto:supamas.sirichotiyakul@gmail.com) to access this Jira account
- [Technical Challenges](#technical-challenges)
- [Lessons Learned](#lessons-learned)
- [Future Improvements](#future-improvements)


## --------------------------------DAILY PROGRESS  ---------------------------------------------
- April 26th (100% done)
  - Added presentation
  - Added wire frame
  - Minor style edits
  - Added Logger to CartServiceImpl

- April 24th (97% done)
  - Removed KITCHEN from navbar.
  - Fixed test issues with isTrue().
  - Rearranged files into packages according to models.
  - Added JavaDoc to CartItemServiceImpl.getNewCartItemFromMenuItem() method.
  - Added tests for custom queries at repository level.
  

- April 23rd (96% done)
  - Added more lessons learned related to Thymeleaf.
  - Fixed a bug in order_submitted.html that didn't show the image.
  - Removed save cart in the controller method for "/order" so that a new cart is saved to the database only
    after an item has been added to the cart.
  

- April 22nd (95% done)
  - Added Description, Technical Architecture, Technical Challenges, Lessons Learned, Future Improvements
  - Cleaned up CSS
  - Added lambda expressions in the main CaterMateApplication class.
  

- April 21st (92% done)
  - Updated README.md to link to Schema.pdf.
  - Created schema for the project in Schema.png file.
  

- April 20th (92% done)
  - Added parameterized test for CartServiceImplTest
  - Added OrderServiceImplTest
  - Fixed bug where updating order is not saving orderItemList correctly
  - Added data.sql for populating the database by SQL statements, both in main and in test
  - Added application.properties in test/resources folder
  - Added test code MenuItemServiceImplTest
  - Removed cart reference from CartItem class
  - Fixed update user functionality bug


- April 19th (90% done)
  - Added Logger and log messages to controller classes.
  - Added JavaDoc folder and JavaDoc files.
  

- April 18th (87% done)
  - Added OrderRestController to provide web services.
  - Updated README.md file to have links and Contents section.
  - Created Schema.mwb file from SQL Server database.
  - Made Order -> OrderItem relationship uni-directional instead of bi-directional.
  

- April 16th (85% done)
  - styled the order search boxes so they align properly
  - rename things to match the requirements
  - changed permissions so anyone can view orders but only ADMIN and SUPERADMIN can edit or delete.


- April 15th (80% done)
  - Added ADMIN, SUPERADMIN roles and have permission set for "/users" as accessible by SUPERADMIN and "/menu" and
    "/viewOrders" are for ADMIN & SUPERADMIN
  - Addressed role assignment with:
    - any user with first name starting with "admin" will be assigned "ROLE_USER" and "ROLE_ADMIN" role
    - any user with first name starting with "superadmin" will be assigned "ROLE_USER", "ROLE_ADMIN", and "SUPERADMIN" role
  - added 3 error html pages - 403, 404, and 500 errors under "templates/error" folder.
  - added 3 custom queries for Order class and add search boxes in "View Orders" page (currently all 3 searches are "OR"
    together)
  - TODO: style 3 search boxes so they align


- April 14th (75% done)
  - created a MenuItemServiceImpl bean using @Bean annotation (to satisfy a Capstone requirement)
  - finished styling registration page
  - merged the old User class to Spring security login User class


- April 12th (70% done)
  - add Spring security login from class example - still need to style registration.html page
    and merge the old User class and related code to the example User class


## -------------------------NOT IMPLEMENTED IN THIS VERSION -----------------------
  ### Admin
   - As an admin, I want to store all repairs to a property (receipts, date, what was repaired) 


  ### User
   - As a user, be able to query all payment or appoints for a specified time 

## ------------------------- TECHNICAL CHALLENGES ---------------------------------
- Thymeleaf can only return a single object with the form submission 
  - An example was in the CartController @PostMapping("/addToCart/{menu_item_id}") - both the cart information and 
    the menu item are needed by the controller so it can add the menu item to the cart. 
  - The solution was to send the cart back as a model but send the menu item id with the path variable, then query 
    the database for the menu item in order to get name & price.
  

- The original design was to have the order and checkout pages combined in one page but things become too complicated in
  a single page with @PostMapping required both for adding an item to the cart (which is saved to the database in case
  the cart gets abandoned) and submitting customer information. 
  - The solution was to split them out into 2 pages which made the implementation much easier to understand.

## ------------------------- LESSONS LEARNED -------------------------------------
- Thymeleaf was new to me, and I assumed things work a certain way with the model attributes, but it was not
  correct. Because of that I spent a large amount of time debugging and experimenting on things, I should have tried
  to find a good resource to learn and really understand Thymeleaf more thoroughly first.


- Defining the project scope that is small enough to accomplish in the given time frame is critical.


- Making decisions early and getting implementation done early then having time to go back to improve things was
  a lot better than taking a long time to try to make a perfect decision and running short on time closer to the deadline.


- Project management and setting priorities and daily goals using a tool like Jira was very helpful.

## ------------------------- FUTURE IMPROVEMENTS ---------------------------------
- Add functionality for:
  - Owners:
 
  - customer (current):
    - make appointments (talk to owners, to repair an issue, inspections, etc.) 
    - make payments to their account 

  - customer (potential):
    - make appointments (talk to owners, tour of houses, etc)
    - make payments for application fees


