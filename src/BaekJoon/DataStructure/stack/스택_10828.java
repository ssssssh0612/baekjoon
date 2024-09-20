package BaekJoon.DataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스택_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //push X: 정수 X를 스택에 넣는 연산이다.
        //pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        //size: 스택에 들어있는 정수의 개수를 출력한다.
        //empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
        //top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> stack = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        for( int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if( a.equals("push")){
                stack.add(Integer.parseInt(st.nextToken()));
            }else if(a.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.get(stack.size()-1));
                    stack.remove(stack.size()-1);
                }
            }else if(a.equals("size")){
                System.out.println(stack.size());
            }else if(a.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else{
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.get(stack.size()-1));
                }
            }
        }
    }
}
