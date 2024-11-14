package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블로그_21921 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrLength = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        arr = new int[arrLength];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < arrLength; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0 ;
        int end = range - 1;
        // 일단 최대값 찾기
        // 만약 최대값이 0이라면 그냥 SAD
        long sum = 0;
        for(int i = 0 ; i <= end; i++){
            sum += arr[i];
        }
        long max = sum;
        while(end <= arr.length - 1){
            end = end + 1;
            if( end <= arr.length - 1){
                sum += arr[end];
            }else{
                break;
            }
            long number = arr[start];
            sum -= number;
            start++;
            if( sum > max ){
                max = sum ;
            }
        }
//        System.out.println("start = "+ start + " end = "+end);
//        System.out.println(sum);
        if(max == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max);


        start = 0 ;
        end = range - 1;
        // 일단 최대값 찾기
        // 만약 최대값이 0이라면 그냥 SAD
        sum = 0;
        for(int i = 0 ; i <= end; i++){
            sum += arr[i];
        }
        long maxCount = 0 ;

        if(sum == max){
            maxCount++;
        }
        while(end <= arr.length - 1){
            end = end + 1;
            if( end < arr.length){
                sum += arr[end];
            }else{
                break;
            }
            long number = arr[start];
            sum -= number;
            start++;
//            System.out.println("start = "+ start + " end = "+end);
//            System.out.println(sum);
            if( sum == max ){
                maxCount++;
            }
        }
        System.out.println(maxCount);
    }
}
