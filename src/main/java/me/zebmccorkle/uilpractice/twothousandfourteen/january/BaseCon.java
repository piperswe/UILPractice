package me.zebmccorkle.uilpractice.twothousandfourteen.january;

import java.io.File;
import java.util.Scanner;

public class BaseCon {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("basecon.in"));

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
            System.out.printf("%d %x %o %s%n", intVal, intVal, intVal, Integer.toBinaryString(intVal));
        }
    }
}
