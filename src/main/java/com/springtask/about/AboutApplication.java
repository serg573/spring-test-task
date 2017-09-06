package com.springtask.about;

import com.springtask.content.StaticContent;
import org.springframework.boot.jackson.JsonComponent;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Sergey Vasiliev on 9/6/17.
 */

@JsonComponent
public class AboutApplication {

    private String autor;
    private String title;

    public AboutApplication() {
        this.autor = "Sergey Vasiliev";
        this.title = "Spring task applicaion";
    }

    public String getWorkingTimeOfApp() {

        long totalTime = System.currentTimeMillis() - StaticContent.getStartTimeOfApp();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Kiev")); // TODO: 9/6/17 getTimeZone
        calendar.setTimeInMillis(totalTime);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(calendar.getTime());
    }

    public String getAutor() {
        return autor;
    }

    public String getRam_using() {

        // TODO: 9/6/17 getRam_using

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
}
