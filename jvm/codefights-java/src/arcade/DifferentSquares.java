package arcade;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class DifferentSquares {

    private static final Function<int[][], Integer> differentSquares = matrix -> {

        if (matrix == null || matrix.length < 2) {
            return 0;
        }

        Set<String> squares = new HashSet<>();

        for (int i = 1; i < matrix.length; i++) {

            if (matrix[i].length < 2) {
                return 0;
            }

            for (int j = 0; j < matrix[i].length - 1; j++) {
                squares.add("" + matrix[i][j] + matrix[i][j + 1] + matrix[i - 1][j] + matrix[i - 1][j + 1]);
            }
        }

        return squares.size();
    };

    public static void main(String[] args) {

        int[][] matrix1 = {{1, 2, 1}, {2, 2, 2}, {2, 2, 2}, {1, 2, 3}, {2, 2, 1}};
        System.out.println(differentSquares.apply(matrix1) + " ---> Should be 6");

        int[][] matrix2 = {{9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9}};
        System.out.println(differentSquares.apply(matrix2) + " ---> Should be 1");

        int[][] matrix3 = {{3}};
        System.out.println(differentSquares.apply(matrix3) + " ---> Should be 0");

        int[][] matrix4 = {{3, 4, 5, 6, 7, 8, 9}};
        System.out.println(differentSquares.apply(matrix4) + " ---> Should be 0");

        int[][] matrix5 = {{3},
                {4},
                {5},
                {6},
                {7}};
        System.out.println(differentSquares.apply(matrix5) + " ---> Should be 0");

        int[][] matrix6 = {{2, 5, 3, 4, 3, 1, 3, 2},
                {4, 5, 4, 1, 2, 4, 1, 3},
                {1, 1, 2, 1, 4, 1, 1, 5},
                {1, 3, 4, 2, 3, 4, 2, 4},
                {1, 5, 5, 2, 1, 3, 1, 1},
                {1, 2, 3, 3, 5, 1, 2, 4},
                {3, 1, 4, 4, 4, 1, 5, 5},
                {5, 1, 3, 3, 1, 5, 3, 5},
                {5, 4, 4, 3, 5, 4, 4, 4}};
        System.out.println(differentSquares.apply(matrix6) + " ---> Should be 54");

    }

}
