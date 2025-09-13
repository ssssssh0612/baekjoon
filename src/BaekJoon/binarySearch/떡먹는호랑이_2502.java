package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 떡먹는호랑이_2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 0});
        list.add(new int[]{0, 1});
        for (int i = 2; i < length; i++) {
            int[] arr=  new int[2];
            arr[0] = list.get(i - 2)[0] + list.get(i - 1)[0];
            arr[1] = list.get(i - 2)[1] + list.get(i - 1)[1];
            list.add(arr);
        }
        int[] arr = list.get(length - 1);
        int result1 = 0;
        int result2 = 0;
        for (int i = 1; i <= 100_000; i++) {
            boolean flag = false;
            int num1 = arr[0] * i;
            result1 = i;
            int resultNum = num - num1;
            for (int j = 1; j <= 100_000; j++) {
                int num2 = arr[1] * j;
                if(resultNum == num2){
                    flag= true;
                    result2 = j;
                    break;
                }else if(resultNum > num2){
                    continue;
                }else{
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(result1);
        System.out.println(result2);
    }
}
