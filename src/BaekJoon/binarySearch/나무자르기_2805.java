package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        long max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if( max < arr[i]){
                max = arr[i];
            }
        }
        int result = 0 ;
        long start = 0;
        while(start <= max){
            long mid = (start + max) / 2;
            long checkCount = 0;
            for(int i = 0 ; i < arr.length; i++){
                if(mid < arr[i]){
                    checkCount += (arr[i] - mid);
                }
            }

            if( checkCount >= count ){
                start = mid + 1;
            }else{
                max = mid - 1;
            }
        }
        System.out.println(max);
    }
}
