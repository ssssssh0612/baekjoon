package BaekJoon.Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선택정렬_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < a; i++) {
            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;
            for (int j = i; j < a; j++) {
                if(minValue > arr[j]){
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = minValue;
            arr[minIndex] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
