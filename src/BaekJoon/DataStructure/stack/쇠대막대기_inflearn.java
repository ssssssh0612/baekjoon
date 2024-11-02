package BaekJoon.DataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠대막대기_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.add(ch);
            } else {
                // 그렇지 않다면 문자열의 바로 앞부분을 검사해보자
                char check = str.charAt(i - 1);
                if (check == '(') {
                    // 여는 괄호를 만났다면.. 스택에서 하나빼기
                    stack.pop();
                    // 스택에 존재하는 괄호 모두 더해주기
                    result += stack.size();
                } else {
                    // 닫는 괄호를 만났다면.. 스택에서 하나 빼고 1 더해주기
                    stack.pop();
                    result += 1;
                }
            }
//            System.out.println(stack);
        }
        System.out.println(result);
    }
}
