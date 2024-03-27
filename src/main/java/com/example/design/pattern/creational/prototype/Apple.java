package com.example.design.pattern.creational.prototype;

public class Apple extends Fruit{
    @Override
    Fruit copy() {
        return new Apple();
    }
}
