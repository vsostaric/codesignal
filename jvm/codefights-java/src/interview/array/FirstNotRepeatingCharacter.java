package interview.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FirstNotRepeatingCharacter {

    private static final Function<String, Character> firstNonRepeatingCharacter = (s) -> {
        if (s.length() == 1) {
            return s.charAt(0);
        }

        final Map<Character, Integer> counts = new HashMap<>();
        final List<Character> unique = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (counts.keySet().contains(c)) {
                counts.put(c, counts.get(c) + 1);
            } else {
                counts.put(c, 0);
                unique.add(c);
            }
        }

        for (Character c : unique) {
            if (counts.get(c) == 0) {
                return c;
            }
        }

        return '_';

    };

    public static void main(String[] args) {

        System.out.println(firstNonRepeatingCharacter.apply("abacabad") + " ---> Should be c");
        System.out.println(firstNonRepeatingCharacter.apply("abacabaabacaba") + " ---> Should be _");
        System.out.println(firstNonRepeatingCharacter.apply("bcb") + " ---> Should be c");

    }

}
