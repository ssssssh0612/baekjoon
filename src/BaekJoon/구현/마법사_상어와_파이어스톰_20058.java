package BaekJoon.구현;

import java.util.Scanner;

public class 마법사_상어와_파이어스톰_20058 {
    static int[][] graph;
    static int[][] copyGraph;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = numberChecking(sc.nextInt());
        graph = new int[n][n];
        copyGraph = new int[n][n];
        int q = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                copyGraph[i][j] = graph[i][j];
            }
        }


    }



    public static int numberChecking( int number ){
        return (int) Math.pow(2 , number);
    }

    // L을 입력받아서 빙빙 돌리기
    public static void rotate( int numberL ){

        // 0,0 부터 시작해서 계속 돌리기
        // boolean 두개를 기준으로 둘다 false 라면 while문 종료
        // x 기준으로 startX를 더했을때 false 가 나왔다면 flagCol을 기준으로 더했는데도 false가 나오면 while문 종료
        boolean flagRow = true;
        // y 기준으로 startY를 더했을때
        boolean flagCol = true;
        int startY = 0;
        int startX = 0;
        // L을 기준으로 for 문 돌리기
        while ( flagRow && flagCol ){
            for (int i = 0; i < numberChecking(numberL); i++) {
                int number = numberChecking(numberL) - 1;
                for (int j = 0; j < numberChecking(numberL); j++) {
                    graph[startY + number][startX + i] = copyGraph[startY + i][startX + j];
                    number--;
                }
            }



//            graphCheckingX( startX + numberChecking(numberL) );
//            graphCheckingY( startY + numberChecking(numberL) );
//            if( graphCheckingX( startX + numberChecking(numberL)) ){
//
//            } else if ( !graphCheckingX( startX + numberChecking(numberL)) ){
//
//            } else if ( !graphCheckingY( startY + numberChecking(numberL)) && !graphCheckingY()){
//
//            }
        }


    }

    public static boolean graphCheckingX( int x ){
        return x >= 0 && x < n;
    }
    public static boolean graphCheckingY( int y ){
        return y >= 0 && y < n;
    }
}