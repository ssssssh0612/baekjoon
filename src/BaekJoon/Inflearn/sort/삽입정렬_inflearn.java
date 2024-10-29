package BaekJoon.Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삽입정렬_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < a; i++) {
            int temp = arr[i];
            for (int j = i-1; j >= 0 ; j--) {
                if(arr[j] > temp) {
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            for (int j = 0; j < a; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < a; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
