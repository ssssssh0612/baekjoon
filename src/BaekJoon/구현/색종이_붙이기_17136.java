package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_붙이기_17136 {
    static int result = Integer.MAX_VALUE;
    static int[][] graph = new int[10][10];
    static int[] arr = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1; i < arr.length; i++){
            arr[i] = 5;
        }
        for(int i = 0 ; i < 10 ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 10; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTracking(0,0, 0);
        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
    public static boolean checking(int y, int x, int number){
        // 현재 바뀔 수 있는지 없는지 체크하기
        int endY = y + number;
        int endX = x + number;
        if(y + number > 10){
            return false;
        }
        if(x + number > 10){
            return false;
        }

        for(int i = y ; i < endY; i++){
            for(int j = x; j < endX; j++){
                if(graph[i][j] == 0){
                    return false;
                }
            }
        }

        return true;
    }
    public static void checkingGraph(int y, int x , int k){
        System.out.println(" startY = " + y + " startX = " + x + " k = " + k);
        for(int i = 0 ; i < 10 ; i ++){
            for(int j = 0 ; j < 10 ; j ++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void backTracking(int startY, int startX, int number){
        for(int i = 0; i < 10 ; i++){
            for(int j = 0; j < 10; j++){
                if(graph[i][j] == 1){
                    // 1이면 이중에 하나 골라서 바꿔주고 다시 백트래킹
                    for(int k = 1; k < arr.length; k++){
                        if(arr[k] > 0 && checking(i, j, k)){
                            arr[k]--;
                            adjust(i,j,k);
                            backTracking(i,j,number + 1);
                            cancel(i,j,k);
                            arr[k]++;
                        }
                    }
                    return;
                }
            }
        }

        if(checkingResult()){
            result = Math.min(result, number);
        }

    }

    private static boolean checkingResult() {
        for(int i = 0 ; i < 10 ; i ++){
            for(int j = 0 ; j < 10 ; j++){
                if(graph[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void adjust(int y, int x, int number){
        int endY = y + number;
        int endX = x + number;

        for(int i = y ; i < endY; i++){
            for(int j = x; j < endX; j++){
                graph[i][j] = 0;
            }
        }
    }
    public static void cancel(int y, int x, int number){
        int endY = y + number;
        int endX = x + number;

        for(int i = y ; i < endY; i++){
            for(int j = x; j < endX; j++){
                graph[i][j] = 1;
            }
        }
    }
}
