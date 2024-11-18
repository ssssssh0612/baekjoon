package BaekJoon.Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삽입정렬_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                int number = arr[j];
                int checkNum = arr[j - 1];
                if (number < checkNum) {
                    arr[j] = checkNum;
                    arr[j - 1] = number;
                }
            }
        }

        for(int i = 0 ; i < length ; i ++){
            System.out.print(arr[i]+ " ");
        }
    }
}
