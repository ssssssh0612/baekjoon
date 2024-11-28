package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윷놀이_2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            int count = 0 ;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int number = Integer.parseInt(st.nextToken());
                if(number == 0){
                    count++;
                }
            }

            if(count == 0){
                System.out.println("E");
            }else if(count == 1){
                System.out.println("A");
            }else if(count == 2){
                System.out.println("B");
            }else if(count == 3) {
                System.out.println("C");
            }else{
                System.out.println("D");
            }
        }
    }
}
