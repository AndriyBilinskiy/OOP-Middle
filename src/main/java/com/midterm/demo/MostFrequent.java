package com.midterm.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MostFrequent {
    private final List<String> elements = new ArrayList<String>();
    private boolean IsNotEmpty = false;
    private String mostFrequent;
    private int occurrencesOfMostFrequent = 0;
    public void add(String element) {
        if (element == null) {
            return;
        }
        elements.add(element);
        if (IsNotEmpty) {
            int occurrences = Collections.frequency(elements, element);
            if (occurrences > occurrencesOfMostFrequent) {
                mostFrequent = element;
                occurrencesOfMostFrequent = occurrences;
            }
        }else {
            mostFrequent = element;
            occurrencesOfMostFrequent = 1;
        }
    }
    public String getMostFrequent() {
        return mostFrequent;
    }
}
