package com.selfpractic.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Greeting {

    private long id;
    private String content;


}
