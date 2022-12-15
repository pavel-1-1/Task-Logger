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
            if (n < threshold) {
                logger.log(String.format("Элемент \"%s\" не прошёл", n));
                return false;
            } else {
                logger.log(String.format("Элемент \"%s\" прошёл", n));
                return true;
            }
        }).toList();
    }
}
