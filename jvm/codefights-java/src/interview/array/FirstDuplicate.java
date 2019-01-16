package interview.array;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class FirstDuplicate {

    private static final Function<int[], Integer> firstDuplicate = (int[] a) -> {
        final Set<Integer> ints = new HashSet<>();

        for (int i : a) {
            if (ints.contains(i)) {
                return i;
            }
            ints.add(i);
        }

        return -1;
    };

    public static void main(String[] args) {

        int[] testArray1 = {2, 1, 3, 5, 3, 2};
        System.out.println(firstDuplicate.apply(testArray1) + " ---> Should be 3");

        int[] testArray2 = {5, 5};
        System.out.println(firstDuplicate.apply(testArray2) + " ---> Should be 5");

    }


}
