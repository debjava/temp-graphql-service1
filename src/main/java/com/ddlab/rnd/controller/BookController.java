package com.ddlab.rnd.controller;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.ddlab.rnd.entity.Author;
import com.ddlab.rnd.entity.Book;

@Controller
class BookController {

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }
    
    @MutationMapping
    public Book updateBook(@Argument String id, @Argument String name) {
    	System.out.println("Id: "+id);
    	System.out.println("Name: "+id);
      return Book.updateBook(id, name);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }

}