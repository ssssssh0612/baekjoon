package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 눈치우기_26215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int time = 0;
        int index = 0;
        while(time <= 1440){
            boolean flag = false;
            for (int i = n - 1; i >= 0; i--) {
                if(arr[i] > 0){
                    index = i;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                break;
            }

            if(index == 0){
                arr[0]--;
                Arrays.sort(arr);
            }else{
                arr[index]--;
                arr[index - 1]--;
                Arrays.sort(arr);
            }
            time++;
        }
        if(time == 1441){
            System.out.println(-1);
        }else{
            System.out.println(time);
        }
    }
}

