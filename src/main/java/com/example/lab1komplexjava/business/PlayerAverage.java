package com.example.lab1komplexjava.business;

public class PlayerAverage implements Comparable {
    private String name;

    private double averageScore;

    public PlayerAverage(String name,Double averageScore){
        this.name = name;
        this.averageScore = averageScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     public double getAverageScore(){
        return averageScore;
     }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }


    @Override
    public int compareTo(Object o) {
        PlayerAverage playerAverage = (PlayerAverage) o;
        return Double.compare(this.averageScore,playerAverage.averageScore);
     }
}
