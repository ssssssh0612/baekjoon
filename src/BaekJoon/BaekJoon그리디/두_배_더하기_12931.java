package BaekJoon.BaekJoon그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두_배_더하기_12931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2로 안나눠지면 1을 빼주기
        // 모두가 0이게 되면 종료
        int count = 0;

        while(true){
            // 홀수면 -1 빼기
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] > 0 && arr[i] % 2 != 0){
                    arr[i] = arr[i] - 1;
                    count++;
                }
            }
            if(checking(arr)){
                break;
            }
            // 모두 짝수로 만들고 2로 나누기
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] > 0 && arr[i] % 2 == 0){
                    arr[i] = arr[i] / 2;
                }
            }
            count++;
        }
        System.out.println(count);
    }
    public static boolean checking(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
