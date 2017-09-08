package com.springtask.about;

import org.springframework.boot.jackson.JsonComponent;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Sergey Vasiliev on 9/6/17.
 */

@JsonComponent
public class AboutApplication {

    private String autor;
    private String title;

    private static LocalDateTime startTime;

    public AboutApplication() {
        this.autor = "Sergey Vasiliev";
        this.title = "Spring task applicaion";
    }

    public String getWorkingTimeOfApp() {
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, currentTime);
        return formatDuration(duration);
    }

    public String getAutor() {
        return autor;
    }

    public String getRam_using() {

        // TODO: 9/6/17 discuss getRam_using

        MemoryMXBean memoryMxBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memUsage = memoryMxBean.getHeapMemoryUsage();
        MemoryUsage memNonHeap = memoryMxBean.getNonHeapMemoryUsage();

        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        String smemUsed = df.format((double)(memUsage.getUsed()+memNonHeap.getUsed())/(1024 * 1024));
        String smemMax = df.format((double)(memUsage.getMax())/(1024 * 1024));
        //String smemMax = df.format((double)(memUsage.getMax()+memNonHeap.getMax())/(1024 * 1024));

        return "Memory usage (in MB): "+smemUsed+"/"+smemMax;
    }

    public String getTitle() {
        return title;
    }

    public static void setStartTimeOfApp() {
        startTime = LocalDateTime.now();
    }

    private String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%d:%02d:%02d",
                absSeconds / 3600,
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }

}
