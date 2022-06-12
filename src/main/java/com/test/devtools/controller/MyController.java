package com.test.devtools.controller;

import com.test.devtools.entities.Book;
import com.test.devtools.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public ResponseEntity<List<Book>> getAll(){

        List<Book> list = this.bookService.getAll();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);
    }
    @RequestMapping("/books/{n}")
    public ResponseEntity<Book> getAll(@PathVariable("n") int id){
        Book book= this.bookService.getBook(id);
        if (book == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        Book b= null;
        try
        {
            b = this.bookService.addBook(book);
            return ResponseEntity.ok(b);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/books/{bookid}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookid") int id)
    {

        try{
            this.bookService.deleteBook(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @PutMapping("/books/{bookId}")
    public ResponseEntity<?> updateBook(@PathVariable("bookId") int id,@RequestBody Book book){

        try{
            this.bookService.updateBook(id,book);
            return ResponseEntity.ok().body(book
            );
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
