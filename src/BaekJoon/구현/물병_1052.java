package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 물병_1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = n; i <= i + 10_000_000; i++) {
//            count(i);
            if(count(i) <= m){
                System.out.println(i - n);
                return;
            }
        }
        System.out.println(-1);
    }

    public static int count(int n){
        int count = 0;
        while(n >= 1){
            if(n == 1){
                count++;
                break;
            }

            if(n % 2 == 1){
                count++;
            }
            n = n / 2;
        }
//        System.out.println(num + " " + count);
        return count;
    }
}
