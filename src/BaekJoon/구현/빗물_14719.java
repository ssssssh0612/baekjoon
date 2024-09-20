package BaekJoon.구현;

import java.util.Scanner;

public class 빗물_14719 {
    static int y;
    static int x;
    static int[][] graph;
    // 제일 오른쪽으로 가기, 제일 왼쪽으로 가기
    static int[] dx = {1,-1};
    static int[] dy = {0,0};
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        graph = new int[y][x];

        for (int i = 0; i < x; i++) {
            int a = sc.nextInt();
            for (int j = y-1; j >= 0 ; j--) {
                if( a > 0 ){
                    graph[j][i] = 1;
                    a--;
                }else{
                    break;
                }
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if( graph[i][j] == 0){
                    checkingWater(i,j);
                }
            }
        }
        System.out.println(result);



    }
    public static void checking(){
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }

    public static void checkingWater(int nowY, int nowX){
        boolean flag1 = false;
        boolean flag2 = false;
        // 제일 오른쪽으로 쭉 가보기
        int checking1 = nowX;
        int checking2 = nowX;
        while(checking1 >=0 && checking1 < x){
            checking1 = checking1 + dx[0];
            if((checking1 >=0 && checking1 < x) && graph[nowY][checking1] == 1){
                flag1 = true;
                break;
            }else if(!(checking1 >=0 && checking1 < x)){
                break;
            }
        }

        while(checking2 >=0 && checking2 < x){
            checking2 = checking2 + dx[1];
            if((checking2 >=0 && checking2 < x) && graph[nowY][checking2] == 1){
                flag2 = true;
                break;
            }else if(!(checking2 >=0 && checking2 < x)){
                break;
            }
        }
        if( flag1 && flag2 ){
            result++;
        }
    }
}
