package com.example.design.pattern.creational.prototype;

public class Orange extends Fruit{
    @Override
    Fruit copy() {
        return new Orange();
    }
}
