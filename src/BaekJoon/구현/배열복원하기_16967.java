package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열복원하기_16967 {
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 겹치는 구간 생각하기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int moveY = Integer.parseInt(st.nextToken());
        int moveX = Integer.parseInt(st.nextToken());
        graph = new int[y + moveY][x + moveX];
        for(int i = 0 ; i < graph.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < graph[0].length; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 현재 겹치는 부분이 어딘지 찾기
        int[][] map = new int[graph.length][graph[0].length];
        for(int i = 0; i < y ; i++){
            for(int j = 0 ; j < x; j++){
                map[i][j]++;
                map[i + moveY][j + moveX]++;
            }
        }
//        checking(map);

        int[][] result = new int[y][x];
        for(int i = 0; i < y ; i++){
            for(int j = 0 ; j < x; j++){
                if(map[i][j] == 1){
                    result[i][j] = graph[i][j];
                }
            }
        }
        for(int i = 0; i < y ; i++){
            for(int j = 0 ; j < x; j++){
                if(map[i + moveY][j + moveX] == 1){
                    result[i][j] = graph[i + moveY][j + moveX];
                }
            }
        }
        // 겹치는 구간 발견하기
        for(int i = 0 ; i < y ; i++){
            for(int j = 0; j < x; j++){
                // 이 구간은 겹치는 구간
                if(result[i][j] == 0 && i - moveY >= 0 && j - moveX >= 0){
                    result[i][j] = graph[i][j] - result[i - moveY][j - moveX];
                }
            }
        }

        for(int i = 0; i < y ; i++){
            for(int j = 0 ; j < x; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void checking(int[][] check){
        for(int i = 0; i < check.length; i++){
            for(int j = 0 ; j < check[0].length; j++){
                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }
    }
}



