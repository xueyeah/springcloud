package com.ljxie.boot;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class ProductConsume {
    public static void main(String[] args) {
        ProductConsume pc = new ProductConsume();
        Storage storage= pc.new Storage();
        Product producer = pc.new Product(storage);
        Consumer consumer = pc.new Consumer(storage);
        System.out.println("xxxx");
        Thread t1 = new Thread(producer);

        Thread t2 = new Thread(consumer);
        t2.start();
        t1.start();
    }
    class Product implements Runnable{
        private Storage storage;
        public Product(Storage s){
                this.storage=s;
        }
        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                storage.add();
            }
        }
    }
    class Consumer implements Runnable{
        private Storage storage;
        public Consumer(Storage storage ){
            this.storage=storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.take();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Storage {
        private List storage;
//最大生产数量
        private int maxSize;
        public Storage(){
            maxSize = 10;
            storage = new LinkedList();
        }

        public synchronized  void add(){
            while(storage.size()==maxSize){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add(new Date());
            System.out.println("---------当前个数"+storage.size());
            notifyAll();
        }
        public synchronized  void take(){
            while(storage.size()==0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("剩余: "+ storage.size()+ ",Time: " +((LinkedList<?>)storage).poll());
            notifyAll();//唤醒在等待操作资源的线程（队列）
        }
    }

}
