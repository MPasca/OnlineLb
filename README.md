# OnlineLb
My SD projects consists in a website for an online library.
There are two types of users: readers and admins.

The readers can browse through the materials in the library, book them and open and view digital materials.
The admins can see the readers' history, what materials are borrowed, who borrowed them and also add, edit or delete materials from the database.

So far I've configured the database to the projects with the dependencies in maven, I installed PostMan, I created this repository, I created this readme and more are yet to come.

Update: 18.03.2022, 12.00 am
I configured the path from controller to DB and Javadoc

Still have to figure out postman

Update: 18.03.2022, 09:56 am
Figured out postman
Works beautifully for Readers, still have to correct Books


TO DO: new source for data - .txt si luat cu for intr-un repo nou

Update: 25.03.2022, 09:19 am
New source data
not working to create new obj with said data

Update: 01.04.2022, 07:59 am
New reader source data - hardcoded
Great success!

Update: 04.05.2022, 11:51 pm
Created the UserFactory, but I have yet to find out how to tie it to the rest of the code.
Created some unit tests to test the UserFactory.
Reorganized the code so that's easier to understand
Created Admin controller and Admin repo and Admin service
Rewrote BookController and BookService
First thing in the morning tomorrow, I'm testing them on postman.

Update: 05.05.2022, 04.02 pm
Added findById for readers, admins and books
A bit of retouching, solved some bugs
Wrote the javadoc for the new methods

Update: 05.05.2022, 10:49 pm
I created the UML & DB diagrams
Created Validators for data
Created MaterialFactory for books and videos - still have to work a bit on that
Cleaned the DB of useless tables
Cleaned the code
Today was a good day!