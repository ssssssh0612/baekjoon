package BaekJoon.BackTracking;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 감소하는_수_1038 {
    static int a;
    static long[] arr = new long[500001];
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        if(a >= 10 && a <1023){
            for (int i = 0; i <= 9; i++) {
                arr[index] = index;
                index++;
            }
            for (int i = 1; i < 10; i++) {
                int[] numbers = new int[i + 1];
                boolean[] visited = new boolean[10];
                backTracking(0, numbers, visited, 10);
            }
        }else if(a >= 0 && a < 10){
            for (int i = 0; i <= 9; i++) {
                arr[i] = i;
            }
        } else if(a >= 1023){
            System.out.println(-1);
            return;
        }
        System.out.println(arr[a]);
    }
    public static void backTracking(int depth, int[] numbers, boolean[] visited, int number){
        if(depth == numbers.length){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numbers.length; i++) {
                sb.append(numbers[i]).append("");
            }
            arr[index] = Long.parseLong(sb.toString());
            index++;
            return;
        }
        for(int i = 0; i <= 9; i++) {
            if(i < number){
                numbers[depth] = i;
                backTracking(depth+1, numbers, visited, i);
            }
        }
    }
}
