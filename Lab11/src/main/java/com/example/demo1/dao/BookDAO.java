package com.example.demo1.dao;

import com.example.demo1.database.BookDB;
import com.example.demo1.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAO {
    public List<Book> findAll() { // select * from book
        return BookDB.bookList;
    }

    public Book findById(int id) { // select * from book where id = ?
        for (Book book : BookDB.bookList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}