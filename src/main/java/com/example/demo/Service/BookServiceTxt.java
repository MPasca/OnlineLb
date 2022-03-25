package com.example.demo.Service;

import com.example.demo.Model.Book;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceTxt implements IBookService{
    @Override
    public Book saveBook(Book newBook) {
        try (final FileOutputStream fileOut = new FileOutputStream("books.txt", true);
             final ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeChars(newBook.toString());
                out.flush();
                System.out.println("Success");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newBook;
    }

    @Override
    public List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();

        try (final FileReader fileIn = new FileReader("books.csv");
             final BufferedReader in = new BufferedReader(fileIn)) {

            bookList = in.lines().map(
                    line->{
                        String[] createBook = line.split(" ");

                        Long id = Long.parseLong(createBook[0]);
                        String title = createBook[1];
                        String author = createBook[2];
                        String genre = createBook[3];
                        String publisher = createBook[4];
                        int year = Integer.parseInt(createBook[5]);
                        String ISBN = createBook[6];
                        String cover = createBook[7];
                        boolean isBorrowed = Boolean.parseBoolean(createBook[8]);

                        Book newBook = new Book();
                        newBook.setId(id);
                        newBook.setTitle(title);
                        newBook.setAuthor(author);
                        newBook.setGenre(genre);
                        newBook.setPublisher(publisher);
                        newBook.setYear(year);
                        newBook.setISBN(ISBN);
                        newBook.setCover(cover);
                        newBook.setBorrowed(isBorrowed);

                        return newBook;
                    }
            ).collect(Collectors.toList());

            System.out.println("Success");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    @Override
    public Book updateBook(Book toUpdate, Long bookID) {
        return null;
    }

    @Override
    public void deleteBookById(Long toDeleteId) {

        try {

            File inFile = new File("books.txt");

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(inFile));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original and write in temp UNLESS it's the line to be deleted
            while ((line = bufferedReader.readLine()) != null) {
                String[] bookDets = line.split(" ");
                if(Long.parseLong(bookDets[0]) == toDeleteId) {
                    // delete line
                }

            }

            printWriter.close();
            bufferedReader.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
