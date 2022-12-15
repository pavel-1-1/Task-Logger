package org.example;

import java.util.List;

public class Filter {
    private final int threshold;

    protected Filter(int threshold) {
        this.threshold = threshold;
    }

    protected List<Integer> outFilter(List<Integer> source) {
        Logger logger = Logger.getInstance();
        return source.stream().filter(n -> {
            if (n < threshold){
                logger.log("Элемент не прошол" + n);
            } else {
                logger.log("Элемент прошёл " + n);
            }
            return false;
        }).toList();
    }
}
