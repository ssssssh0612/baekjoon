package BaekJoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합_5642 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = arr[0];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if(j == 0){
                    max = arr[j];
                }else if(arr[j] > max){
                    max = arr[j];
                }
            }
            int start = 0;
            int end = 0;
            int sum = arr[0];
            while (start < n && end < n) {
                if( start == end ){
                    end++;
                    if(end < n){
                        sum += arr[end];
                        if(max < sum){
                            max = sum;
                        }
                    }
                    continue;
                }
                if(sum >= max){
                    end++;
                    if(end < n){
                        sum += arr[end];
                        if(max < sum){
                            max = sum;
                        }
                    }
                }else{
                    sum = sum - arr[start];
                    start++;
                    if(max < sum){
                        max = sum;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
