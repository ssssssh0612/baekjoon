package BaekJoon.swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최빈수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++){
            int testCaseNumber = Integer.parseInt(br.readLine());
            int[] number = new int[101];
            int result = input(br, number);
            System.out.println("#" + (testCaseNumber) + " " + result);
        }
    }
    public static int input(BufferedReader br, int[] arr) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 1000; i++){
            int number = Integer.parseInt(st.nextToken());
            arr[number]++;
        }
        int maxValue = 0;
        for(int i = 0; i <= 100; i++){
            if( maxValue < arr[i]){
                maxValue = arr[i];
            }
        }
        int maxIndex = 0 ;
        for(int i = 0; i <= 100; i++){
            if( maxValue == arr[i]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
