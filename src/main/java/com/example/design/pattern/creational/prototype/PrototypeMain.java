package com.example.design.pattern.creational.prototype;

public class PrototypeMain {

    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple);
        Apple apple1 = (Apple) apple.copy();
        System.out.println(apple1);

    }
}
