package com.example.one.test;

/**
 * @author LiuJiangFeng
 * @ClassName: ThreadB
 * @Date 2019/2/19 11:05
 */
public class ThreadB implements Runnable {
    @Override
    public void run() {
        for (int i = 400; i <500 ; i++) {
            System.out.print(i+".");
        }
    }
}
