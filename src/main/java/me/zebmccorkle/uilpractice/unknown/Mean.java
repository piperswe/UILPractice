package me.zebmccorkle.uilpractice.unknown;

/*
  Your task is the find the mean, median and mode of a list of integers. Each list will be on one line of at least 3 numbers
  and no more than 20 positive integers. The largest number will be 99 (2-digit numbers).
  
  Input: The first line consists of the number of data sets. Eacvh subsequent line contains from 3 to 20 integers of random
  order.
  
  Output: The first line of output will be `"mean median mode"`. Each subsequent line will have the mean, median, and mode
  printed out below the words aligned right-justified. Print out all numbers as decimals to the nearest tenth.
*/

import java.io.*;
import java.util.*;

public class Mean {
    public static final String FILENAME = "mean.dat";

    public static List<String> lines = new ArrayList<>();

    public static void print(String line) {
        lines.add(line);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File(FILENAME));

        int datasets = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> parsedLines = new ArrayList<>();

        for (int i = 0; i < datasets; i++) {
            String line = scanner.nextLine();
            String[] numberStrings = line.split(" ");
            List<Integer> numbers = new ArrayList<>();

            for (String numberString : numberStrings) {
                if (!numberString.equals("")) numbers.add(Integer.parseInt(numberString));
            }

            parsedLines.add(numbers);
        }

        parsedLines.stream().forEach((parsedLine) -> {
            // mean
            int added = 0;
            added = parsedLine.stream().map((Integer i) -> i).reduce(added, Integer::sum);
            double mean = (double) added / (double) parsedLine.size();

            // median
            Collections.sort(parsedLine);
            double median;
            if (parsedLine.size() % 2 == 0) {
                double a = parsedLine.get(parsedLine.size() / 2 - 1);
                double b = parsedLine.get(parsedLine.size() / 2);
                median = Math.round((a + b) / 2 * 10.0) / 10.0;
            } else {
                median = Math.round(parsedLine.get(parsedLine.size() / 2 + 1) * 10.0) / 10.0;
            }

            // mode
            Map<Integer, Integer> occurrences = new HashMap<>();
            parsedLine.stream().forEach((i) -> occurrences.put(i, occurrences.get(i) != null ? occurrences.get(i) + 1 : 1));
            int currentHighest = 0;
            int mode = -1;
            for (Integer i : parsedLine) {
                if (occurrences.get(i) > currentHighest) {
                    currentHighest = occurrences.get(i);
                    mode = i;
                }
            }

            String meanString;
            String modeString;
            String medianString;

            if (Math.round(mean * 10.0) / 10.0 >= 10) {
                meanString = ""  + Math.round(mean * 10.0) / 10.0;
            } else {
                meanString = " " + Math.round(mean * 10.0) / 10.0;
            }
            if (median >= 10) {
                medianString = ""  + median;
            } else {
                medianString = " " + median;
            }
            if (mode >= 10) {
                modeString = ""  + (double) mode;
            } else {
                modeString = " " + (double) mode;
            }

            print(meanString + "   " + medianString + " " + modeString);
        });

        System.out.println("mean median mode");
        lines.stream().forEach(System.out::println);
    }
}