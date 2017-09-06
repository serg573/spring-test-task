package com.springtask.content;

/**
 * Created by Sergey Vasiliev on 9/6/17.
 */

public class StaticContent {

    private static long startTimeOfApp;

    public static long getStartTimeOfApp() {
        return startTimeOfApp;
    }

    public static void setStartTimeOfApp(long startTimeOfApp) {
        StaticContent.startTimeOfApp = startTimeOfApp;
    }

}
