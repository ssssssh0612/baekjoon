package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의_합_2_2003 {
    static int a;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr = new int[a];
        for (int i = 1; i <= a; i++) {
            nujuk(i);
        }
    }
    public static void nujuk(int length){
        int start = 0;
        int end = length-1;
        while(start< a && end < a){
            int total = 0;
            for(int i = start; i <= end; i++){

            }
        }
    }
}
