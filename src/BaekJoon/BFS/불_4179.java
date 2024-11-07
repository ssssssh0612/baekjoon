package BaekJoon.BFS;

import java.util.Scanner;

public class 불_4179 {
    static int y;
    static int x;
    static int[][] graph;
    static int[] jihunPos = new int[2];
    static int[] firePos = new int[2];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            String a = sc.next();
            for (int j = 0; j < x; j++) {
                if(a.charAt(j) == '#'){
                    graph[i][j] = 1;
                }else if(a.charAt(j) == '.'){
                    graph[i][j] = 0;
                }else if(a.charAt(j) == 'F'){
                    graph[i][j] = -1;
                    firePos[0] = i;
                    firePos[1] = j;
                }else if(a.charAt(j) == 'J'){
                    jihunPos[0] = i;
                    jihunPos[1] = j;
                }
            }
        }
    }
}
