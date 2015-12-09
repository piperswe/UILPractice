package me.zebmccorkle.uilpractice.twothousandfourteen.january;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RadDeg {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("raddeg.dat"));

        while (scanner.hasNextDouble()) {
            double raddeg = scanner.nextDouble();
            if (raddeg % 1 != 0) {
                System.out.printf("%.2f radians = %d degrees%n", raddeg, (int) Math.round(Math.toDegrees(raddeg)));
            } else {
                System.out.printf("%d degrees = %.2f radians%n", (int) Math.round(raddeg), Math.toRadians(raddeg));
            }
        }
    }
}
