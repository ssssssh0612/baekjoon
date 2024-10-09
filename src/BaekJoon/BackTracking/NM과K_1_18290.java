package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NM과K_1_18290 {
    static List<int[]> list = new ArrayList<>();
    static int[][] graph;
    static boolean[] visited;
    static int[] arr;
    static int k;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                list.add(new int[]{i,j});
            }
        }
        visited = new boolean[list.size()];
        arr = new int[k * 2];
        backTracking(0,0);
        System.out.println(result);
    }
    public static void backTracking(int depth, int number){
        if( k * 2 == depth ){
            for (int i = 0; i < arr.length; i += 2) {
                int Y = arr[i];
                int X = arr[i+1];
                for (int j = 0; j < 4; j++) {
                    int nowY = Y + dy[j];
                    int nowX = X + dx[j];
                    if(checking(nowY,nowX)){
                        for (int l = 0; l < arr.length; l += 2) {
                            if( nowY == arr[l] && nowX == arr[l + 1] ){
                                return;
                            }
                        }
                    }
                }
            }
            int checkResult = 0;
            for (int i = 0; i < arr.length; i+=2) {
                int num = graph[arr[i]][arr[i+1]];
                checkResult += num;
            }
            result = Math.max(result,checkResult);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(!visited[i] && number <= i){
                visited[i] = true;
                arr[depth] = list.get(i)[0];
                arr[depth + 1] = list.get(i)[1];
                backTracking(depth + 2, i);
                visited[i] = false;
            }
        }
    }
    public static boolean checking( int nowY , int nowX ){
        return nowY >= 0 && nowX >= 0 && nowY < graph.length && nowX < graph[0].length;
    }
}
