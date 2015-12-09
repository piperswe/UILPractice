package me.zebmccorkle.uilpractice.twothousandeight.districttwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class CabNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("cabnumbers.dat"));

        Map<BigInteger, Number> nums = new HashMap<>();
        List<BigInteger> finalNums = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                Number number = new Number(BigInteger.valueOf(i), BigInteger.valueOf(j));
                boolean add = true;
                for (Map.Entry<BigInteger, Number> num : nums.entrySet()) {
                    if (!number.a.equals(num.getValue().a) && !number.a.equals(num.getValue().b) && !number.b.equals(num.getValue().a) && !number.b.equals(num.getValue().b) && number.num.equals(num.getValue().num)) {
                        finalNums.add(number.num);
                        add = false;
                        break;
                    }
                }
                if (add) nums.put(number.num, number);
            }
        }
        Collections.sort(finalNums);
        for (BigInteger num : finalNums) {
            System.out.println(num.toString());
        }
    }

    public static class Number {
        public BigInteger num;
        public BigInteger a;
        public BigInteger b;
        public Number(BigInteger a, BigInteger b) {
            this.a = a;
            this.b = b;
            this.num = a.pow(3).add(b.pow(3));
        }
    }
}
