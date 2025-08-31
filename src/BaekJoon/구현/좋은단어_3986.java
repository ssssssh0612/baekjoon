package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 좋은단어_3986 {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        count = 0;
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            step(str);
        }
        System.out.print(count);
    }

    static void step(String str) {
        if (str.length() % 2 == 1) {
            return;
        }

        Stack<Character> stack = new Stack<>();

        stack.push(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == str.charAt(i)) {
                stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }

        if (stack.isEmpty()) count++;
    }
}
