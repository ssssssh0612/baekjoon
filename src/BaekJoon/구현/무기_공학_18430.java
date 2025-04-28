package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무기_공학_18430 {
    static int result = 0;
    static int[][] graph;
    static boolean[][] visited;
    static int fuck = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        visited = new boolean[y][x];

        for(int i = 0; i < y ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < x; j ++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
            }
        }
        backTracking(0,0,0);
        System.out.println(result);

    }
    public static void checkingGraph(){
        System.out.println();
        for(int i = 0; i < graph.length; i++){
            for(int j = 0 ; j < graph[0].length; j++){
                if(!visited[i][j]){
                    System.out.print(0 + " ");
                }else{
                    System.out.print(1 + " ");
                }
            }
            System.out.println();
        }
    }
    public static void backTracking(int y, int x, int count){
        result = Math.max(result, count);

        for (int i = y; i < graph.length; i++) {
            for (int j = (i == y ? x : 0); j < graph[0].length; j++) {
                if (!visited[i][j]) {
                    for (int k = 0; k < 4; k++) {
                        if (checking(i, j, k)) {
                            // 무기 설치
                            if (k == 0) {
                                int num = graph[i][j - 1] + graph[i][j] * 2 + graph[i + 1][j];
                                visited[i][j - 1] = visited[i][j] = visited[i + 1][j] = true;
                                backTracking(i, j, count + num);
                                visited[i][j - 1] = visited[i][j] = visited[i + 1][j] = false;
                            }
                            else if (k == 1) {
                                int num = graph[i][j + 1] + graph[i][j] * 2 + graph[i + 1][j];
                                visited[i][j + 1] = visited[i][j] = visited[i + 1][j] = true;
                                backTracking(i, j, count + num);
                                visited[i][j + 1] = visited[i][j] = visited[i + 1][j] = false;
                            }
                            else if (k == 2) {
                                int num = graph[i - 1][j] + graph[i][j] * 2 + graph[i][j + 1];
                                visited[i - 1][j] = visited[i][j] = visited[i][j + 1] = true;
                                backTracking(i, j, count + num);
                                visited[i - 1][j] = visited[i][j] = visited[i][j + 1] = false;
                            }
                            else {
                                int num = graph[i - 1][j] + graph[i][j] * 2 + graph[i][j - 1];
                                visited[i - 1][j] = visited[i][j] = visited[i][j - 1] = true;
                                backTracking(i, j, count + num);
                                visited[i - 1][j] = visited[i][j] = visited[i][j - 1] = false;
                            }
                        }
                    }
                }
            }
        }
    }


    // 진행이 가능한지
    public static boolean checking(int y, int x, int number){
        // 0번 ㄱ
        if(number == 0){
            if(checking(y, x - 1) &&
                    checking(y,x) && checking(y + 1, x)){
                return true;
            }else{
                return false;
            }
        // 1번 ㄱ 뒤집음
        }else if(number == 1){
            if(checking(y, x + 1) &&
                    checking(y,x) && checking(y + 1, x)){
                return true;
            }else{
                return false;
            }
        // 2번 ㄴ
        }else if(number == 2){
            if(checking(y - 1, x) &&
                    checking(y,x) && checking(y, x + 1)){
                return true;
            }else{
                return false;
            }
        // 3번 ㄴ 뒤집음
        }else{
            if(checking(y, x - 1) &&
                    checking(y,x) && checking(y - 1, x)){
                return true;
            }else{
                return false;
            }
        }
    }

    public static boolean checking(int y, int x){
        return (y >= 0 && y < graph.length && x >= 0 && x < graph[0].length) && (!visited[y][x]);
    }
}
