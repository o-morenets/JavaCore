package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <a href="https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem?isFullScreen=true">...</a>
 */
public class CycleDetection {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        // 1 -> 2 -> 3 -> null (no cycle)
        SinglyLinkedListNode head = new SinglyLinkedListNode(1,
                new SinglyLinkedListNode(2,
                        new SinglyLinkedListNode(3, null)));
        System.out.println(hasCycle(head));

        // 1 -> 2 -> 3 -> 1 (has cycle)
        head = new SinglyLinkedListNode(1,
                new SinglyLinkedListNode(2,
                        new SinglyLinkedListNode(3,
                                null)));
        head.next.next.next = head;
        System.out.println(hasCycle(head));

//        runTests();
    }

    private static void runTests() {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int index = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
            SinglyLinkedListNode temp = llist.head;

            for (int i = 0; i < llistCount; i++) {
                if (i == index) {
                    extra = temp;
                }

                if (i != llistCount-1) {
                    temp = temp.next;
                }
            }

            temp.next = extra;

            boolean result = hasCycle(llist.head);
            System.out.println("result = " + result);

//            bufferedWriter.write(String.valueOf(result ? 1 : 0));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }

    private static boolean hasCycle(SinglyLinkedListNode head) {
//        return hasCycleTwoPointers(head);
        return hasCycleUsingSet(head);
    }

    // Complete the hasCycle function below.

    static boolean hasCycleTwoPointers(SinglyLinkedListNode head) {
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    static boolean hasCycleUsingSet(SinglyLinkedListNode head) {
         Set<SinglyLinkedListNode> visited = new HashSet<>();

         while (head != null) {
             if (!visited.add(head)) {
                 return true;
             }
             head = head.next;
         }

         return false;
    }

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    private static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        private SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }

        public SinglyLinkedListNode(int data) {
            this(data, null);
        }
    }

    private static class SinglyLinkedList {
        private SinglyLinkedListNode head;

        public void insertNode(int item) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(item);
            SinglyLinkedListNode lastNode = head;
            while (lastNode != null && lastNode.next != null) {
                lastNode = lastNode.next;
            }
            if (lastNode == null) {
                head = newNode;
            } else {
                lastNode.next = newNode;
            }
        }
    }
}
