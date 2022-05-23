package com.LHV.nameMatching;

public class Person{
    public
    String name;
    public int score;

    public Person(String name, int score){
        this.name = name;
        this.score = score;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setScore(int score){
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public String toString() {
        return "name= " + name + "; score= " + score+"%";
    }
}
