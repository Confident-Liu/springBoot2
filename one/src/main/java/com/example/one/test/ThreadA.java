package com.example.one.test;

/**
 * @author LiuJiangFeng
 * @ClassName: ThreadA
 * @Date 2019/2/19 11:03
 */
public class ThreadA extends Thread {

    public void run(){
        for (int i = 0; i <100 ; i++) {
            System.out.print(i+",");
        }
    }
}
