package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오셀로_재배치_13413 {
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            step(br);
        }
        System.out.println(result);
    }
    public static void step(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[] arr1 = new int[2];
        int[] arr2 = new int[2];
        for (int i = 0; i < str1.length(); i++) {
            // 서로 다른 부분 찾기
            // 0 w
            // 1 b
            if(str1.charAt(i) != str2.charAt(i)){
                if(str1.charAt(i) == 'W'){
                    arr1[0]++;
                }else{
                    arr1[1]++;
                }

                if(str2.charAt(i) == 'W'){
                    arr2[0]++;
                }else{
                    arr2[1]++;
                }

            }
        }
        int max = Math.max(arr1[0],arr1[1]);
        int min = Math.min(arr1[0],arr1[1]);

        int count = min;
        count += max - min;
        result.append(count).append("\n");
    }
}
