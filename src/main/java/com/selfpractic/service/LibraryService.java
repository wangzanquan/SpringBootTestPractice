package com.selfpractic.service;

import com.selfpractic.model.Library;
import com.selfpractic.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository repository;

    public String buildId(String isbn, int aisle){
        return isbn + aisle;
    }

    public boolean checkBookAlreadyExists(String id){
        Optional<Library> lib = repository.findById(id);
        if(lib.isPresent()){
            return true;
        }else{
            return false;
        }
    }

}
