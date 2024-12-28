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
        for(int i = arr.length - 1; i >= 0; i --){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                result[stack.pop()] = i + 1;
            }
            stack.push(i);
        }
        for(int i = 0 ; i < result.length; i++){
            System.out.print(result[i] +" ");
        }
    }
}
