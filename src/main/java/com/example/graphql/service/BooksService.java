package com.example.graphql.service;

import com.example.graphql.model.Books;
import com.example.graphql.repo.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService
{
    @Autowired
    BooksRepository booksRepository;

    //getting all books record by using the method findaAll() of JpaRepository
    public List<Books> getAllBooks()
    {
        List<Books> books = new ArrayList<Books>();
        booksRepository.findAll().forEach(books1 -> books.add(books1));
        return books;
    }

    //getting a specific record by using the method findById() of JpaRepository
    public Books getBooksById(int id)
    {
        return booksRepository.findById(id).get();
    }

    //saving a specific record by using the method save() of JpaRepository
    public void saveOrUpdate(Books books)
    {
        booksRepository.save(books);
    }

    //deleting a specific record by using the method deleteById() of JpaRepository
    public void delete(int id)
    {
        booksRepository.deleteById(id);
    }

    //updating a record
    public void update(Books books, int bookid)
    {
        booksRepository.save(books);
    }
}