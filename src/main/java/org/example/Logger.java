package org.example;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private int num = 1;
    private static Logger logger;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    Date date = new Date();

    private Logger() {
    }

    protected void log(String msg) {
        System.out.printf("[%s %s] %s", dateFormat.format(date), num++, msg);
    }

    protected synchronized static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}
