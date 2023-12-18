package com.selfpractic.controller;

import com.selfpractic.model.Library;
import com.selfpractic.pojos.AddResponse;
import com.selfpractic.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @Autowired
    LibraryRepository repository;

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Library library){
        //Check if the book already exists

        //Add book to database
        library.setId(library.getIsbn() + library.getAisle());
        repository.save(library);

        AddResponse ad = new AddResponse();
        ad.setMessage("Success, Book is added");
        ad.setId(library.getIsbn() + library.getAisle());
        return new ResponseEntity<AddResponse>(ad, HttpStatus.CREATED);

    }

}
