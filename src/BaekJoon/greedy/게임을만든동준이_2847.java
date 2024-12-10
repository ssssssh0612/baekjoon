package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 게임을만든동준이_2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrLength = Integer.parseInt(br.readLine());
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int result = 0 ;
        while(true){
            boolean check = true;
            for (int i = 0; i < arrLength - 1; i++) {
                int number_1 = arr[i];
                int number_2 = arr[i + 1];
                if(number_1 >= number_2){
                    arr[i]--;
                    result++;
                    check = false;
                }
            }

            if(check){
                break;
            }
        }
        System.out.println(result);
    }
}
