package me.zebmccorkle.uilpractice.twothousandeight.districttwo;

import java.io.File;
import java.util.*;

public class Call {
    public static final String FILENAME = "call.dat";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File(FILENAME));

        int dataSets = scanner.nextInt();

        for (int i = 0; i < dataSets; i++) {
            char[] number = scanner.next().toCharArray();
            Map<Character, String> translations = new HashMap<>();

            for (int j = 0; j < 10; j++) {
                translations.put(scanner.next().toCharArray()[0], scanner.next());
            }

            List<String> mnemonics = new ArrayList<>();
            Map<Integer, List<Character>> potentialCharacters = new HashMap<>();
            for (int j = 0; j < number.length; j++) {
                potentialCharacters.put(j, new ArrayList<>());

                for (char k : translations.get(number[j]).toCharArray()) {
                    potentialCharacters.get(j).add(k);
                }
            }

            System.out.println("Mnemonics for " + new String(number) + ":");
            for (char j : potentialCharacters.get(0)) {
                List<Character> result = new ArrayList<>();
                for (int k = 0; k < number.length; k++) {
                    for (char l : potentialCharacters.get(k)) {
                        System.out.print(l);
                    }
                }
            }
            System.out.println();

        }
    }
}
