package com.ljxie.boot;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args){
        ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        tp.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("xlj...");
            }
        });
        ExecutorService fixtp = Executors.newFixedThreadPool(5);
        fixtp.execute(new Thread(){
            public void run() {
                System.out.println("xlj2...");
            }
        });
    }
}
