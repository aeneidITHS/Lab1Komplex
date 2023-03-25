package com.example.lab1komplexjava.business;

import jakarta.persistence.*;

@Entity
@Table(name = "result")
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer result;
    public Results(){
        this.result = 0;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Long getId() {
        return id;
    }
    public int getAndIncrement(){
        return ++result;
    }
}
