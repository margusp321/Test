package com.LHV.nameMatching;

public class Person{
    //int code;
    public
    String name;
    public int score;

    public Person(String name, int score){
        this.name = name;
        this.score = score;
    }

    /*public void setScore(int code){
        this.code = code;
    }*/

    public void setName(String name){
        this.name = name;
    }

    public void setScore(int score){
        this.score = score;
    }

    /*public int getCode(){
        return code;
    }*/

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }
/*
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getScore().compareTo(p2.getScore());
    }*/

    public String toString() {
        return "name= " + name + "; score= " + score+"%";
    }
}
