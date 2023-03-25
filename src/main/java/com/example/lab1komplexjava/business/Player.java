package com.example.lab1komplexjava.business;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Access(AccessType.PROPERTY)
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Results> results;

    public Player(String user) {
        this.results = new ArrayList<>();
        this.name = user;
    }

    public Player() {

    }


    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public void addResult(Results result){
        results.add(result);
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
