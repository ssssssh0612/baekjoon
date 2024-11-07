package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 뱀_3190 {
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
    public static void input(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        int appleCount = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < appleCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            graph[y][x] = 1;
        }
        int moveCount = Integer.parseInt(br.readLine());
        List<int[]> moveList = new ArrayList<>();
        for(int i = 0 ; i < moveCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            char ch = str.charAt(0);
            int dir = 0;
            if(ch == 'D') {
                dir = 1;
            }
            moveList.add(new int[]{second, });
        }
    }
}
