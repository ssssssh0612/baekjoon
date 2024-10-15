package BaekJoon.DataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 문자열폭발_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            stack.push(ch);
            if (stack.size() >= b.length()) {
                boolean flag = true;
                for (int j = 0; j < b.length(); j++) {
                    if (stack.get(stack.size() - b.length() + j) != b.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag && !stack.isEmpty()) {
                    for (int j = 0; j < b.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stack.size(); i++) {
                sb.append(stack.get(i));
            }
            System.out.println(sb);
        }
    }
}
