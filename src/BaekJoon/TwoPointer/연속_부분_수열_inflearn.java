package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속_부분_수열_inflearn {
        public static void main( String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int sum = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[size];
            for(int i = 0; i < size; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int finalResult = 0;
            int start = 0;
            int end = 0;
            while( start < size && end < size){
                int result = 0;
                for(int i = start; i <= end; i++){
                    result += arr[i];
                }
                if( result == sum){
                    finalResult++;
                    start++;
                }else if(result < sum){
                    end++;
                }else{
                    start++;
                }
            }
            System.out.println(finalResult);
        }
    }
