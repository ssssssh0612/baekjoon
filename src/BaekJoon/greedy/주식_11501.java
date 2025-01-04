package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < testCase; i++){
            int[] arr = input(br);
            sb.append(result(arr)).append("\n");
        }
        System.out.println(sb);
    }

    public static int[] input(BufferedReader br) throws IOException {
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    public static long result(int[] arr){
        long result = 0;
        // 입력받은 arr 의 최대값은 맨 마지막 값으로 정함
        int max = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0 ; i --){
            int number = arr[i];
            if( number > max ){
                max = number;
            }else{
                result += max - number;
            }
        }
        return result;
    }
}

