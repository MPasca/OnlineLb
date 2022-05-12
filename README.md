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

Usage:
using the /readers path, the user can access the set of instructions set for readers:
    /post           (create a new instance of a Reader in the table),
    /get            (fetch the list of readers from the table),
    /get/{id}       (fetch a reader by its id),
    /put/{id}       (update certain data of a reader sent by id)
    /delete/{id}    (delete a reader by its id)
using the /admins path, the user can access the set of instructions set for admins:
    /post           (create a new instance of a Admin in the table),
    /get            (fetch the list of admins from the table),
    /get/{id}       (fetch an admin by its id),
    /put/{id}       (update certain data of an admin sent by id)
    /delete/{id}    (delete an admin by its id)
using the /books path, the user can access the set of instructions set for books:
    /post           (create a new instance of a Book in the table),
    /get            (fetch the list of books from the table),
    /get/{id}       (fetch a book by its id),
    /put/{id}       (update certain data of a book sent by id)
    /delete/{id}    (delete a book by its id)

All three have the same flow in a nutshell, so I will explain for Reader.
Create:
    For the Create in CRUD, it starts from ReaderController, where a Reader object is created 
        with the information that was sent as input, and then sends it to the Reader Service.
    In Reader Service the methods defined in the interface (IReaderService) are implemented
        for working with the DB. Here in the saveReader method, it sends the Reader object
        and sends it to the Reader Repo.
    Reader Repo is an interface that extends CrudRepository, and it's used to connect the program
        to the Readers table. It comes with a set of methods, one of which is "save", which is used
        to create a new instance of the reader object sent as a parameter in the table.

Read 1:
    For the Read in CRUD, it starts again from the ReaderController, where the request is sent
        to the Reader Service.
    The Reader Service calls the findAll method of the CrudRepository interface and returns a list
        containing the readers found in the DB.

Read 2:
    Another instruction defined as a Read operation is find by id. The request sent also asks for an id
        that will become the main focus. The id represents the Reader object we're looking for in the DB.
    In Reader Service another method of the CrudRepository interface is called, this time findById(id).
        Once an object is found, it returns it to ReaderController, which will again return it.

Update:
    For Update, there's the method updateReader, which gets the information and creates a
        Reader instance with it and sends it as a parameter along with the id of the Reader
        instance to update. There it calls for the updateReader method in ReaderService.
    In Reader Service, first it fetches the Reader instance that needs to be updated using the id
        sent as a parameter. Then, the information sent as a Reader instance is verified,
        field by field. If it is empty, then it means that attribute suffers no changes.
        Otherwise, it verifies if the information sent is valid and updates that attribute.
    After each field is processed, the method save from Reader Repo is called, and the parameter sent
        is the updated reader.
    After the updated info is saved, it returns to the Reader Controller the updated Reader.

Delete:
    For Delete, there's the method deleteReader, which gets the id to delete as a parameter and further
        sends is to the Reader Service.
    In Reader Service, the method deleteById from Reader Repo is called, and the id of the reader to be deleted
        is sent. The action is executed in the DB and then the method returns the message 
        "Reader {id_reader} has been successfully deleted"

Same goes for the other controllers also.