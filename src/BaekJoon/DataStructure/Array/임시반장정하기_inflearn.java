package BaekJoon.DataStructure.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 임시반장정하기_inflearn {
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][5];
        StringTokenizer st;
        int[] student = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            for (int j = 0; j < 5; j++) {
                int number = graph[i][j];
                for (int k = 0; k < n; k++) {
                    if(graph[k][j] == number && i != k){
                        visited[k] = true;
                    }
                }
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(visited[j]){
                   count++;
                }
            }
//            System.out.println(count);
            student[i] = count;
        }
        //5
        //2 3 1 7 3
        //4 1 9 6 8
        //5 5 2 4 4
        //6 5 2 6 7
        //8 4 2 2 2

        int maxNum = 0;
        int maxStudent = 0;
        for (int i = 0; i < student.length; i++) {
            if ( i == 0 ){
                maxNum = student[i];
                maxStudent = i;
            }else{
                if( maxNum < student[i]){
                    maxNum = student[i];
                    maxStudent = i;
                }
            }
        }

        for (int i = 0; i < student.length; i++) {
//            System.out.println(student[i]);
        }
        System.out.println(maxStudent+1);
    }
}
