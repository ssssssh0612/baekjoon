package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] arr = new int[number];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < number; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int i = 0 ; i < arr.length; i++){
            int nowNumber = arr[i];
            int count = 1;
            int pointer = i + 1;
            while(pointer < arr.length){
                if(nowNumber < arr[pointer]){
                    nowNumber = arr[pointer];
                    pointer++;
                    count++;
                }else{
                    pointer++;
                }
            }
            max = Math.max(count, max);
        }
        System.out.println(max);
    }
}
