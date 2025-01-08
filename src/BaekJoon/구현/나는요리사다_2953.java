package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나는요리사다_2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < 5; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxValue = 0;
            for(int j = 0 ; j < 4; j ++){
                maxValue += Integer.parseInt(st.nextToken());
            }
            if(maxValue > max){
                max = maxValue;
                index = i + 1;
            }
        }
        System.out.println(index + " " + max);
    }
}
