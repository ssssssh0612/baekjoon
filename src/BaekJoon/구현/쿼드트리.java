package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쿼드트리 {
    static int[][] graph;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < n ; j ++){
                int num = str.charAt(j) - '0';
                if(num == 0){
                    graph[i][j] = 0;
                }else{
                    graph[i][j] = 1;
                }
            }
        }
        step(graph[0][0], n, 0, 0);
        System.out.println(sb.toString());
    }
    public static void step(int num, int length, int startY, int startX){
        for(int i = startY; i < startY + length; i ++){
            for(int j = startX; j < startX + length; j ++){
                // 만약 현재 숫자와 다른게 나온다면
                if(num != graph[i][j]){
                    sb.append("(");
                    step(graph[startY][startX], length / 2, startY, startX);
                    step(graph[startY][startX + length / 2], length / 2, startY, startX + length / 2);
                    step(graph[startY + length / 2][startX], length / 2, startY + length / 2, startX);
                    step(graph[startY + length / 2][startX + length / 2], length / 2, startY + length / 2, startX + length / 2);
                    sb.append(")");
                    return;
                }
            }
        }

        sb.append(num);


    }

}
