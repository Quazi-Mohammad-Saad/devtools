package com.test.devtools.services;

import com.test.devtools.dao.BookRepository;
import com.test.devtools.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
//    public static List<Book> list = new ArrayList<>();
//    static {
//        list.add(new Book(1,"Python","Quazi"));
//        list.add(new Book(2,"Python for Analyst","Saad"));
//        list.add(new Book(3,"Machine Learning","Dabur"));
//        list.add(new Book(4,"Data Science","Firdous"));
//    }
//    get all books
    public List<Book> getAll(){
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }
//    get individual book
    public Book getBook(int id){
        Book book=null;
        try{
           book= this.bookRepository.findById(id);
        }
//        book = list.stream().filter(i->i.getId()==id).findFirst().get();}
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  book;
    }
//    add a new book
    public Book addBook(Book book)
    {
        Book b = this.bookRepository.save(book);
        return b;
    }
    //delete a book
    public void deleteBook(int id)
    {
        this.bookRepository.deleteById(id);
//        list = list.stream().filter(book -> book.getId()!=id).collect(Collectors.toList());
    }

    //update the book
    public void updateBook(int id, Book book){
        book.setId(id);
        this.bookRepository.save(book);
//        list = list.stream().map(b->{
//            if(b.getId()==id)
//            {
//                b.setName(book.getName());
//                b.setAuthor(book.getAuthor());
//            }
//            return b;
//        }).collect(Collectors.toList());
    }

}
