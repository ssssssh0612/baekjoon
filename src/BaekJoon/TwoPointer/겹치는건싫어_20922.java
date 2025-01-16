package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어_20922 {
    static int RESULT = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] cutLine = new int[100001];

        int[] arr = new int[length];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0 ;
        int end = 0 ;
        cutLine[arr[end]]++;
        end++;
        int result = 1;
        while( end < length ){
            cutLine[arr[end]]++;
            int number = cutLine[arr[end]];
            if(number > count){
            // 현재 추가해준 값이 count 와 같아질때까지
                while(start < end){
                    cutLine[arr[start]]--;
                    start++;
                    result--;
                    if(cutLine[arr[end]] == count){
                        break;
                    }
                }
            }
            result++;
            RESULT = Math.max(result, RESULT);
            end++;
        }
        System.out.println(RESULT);
    }
}
