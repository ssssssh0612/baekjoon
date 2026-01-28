package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 도미노_찾기_1553 {
    static int[] dy = {0,1};
    static int[] dx = {1,0};
    static boolean[][] visited = new boolean[8][7];
    static boolean[][] checking = new boolean[7][7];
    static int result = 0 ;
    static int[][] graph = new int[8][7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 7; j++) {
                int num = str.charAt(j) - '0';
                graph[i][j] = num;
            }
        }
        backTracking(0);
        System.out.println(result);
    }
    public static void backTracking(int depth){
        if(depth == 28){
            result++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if(!visited[i][j]){
                    if (checking(i + dy[0], j + dx[0]) && !visited[i + dy[0]][j + dx[0]]) {
                        int num1 = graph[i][j];
                        int num2 = graph[i + dy[0]][j + dx[0]];
                        if(!checking[num1][num2] || !checking[num2][num1]){
                            checking[num1][num2] = true;
                            checking[num2][num1] = true;
                            visited[i][j] = true;
                            visited[i + dy[0]][j + dx[0]] = true;
                            backTracking(depth + 1);
                            checking[num1][num2] = false;
                            checking[num2][num1] = false;
                            visited[i][j] = false;
                            visited[i + dy[0]][j + dx[0]] = false;
                        }

                    }

                    if (checking(i + dy[1], j + dx[1]) && !visited[i + dy[1]][j + dx[1]]) {
                        int num1 = graph[i][j];
                        int num2 = graph[i + dy[1]][j + dx[1]];

                        if(!checking[num1][num2] || !checking[num2][num1]){
                            checking[num1][num2] = true;
                            checking[num2][num1] = true;
                            visited[i][j] = true;
                            visited[i + dy[1]][j + dx[1]] = true;
                            backTracking(depth + 1);
                            checking[num1][num2] = false;
                            checking[num2][num1] = false;
                            visited[i][j] = false;
                            visited[i + dy[1]][j + dx[1]] = false;
                        }
                    }

                    return;
                }
            }
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
