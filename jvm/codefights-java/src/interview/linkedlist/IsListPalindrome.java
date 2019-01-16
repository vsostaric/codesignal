package interview.linkedlist;

import java.util.function.Function;

public class IsListPalindrome {

    private static final Function<ListNode<Integer>, Boolean> isListPalindrome = (ListNode<Integer> l) -> {
        if (l == null || l.next == null || l.value == null) {
            return true;
        }

        ListNode<Integer> pointer = l;
        ListNode<Integer> pointer2 = l;

        while (true) {
            pointer2 = pointer2.next.next;
            if ((pointer2 == null || pointer2.next == null)) {
                break;
            }
            pointer = pointer.next;
        }

        boolean isEvenList = pointer2 == null;

        ListNode<Integer> leftList = l;
        ListNode<Integer> rightList;
        if (isEvenList) {
            rightList = pointer.next;
        } else {
            rightList = pointer.next.next;
        }

        pointer.next = null;


        ListNode<Integer> current = leftList;
        ListNode<Integer> next = leftList.next;
        ListNode<Integer> future;

        current.next = null;

        while (next != null) {

            future = next.next;
            next.next = current;

            current = next;
            next = future;
        }

        leftList = current;

        while (leftList != null) {
            if (!leftList.value.equals(rightList.value)) {
                return false;
            }
            leftList = leftList.next;
            rightList = rightList.next;
        }

        return true;
    };

    public static void main(String[] args) {

        ListNode<Integer> testList =
                new ListNode<>(0, new ListNode<>(1,
                        new ListNode<>(1)));

        System.out.println(isListPalindrome.apply(testList) + " ---> Should be false");

        testList =
                new ListNode<>(0, new ListNode<>(1,
                        new ListNode<>(1,
                                new ListNode<>(0))));
        System.out.println(isListPalindrome.apply(testList) + " ---> Should be true");

        testList =
                new ListNode<>(1, new ListNode<>(1000000000,
                        new ListNode<>(-1000000000,
                                new ListNode<>(-1000000000,
                                        new ListNode<>(1000000000,
                                                new ListNode<>(1))))));
        System.out.println(isListPalindrome.apply(testList) + " ---> Should be true");

    }

    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        ListNode(T x, ListNode<T> nextNode) {
            value = x;
            next = nextNode;
        }

        T value;
        ListNode<T> next;

    }


}
