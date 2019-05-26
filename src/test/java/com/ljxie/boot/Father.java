package com.ljxie.boot;

import java.util.HashMap;

public class Father {
    public static void main(String args[]){
        Father son= new Son();
       new  HashMap();
        son.initTest();
    }
    public void test(){
        System.out.println("father");
    }
    public void initTest(){
        Test t=new Test();
        t.start();
    }
    class Test extends Thread{
        public void run(){

            for (;;) {
                try {
                    test();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    sleep(2000);
                } catch (InterruptedException ie) {
                }
            }
        }
    }
}
class Son extends Father{
    @Override
    public void test(){
        System.out.println("Son");
    }
}