package com.ljxie.boot;

public class DataStruct {


    public static int FibonacciTailRecursively(int n, int acc1, int acc2) {
        if (n == 0)
            return acc1;
        else
            return FibonacciTailRecursively(n - 1, acc2, acc1 + acc2);
    }
    public static int FibonacciRecursively(int n){
        if (n < 2)
            return n;
        else
            return FibonacciRecursively(n - 1) + FibonacciRecursively(n - 2);
    }
    public static void main(String[] args){

        System.out.println(FibonacciTailRecursively(2,0,1));
        System.out.println(FibonacciRecursively(2));
    }
}
