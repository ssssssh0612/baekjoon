package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기19_10994 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println("*");
            return;
        }
        int size = 2 * (n + (n - 1)) - 1;
        int[][] graph = new int[size][size];

        int start = 0;
        int end = size - 1;
        int number = 1;
        while(true){
            if(start == end){
                graph[start][end] = 1;
                break;
            }

            for (int i = start; i <= end; i++) {
                graph[start][i] = number;
                graph[i][start] = number;
                graph[end][i] = number;
                graph[i][end] = number;
            }

            if(number == 1){
                number = 0;
            }else{
                number = 1;
            }
            start++;
            end--;


        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if(graph[i][j] == 1){
                    sb.append("*");
                }else{
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

//*****
//*   *
//* * *
//*   *
//*****
// 0,0 0,1 0,2 0,3 0,4
// 1,0 1,1 2,1 3,1 1,4
// 2,0 1,2 2,2 3,2 2,4
// 3,0 1,3 2,3 3,3 3,4
// 4,0 4,1 4,2 4,3 4,4
