package com.example.graphql.controller;

import com.example.graphql.model.Books;
import com.example.graphql.service.BooksService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class BooksController
{
    @Autowired
    BooksService booksService;

    @QueryMapping("allBooks")
    private List<Books> getAllBooks()
    {
        return booksService.getAllBooks();
    }

    @QueryMapping("getBook")
    private Books getBooks(@Argument("bookId") int bookId)
    {
        return booksService.getBooksById(bookId);
    }

    @MutationMapping("deleteBook")
    private Boolean deleteBook(@Argument("bookId") int bookId)
    {
        booksService.delete(bookId);
        return true;
    }

    @MutationMapping("createBook")
    private Books saveBook(@Argument BookInput book)
    {
        Books b=new Books();
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        b.setBookname(book.getBookname());
        System.out.println("Inside Post Method");
        booksService.saveOrUpdate(b);
        return b;
    }

    @PutMapping("/books")
    private Books update(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return books;
    }
}

@Getter
@Setter
class BookInput{
    private String bookname;
    private String author;
    private int price;
}