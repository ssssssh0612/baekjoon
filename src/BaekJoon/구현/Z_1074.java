package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {
    static int y;
    static int x;
    static int count;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int number = 1;
        for (int i = 0; i < n; i++) {
            number = number * 2;
        }
        partition(0, 0, number);
        System.out.println(count);
    }

    public static void partition(int startY, int startX, int size) {
        if(size == 1){
            return;
        }
        int newSize = size / 2;
        int area = newSize * newSize;
        // 현재 기준 위치에서 내가 찾고자 하는 위치가 어디 사분면에 위치하는가

        if( startY + newSize > y && startX + newSize > x){
            partition(startY, startX, newSize);
        }else if( startY + newSize > y && startX + newSize <= x){
            count += area;
            partition(startY, startX + newSize, newSize);
        }else if( startY + newSize <= y && startX + newSize > x){
            count += area * 2;
            partition(startY + newSize , startX, newSize);
        }else{
            count += area * 3;
            partition(startY + newSize , startX + newSize, newSize);
        }
        // 1사분면이면 area를 안곱해도됨
        // 2사분면이면 area를 한번 더해주기
        // 3사분면이면 area를 두번
        // 4사분면이면 area를 세번
    }
}
