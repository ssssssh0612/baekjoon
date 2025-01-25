package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = length - 1;
        long minNumber = Math.abs(arr[start] + arr[end]);
        long result = arr[start] + arr[end];
        int[] resultArr = new int[]{start, end};
        while(start != end){
            if(result >= 0){
                end--;
            }else{
                start++;
            }
            if(start == end){
                break;
            }
            result = arr[start] + arr[end];
            if(minNumber > Math.abs(result)){
                resultArr[0] = start;
                resultArr[1] = end;
                minNumber = Math.abs(result);
            }
        }
        System.out.println(arr[resultArr[0]]+" "+arr[resultArr[1]]);

    }
}
