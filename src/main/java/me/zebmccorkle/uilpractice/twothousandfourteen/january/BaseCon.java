package me.zebmccorkle.uilpractice.twothousandfourteen.january;

import java.io.*;
import java.util.Scanner;

public class BaseCon {
    public static void main(String[] args) throws Exception {
        algo(new FileInputStream(new File("basecon.dat")), System.out);
    }

    public static void algo(InputStream inputStream, OutputStream outputStream) throws IOException {
        Scanner scanner = new Scanner(inputStream);

        int amount = scanner.nextInt();
        for (int i = 0; i < amount; i++) {
            String type = scanner.next();
            String val = scanner.next();
            int intVal;
            switch (type) {
                case "H":
                    intVal = Integer.parseInt(val, 16);
                    break;
                case "O":
                    intVal = Integer.parseInt(val, 8);
                    break;
                case "B":
                    intVal = Integer.parseInt(val, 2);
                    break;
                default:
                    intVal = Integer.parseInt(val);
            }
            outputStream.write(String.format("%d %x %o %s%n", intVal, intVal, intVal, Integer.toBinaryString(intVal)).getBytes());
        }
    }
}
