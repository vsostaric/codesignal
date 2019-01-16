package challange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TreeBottom {

    private static List<String> getNextLevelTrees(String tree) {
        List<String> nextLevelTrees = new ArrayList<>();

        int itr = 1;
        int open = 0;
        int closed = 0;

        int leftIndexOfBranch = -1;

        while (nextLevelTrees.size() != 2) {

            if (tree.charAt(itr) == '(') {
                if (open == 0) {
                    leftIndexOfBranch = itr;
                }
                open++;
            } else if (tree.charAt(itr) == ')') {
                closed++;
            }

            if ((open + closed) > 0 && open == closed) {
                nextLevelTrees.add(tree.substring(leftIndexOfBranch, itr + 1));
                open = 0;
                closed = 0;
                leftIndexOfBranch = -1;
            }

            itr++;

        }

        return nextLevelTrees;

    }

    private static List<String> getNextLevelTree(List<String> p_tree) {

        return p_tree.stream()
                .filter(branch -> !"()".equals(branch))
                .map(tree -> getNextLevelTrees(tree))
                .flatMap(nextLevelTrees -> nextLevelTrees.stream())
                .collect(Collectors.toList());

    }

    private static List<String> getBottomLevelTrees(List<String> tree) {
        List<String> nextLevelTree = getNextLevelTree(tree);
        boolean isBottom = nextLevelTree.stream().allMatch(branch -> "()".equals(branch));

        if (isBottom) {
            return tree;
        }

        return getBottomLevelTrees(nextLevelTree);

    }

    private static int[] collectValues(List<String> bottom) {
        return bottom.stream()
                .filter(branch -> !"()".equals(branch))
                .map(branch -> branch.replaceAll("[\\(\\) ]+", ""))
                .mapToInt(branch -> Integer.valueOf(branch))
                .toArray();
    }

    private static final Function<String, int[]> treeBottom = (String tree) -> {

        List<String> trees = new ArrayList<>();
        trees.add(tree);

        List<String> bottom = getBottomLevelTrees(trees);

        return collectValues(bottom);
    };

    public static void main(String[] args) {

        System.out.println(
                Arrays.toString(treeBottom.apply("(2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))")) + " ---> Should be [5, 11, 4]");
        System.out.println(
                Arrays.toString(treeBottom.apply("(1 () ())")) + " ---> Should be [1]");
        System.out.println(
                Arrays.toString(treeBottom.apply("(413 (683 () ()) (355 (913 (985 () ()) ()) ()))")) + " ---> Should be [985]");

    }

}
