package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int count = 1;
        int up = 6;
        int nowNumber = 1;
        if( a == 1){
            System.out.println(1);
            return;
        }
        while(true){
            if(nowNumber <= a && a <= nowNumber + up ){
                count++;
                System.out.println(count);
                return;
            }
            nowNumber += up;
            up += 6;
            count++;
        }
    }
}
