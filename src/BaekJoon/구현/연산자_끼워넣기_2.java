package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기_2 {
    static int[] number;
    static int[] count = new int[4];
    static int[] arr;
    static int check;
    static int resultMax = Integer.MIN_VALUE;
    static int resultMin = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 모든 경우의 수를 어떻게 구할까 ?
        int length = Integer.parseInt(br.readLine());
        number = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }
        arr = new int[length - 1];

        backTracking(0);
        System.out.println(resultMax);
        System.out.println(resultMin);
    }
    public static void backTracking(int depth){
        if(number.length - 1 == depth){
            int num = number[0];
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == 0){
                    num += number[i + 1];
                }else if(arr[i] == 1){
                    num -= number[i + 1];
                }else if(arr[i] == 2){
                    num *= number[i + 1];
                }else{
                    num /= number[i + 1];
                }
            }
            resultMax = Math.max(resultMax, num);
            resultMin = Math.min(resultMin, num);

            return;
        }
        for (int i = 0; i < 4; i++) {
            if(count[i] != 0){
                count[i]--;
                arr[depth] = i;
                backTracking(depth + 1);
                count[i]++;
            }
        }
    }
}
