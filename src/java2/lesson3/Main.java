package java2.lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] allNames = new String[]{"John", "Paul", "Monica", "Angela", "Chris", "Thomas", "Ray", "James", "John", "Clara", "Zoe",
                "Maria", "Jessica", "Paul", "Clara", "Julia", "Ray", "Natalie", "Vanessa", "Kelly", "Anthony", "Max", "Victor", "Bob"};
        ArrayList listNames = new ArrayList<>(Arrays.asList(allNames));
        Set setNames = new HashSet();
        setNames.addAll(listNames);
        System.out.println(setNames);

        System.out.println("\nСколько раз встречается каждое слово:");
        HashMap<String, Integer> countNames = new HashMap<>();
        for (String word : allNames) {
            if (!countNames.containsKey(word)) {
                countNames.put(word, 0);
            }
            countNames.put(word, countNames.get(word) + 1);
        }
        for (String word : countNames.keySet()) {
            System.out.println(word + " " + countNames.get(word));
        }
    }
}