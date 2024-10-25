package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 진기의_최고급_붕어빵_1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            // m초의 시간을 들이면 k개의 붕어빵을 만들 수 있다
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int length = arr[arr.length - 1];
            int boongA = 0;
            int index = 0;
            boolean flag = false;
            if(arr[0] == 0){
                System.out.println("#"+(i+1)+" "+"Impossible");
                continue;
            }
            for (int j = 1; j <= length; j++) {
                if(j%m == 0){
                    boongA += k;
                }
                if(arr[index] == j){
                    boongA--;
                    index++;
                    if(boongA < 0){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                System.out.println("#"+(i+1)+" "+"Impossible");
            }else{
                System.out.println("#"+(i+1)+" "+"Possible");
            }
        }
    }
}
