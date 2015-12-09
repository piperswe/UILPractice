package me.zebmccorkle.uilpractice.twothousandeight.districttwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Count {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("count.dat"));
        int lines = 0;
        try {
            while (scanner.nextLine() != null) lines++;
        } catch (NoSuchElementException e) {
            System.out.println(lines);
        }
    }
}
