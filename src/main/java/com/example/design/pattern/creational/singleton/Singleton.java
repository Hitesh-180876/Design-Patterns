package com.example.design.pattern.creational.singleton;

public class Singleton {

    public static Singleton obj = new Singleton();
    private Singleton(){

    }

    public static Singleton getSingletonObj(){
        return obj;
    }

    public static void main(String[] args) {
        Singleton obj = getSingletonObj();
        System.out.println(obj);
        Singleton obj1 = getSingletonObj();
        System.out.println(obj);

    }
}
