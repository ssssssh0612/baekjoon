package BaekJoon.DataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = new int[a];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                int peekNum = arr[stack.peek()];
                int newNum = arr[i];
                if (peekNum == newNum) {
                    stack.add(i);
                } else if (peekNum > newNum) {
                    stack.add(i);
                } else {
                    while (!stack.isEmpty() && peekNum < newNum) {
                        int index = stack.pop();
                        result[index] = i + 1;
                        if (!stack.isEmpty()) {
                            peekNum = arr[stack.peek()];
                        }

                    }
                    stack.add(i);
                }
            } else {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = 0;
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
