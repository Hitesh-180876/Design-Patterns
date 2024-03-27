package com.example.design.pattern.creational.builder;

public class BuilderMain {
    public static void main(String[] args) {
        School school = new School.Builder().withName("cuh").withCity("mahendergarh").build();

        System.out.println(school);
    }
}
