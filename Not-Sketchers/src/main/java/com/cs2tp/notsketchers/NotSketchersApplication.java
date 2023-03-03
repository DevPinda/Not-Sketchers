package com.cs2tp.notsketchers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.cs2tp.notsketchers.entities")
public class NotSketchersApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotSketchersApplication.class, args);
    }

}
