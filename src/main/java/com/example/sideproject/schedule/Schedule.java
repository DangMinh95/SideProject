package com.example.sideproject.schedule;

import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@PropertySource("classpath:schedule.properties")
public class Schedule {

//    @Scheduled(cron = "${schedule.minute}")
//    public void test() {
//        System.out.println("hello");
//    }

}
