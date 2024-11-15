package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++){
            int[] arr = input(br);
            // 증가하는 경우 계속 증가시키다가 감소되는 구간이 나오면
            int start = 0;
            int end = 0;




        }
    }
    public static int[] input(BufferedReader br) throws IOException {
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < length; i++ ){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    public static void step(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            for(int j = 0 ; j < arr.length - 1; j++){

            }
        }
    }
}
