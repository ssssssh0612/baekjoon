package BaekJoon.DataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            boolean flag = true;
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '[') {
                    stack.add('[');
                } else if (ch == '(') {
                    stack.add('(');
                } else if (ch == ')') {
                    if(stack.isEmpty()){
                        flag = false;
                        System.out.println("no");
                        break;
                    }else{
                        if(stack.peek() == '('){
                            stack.pop();
                        }else{
                            flag = false;
                            System.out.println("no");
                            break;
                        }
                    }
                } else if (ch == ']') {
                    if(stack.isEmpty()){
                        flag = false;
                        System.out.println("no");
                        break;
                    }else{
                        if(stack.peek() == '['){
                            stack.pop();
                        }else{
                            System.out.println("no");
                            flag = false;
                            break;
                        }
                    }
                }
            }
//            System.out.println(stack);
            if (stack.isEmpty() && flag) {
                System.out.println("yes");
            } else if (!stack.isEmpty() && flag) {
                System.out.println("no");
            }
        }
    }
}
