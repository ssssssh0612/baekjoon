package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 선분위의점_11663 {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a > max){
                sb.append(0).append("\n");
                continue;
            }

            // a 찾기 a보다 크거나 같은게 존재하는가 ? 없으면 넘기기
            int start = 0;
            int end = arr.length - 1;
            while(start < end){
                int mid = (start + end) / 2;
                int num = arr[mid];
                if(num >= a){
                    end = mid;
                }else{
                    start = mid + 1;
                }
            }
            int startIndex = end;

            start = 0;
            end = arr.length - 1;

            while(start < end){
                int mid = (start + end) / 2;
                int num = arr[mid];
                if(num >= b){
                    end = mid;
                }else{
                    start = mid + 1;
                }
            }
            int endIndex = end;
            System.out.println(startIndex +" " +endIndex);

        }
    }
}


// 0 1 2 3 4 5 6
// 3 1
// 1 3 5
// 2 4