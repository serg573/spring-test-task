package com.springtask.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Sergey Vasiliev on 9/7/17.
 */

@Component
public class SaveStatistics {

    @Scheduled(cron = "0 0/1 * * * ?") // fires every 1 minutes
    public void run() {

        //System.out.println("The time is now "+dateFormat.format(new Date()));
    }
}
