package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_만들기_2630 {
    static int blue = 0;
    static int white = 0;
    static int[][] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j ++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0,0,arr.length);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void partition(int startY, int startX, int size){
        int startColor = arr[startY][startX];
        if(size == 1){
            if(startColor == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }else{
            boolean flag = false;
            for(int i = startY ; i < startY + size; i++){
                for(int j = startX ; j < startX + size; j++){
                    if(startColor != arr[i][j]){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }
            if(!flag){
                if(startColor == 0){
                    white++;
                }else{
                    blue++;
                }
                return;
            }
        }
        // 0,0
        int newSize = size / 2;

        partition(startY, startX, newSize);
        partition(startY + newSize, startX, newSize);
        partition(startY + newSize, startX + newSize, newSize);
        partition(startY, startX + newSize, newSize);
    }
}
