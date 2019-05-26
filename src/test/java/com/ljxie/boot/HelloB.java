package com.ljxie.boot;

public class HelloB extends HelloA{
    public HelloB(){
        System.out.println("HelloB");
    }
    { System.out.println("I'm b class");}
    static { System.out.println("static b");}
    public static void main(String args[]) {
        System.out.println("----main start---");
        new HelloA();
        new HelloB();
        System.out.println("----main end---");
    }
}
class HelloA{
    public HelloA(){
        System.out.println("HelloA");
    }
    { System.out.println("I'm a class");}
    static { System.out.println("static a");}
}

