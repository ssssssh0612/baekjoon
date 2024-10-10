package BaekJoon.DataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_2_28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a==1){
                int newNumber = Integer.parseInt(st.nextToken());
                stack.add(0,newNumber);
            }else if(a==2){
                if(!stack.isEmpty()){
                    int popNumber = stack.pop();
                    sb.append(popNumber);
                    sb.append('\n');
                }else{
                    sb.append(-1);
                    sb.append('\n');
                }
            }else if(a==3){
                sb.append(stack.size());
                sb.append('\n');
            }else if(a==4){
                if(!stack.isEmpty()){
                    sb.append(0);
                    sb.append('\n');
                }else{
                    sb.append(1);
                    sb.append('\n');
                }
            }else{
                if(!stack.isEmpty()){
                    sb.append(stack.peek());
                    sb.append('\n');
                }else{
                    sb.append(-1);
                    sb.append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }
}
