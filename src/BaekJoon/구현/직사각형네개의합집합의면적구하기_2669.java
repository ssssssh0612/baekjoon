package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형네개의합집합의면적구하기_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] graph = new boolean[101][101];
        for(int i = 0 ; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            for(int j = startY ; j < endY; j++){
                for(int k = startX ; k < endX; k++){
                    graph[j][k] = true;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < graph.length; i++){
            for(int j = 0 ; j < graph.length; j++){
                if(graph[i][j]){
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
