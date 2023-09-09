package com.example.demo.model;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    @Setter
    private String name;
    @Override
    public String toString(){
        return this.name;
    }
}
