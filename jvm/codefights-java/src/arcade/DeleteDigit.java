package arcade;

import java.util.function.Function;
import java.util.stream.IntStream;

public class DeleteDigit {

    private static final Function<Integer, Integer> deleteDigit = i -> {

        final String iDigit = i.toString();
        return IntStream.range(0, iDigit.length())
                .map(index -> Integer.valueOf(iDigit.substring(0, index) + iDigit.substring(index + 1))
                ).max().orElse(0);

    };

    public static void main(String[] args) {
        System.out.println(deleteDigit.apply(152) + " ---> Should be 52");
        System.out.println(deleteDigit.apply(1001) + " ---> Should be 101");
        System.out.println(deleteDigit.apply(10) + " ---> Should be 1");
        System.out.println(deleteDigit.apply(222219) + " ---> Should be 22229");
        System.out.println(deleteDigit.apply(109) + " ---> Should be 19");
        System.out.println(deleteDigit.apply(222250) + " ---> Should be 22250");
    }


}
