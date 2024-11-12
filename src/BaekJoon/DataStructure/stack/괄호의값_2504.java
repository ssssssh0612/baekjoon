package BaekJoon.DataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(!checking(str)){
            System.out.println(0);
            return;
        }

    }
    // 올바른 괄호인지 체크하기
    public static boolean checking(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < str.length(); i ++){
            char ch = str.charAt(i);
            char checkingCh = stack.peek();
            if(ch == '['){
                stack.add('[');
            }else if( ch == '{'){
                stack.add('{');
            }else if( ch == ']' && checkingCh == '['){
                stack.pop();
            }else if( ch == '}' && checkingCh == '{'){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
