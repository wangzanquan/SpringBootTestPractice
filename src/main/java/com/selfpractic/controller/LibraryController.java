package com.selfpractic.controller;

import com.selfpractic.model.Library;
import com.selfpractic.pojos.AddResponse;
import com.selfpractic.repository.LibraryRepository;
import com.selfpractic.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;

@RestController
public class LibraryController {

    @Autowired
    LibraryRepository repository;

    @Autowired
    LibraryService libraryService;

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Library library){
        //Check if the book already exists
        String id = libraryService.buildId(library.getIsbn(), library.getAisle());
        AddResponse ad = new AddResponse();
        if(!libraryService.checkBookAlreadyExists(id)) {

            //Add book to database
            library.setId(library.getIsbn() + library.getAisle());
            repository.save(library);


            ad.setMessage("Success, Book is added");
            ad.setId(library.getIsbn() + library.getAisle());
            return new ResponseEntity<AddResponse>(ad, HttpStatus.CREATED);
        }else{
            //write the code to tell the book already exist
            ad.setMessage("Book already exists");
            ad.setId(id);
            return new ResponseEntity<AddResponse>(ad, HttpStatus.OK);
        }
    }
    @PostMapping("/deletebook")
    public ResponseEntity deleteBook(@RequestBody String id){
        AddResponse ad = new AddResponse();
        if(!libraryService.checkBookAlreadyExists(id)){
            ad.setMessage("Book is not exist");
            return new ResponseEntity<AddResponse>(ad, HttpStatus.NOT_FOUND);
        }else{
            repository.deleteById(id);
            ad.setId(id);
            ad.setMessage("Book " + ad.getId()+ " is deleted" );

            return new ResponseEntity<AddResponse>(ad, HttpStatus.OK);
        }
    }

}
