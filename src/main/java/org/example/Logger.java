package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private int num = 1;
    private static Logger logger;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private Logger() {
    }

    protected void log(String msg) {
        Date date = new Date();
        System.out.printf("[%s %s] %s\n", dateFormat.format(date), num++, msg);
    }

    protected synchronized static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}
