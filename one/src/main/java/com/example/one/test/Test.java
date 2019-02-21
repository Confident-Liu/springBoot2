package com.example.one.test;

/**
 * @author LiuJiangFeng
 * @ClassName: Test
 * @Date 2019/2/19 11:07
 */
public class Test {

    public static void main(String[] args){

        Thread t=Thread.currentThread();
        System.out.print("当前主线程为："+t);
        ThreadA threada = new ThreadA();
        ThreadB threadb = new ThreadB();
        threada.setPriority(5);


        Thread b = new Thread(threadb);
         b.setPriority(1);
        threada.start();
        b.start();

    }


}
