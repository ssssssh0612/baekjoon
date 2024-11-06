package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기_1654 {
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
//        System.out.println(result - 1);
    }
    public static void input( BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        for(int i = 0 ; i < length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long start = 0;
        long end = arr[arr.length - 1] + 1;
        long mid = 0;
        while(start < end){
            long resultCount = 0;
            mid = (start + end) / 2 ;
            for(int i = 0; i < arr.length; i++){
                resultCount += (arr[i] / mid);
            }
//            System.out.println("mid = "+ mid);
//            System.out.println("resultCount = "+ resultCount);


            if(resultCount < count){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(start-1);
    }
}
