package BaekJoon.DataStructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 괄호_9012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> str = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            str.add(sc.next());
        }
        for (int i = 0; i < str.size(); i++) {
            Stack<String> stack = new Stack<>();
            boolean flag = true;
            for (int j = 0; j < str.get(i).length(); j++) {
                if(str.get(i).charAt(j)=='('){
                    stack.push("(");
                } else if(str.get(i).charAt(j)==')' && stack.isEmpty()){
                    System.out.println("NO");
                    flag = false;
                    break;
                } else if(str.get(i).charAt(j)==')' && !stack.isEmpty()){
                    stack.pop();
                }
            }
            if(!stack.isEmpty() && flag){
                System.out.println("NO");
            }else if( stack.isEmpty() && flag){
                System.out.println("YES");
            }
        }
    }
}
