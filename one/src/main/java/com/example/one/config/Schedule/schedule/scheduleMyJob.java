package com.example.one.config.Schedule.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class scheduleMyJob {

   /* @Autowired
    public TimeOut timeOut;*/

        private Logger logger = LoggerFactory.getLogger(scheduleMyJob.class);
        public final static long ONE_Minute =  3000 * 1000;

       // @Scheduled(fixedDelay=ONE_Minute)
        public void fixedDelayJob() throws InterruptedException {
            logger.info( new SimpleDateFormat("yyyy-MM-dd 24HH:mm:ss").format(new Date(System.currentTimeMillis()))+" >>fixedDelay执行.... start");
           // timeOut.warnMessage();
            Thread.sleep(5000L);
        }

       // @Scheduled(fixedRate=ONE_Minute)
        public void fixedRateJob() throws InterruptedException {
            logger.info(new SimpleDateFormat("yyyy-MM-dd 24HH:mm:ss").format(new Date(System.currentTimeMillis()))  +" >>fixedRate执行....");
            Thread.sleep(8000L);
            System.out.print("定时器----Schedule");
        }

        /**
         * 第一位，表示秒，取值0-59
         * 第二位，表示分，取值0-59
         * 第三位，表示小时，取值0-23
         * 第四位，日期天/日，取值1-31
         * 第五位，日期月份，取值1-12
         * 第六位，星期，取值1-7，1表示星期天，2表示星期一
         * 第七位，年份，可以留空，取值1970-2099
       /*  *//*
        @Scheduled(cron="* 1 12 * * ?")
        public void cronJob(){
            logger.info(new SimpleDateFormat("yyyy-MM-dd 24HH:mm:ss").format(new Date(System.currentTimeMillis()))+" >>cron执行....");
            timeOut.warnMessage();
        }*/
        //每小时的10分执行一次
        @Scheduled(cron="0 10 * * * ?")
        public void cronJob(){
            logger.info(new SimpleDateFormat("yyyy-MM-dd 24HH:mm:ss").format(new Date(System.currentTimeMillis()))+" >>cron执行....");
//            timeOut.warnMessage();
        }


}
