package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연구소1의2_14502 {
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);

    }
    public static void input(BufferedReader br) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for(int i = 0 ; i < y; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < x; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static int[][] copyGraph(int[][] graph){
        int[][] newGraph = new int[graph.length][graph[0].length];
        for(int i = 0; i < graph.length; i ++){
            for(int j = 0; j < graph[0].length; j ++){
                newGraph[i][j] = graph[i][j];
            }
        }
        return newGraph;
    }
}
