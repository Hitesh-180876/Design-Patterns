
SingleTon

Suppose if we want to create a class with only single object/instance,
then we can use Singleton Design pattern (in simple it's a set of rules)
*It restricts the instantiation of a class and ensures that only one instance of that class
exists in JVM.


It's just simply define a class that has only once instance and a global point of access.

There are two forms of SDP:
1. Eager Initialization
/*
    package com.example.singleton;

    public class MyClass {

        //only single instance of the class
        private static final MyClass instance = new MyClass();

        // private constructor to avoid client applications using the constructor
        private MyClass(){}

        //global access point to use this object from outside
        public static MyClass getInstance() {
            return instance;
        }
    }
*/

    Private constructor to restrict instantiation of the class from other classes.
    Private static variable of the same class that is the only instance of the class.
    Public static method that returns the instance of the class, this is the global
    access point for the outer world to get the instance of the singleton class.

    Drawback:
        * Instance is created at the time of class loading. method is created even though the client
        application might not be using it.


2. Lazy Initialization
/*
    package com.example.singleton;

    public class MyClass {

        private static MyClass instance;

        private MyClass(){}

        // create instance on calling getInstance() method
        public static MyClass getInstance() {
            if (instance == null) {
                instance = new MyClass();
            }
            return instance;
        }
    }
*/
    Drawback:
        In multi threaded environment, might be two thread inside if condition wants to create
        the instance and break the singleton pattern (thread unsafe)

    Thread Safe Singleton:
    /*
        package com.example.singleton;

            public class MyClass {

                private static MyClass instance;

                private MyClass(){}

                //only single thread can access getInstance at a time
                public static synchronized MyClass getInstance() {
                    if (instance == null) {
                        instance = new MyClass();
                    }
                    return instance;
                }

            }
    */

    To Avoid extra over head on method we can use double checked locking:

    /*
        public static MyClass getInstanceUsingDoubleLocking() {
            if (instance == null) {
                //synchronized block, it's scope is smaller than method
                synchronized (MyClass.class) {
                    if (instance == null) {
                        instance = new MyClass();
                    }
                }
            }
            return instance;
        }
    */


Using Reflection We can destroy the singleton

    package com.example.singleton;

    import java.lang.reflect.Constructor;

    public class ReflectionSingletonTest {

        public static void main(String[] args) {
            EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
            EagerInitializedSingleton instanceTwo = null;
            try {
                Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
                for (Constructor constructor : constructors) {
                    // This code will destroy the singleton pattern
                    constructor.setAccessible(true);
                    instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(instanceOne.hashCode());
            System.out.println(instanceTwo.hashCode());
        }

    }

*/

To overcome the situation of reflection we can use enum as it's instantiated at once
