package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZOAC3_23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 세로 계산
        int startNumY = 1;
        int startNumX = 1;
        int countY = 1;
        int countX = 1;
        while(startNumY <= y){
            if(startNumY + n + 1 > y){
                break;
            }
            startNumY = startNumY + n + 1;
            countY++;
        }
        while(startNumX <= x){
            if(startNumX + m + 1 > x){
                break;
            }
            startNumX = startNumX + m + 1;
            countX++;
        }
        if(y == 1 && x == 1){
            System.out.println(1);
        }else{
            System.out.println(countX*countY);
        }
    }
}
