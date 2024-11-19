package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 소프티어모의테스트 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static List<Integer> list = new ArrayList<>();
    static int[][] graph ;
    static boolean[][] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        step();
        System.out.println(list.size());
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
    public static void input(BufferedReader br ) throws IOException{
        int length = Integer.parseInt(br.readLine());
        graph = new int[length][length];
        visited = new boolean[length][length];
        for(int i = 0; i < length ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < length ; j ++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void step(){
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph.length; j ++){
                if(!visited[i][j] && graph[i][j] == 1){
                    count++;
                    visited[i][j] = true;
                    dfs(i,j);
                    list.add(count);
                    count = 0 ;
                }
            }
        }
    }
    public static boolean checking(int y , int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }
    public static void dfs(int y, int x){
        for(int i = 0 ; i < 4; i ++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(checking(nextY,nextX) && !visited[nextY][nextX] && graph[nextY][nextX] == 1){
                visited[nextY][nextX] = true;
                dfs(nextY,nextX);
                count++;
            }
        }
    }
}
