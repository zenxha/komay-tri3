package Week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CustomStack {
    private static void reverse(Queue<Integer> queue) {
        int n = queue.size();
        Stack<Integer> stack = new Stack<>();
        // Remove all the elements from queue and push them to stack
        for (int i = 0; i < n; i++) {
            int curr = queue.poll();
            stack.push(curr);
        }
        // Pop out elements from the stack and push them back to queue
        for (int i = 0; i < n; i++) {
            int curr = stack.pop();
            queue.add(curr);
        }
        // Print the reversed queue
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Example 1
        Queue<Integer> og = new LinkedList<>();
        og.add(1);
        og.add(2);
        og.add(3);
        System.out.print("Before reverse order of queue: " + og + "\nAfter reverse order of queue: ");
        reverse(og);
        System.out.print("\n");
    }
}