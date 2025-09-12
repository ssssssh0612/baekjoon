package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용돈관리_6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[Integer.parseInt(st.nextToken())];
        int count = Integer.parseInt(st.nextToken());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int start = 1;
        int end = 1_000_000_000;
        while(start < end){
            int mid = (start + end)/2;
            long value = checking(arr, mid);
            if(value <= count){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
    // 1                                     10,000
    public static long checking(int[] arr, int money){
        // count 횟수가 더 많으면 가격을 늘리고
        // count 횟수가 더 적으면 가격을 줄이고 같아도 가격을 더 줄이고
        long count = 1;
        int nowMoney = money;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= nowMoney){
                nowMoney -= arr[i];
            }else{
                count++;
                nowMoney = money;
                if(nowMoney < arr[i]){
                    // -1을 입력하면 어쨋든 돈이 모자르다는걸 보내주는것임
                    return Integer.MAX_VALUE;
                }
                nowMoney -= arr[i];
            }
        }
        return count;
    }
}
