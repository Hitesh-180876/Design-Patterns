package com.example.design.pattern.creational.builder;

public class School {
    private String name;
    private String city;

    public void setName(String name){
        this.name = name;
    }

    public void setCity(String city){
        this.city = city;
    }

    public static class Builder {
        School school;

        public Builder withName(String name){
            school.city = name;
            return this;
        }

        public Builder(){
            this.school = new School();
        }
        public Builder withCity(String city){
            school.city = city;
            return this;
        }

        public School build(){
            return school;
        }
    }
}
