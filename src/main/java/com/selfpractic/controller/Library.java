package com.selfpractic.controller;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "LibraryDemo")
public class Library {

    @Column(name = "boo_name")
    private String book_name;
    @Column(name = "id")
    private String id;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "aisle")
    private int aisle;
    @Column(name = "author")
    private String author;

}
