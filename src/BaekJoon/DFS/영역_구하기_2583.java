package BaekJoon.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 영역_구하기_2583 {
    static boolean[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int countCase;
    static int fucking;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        int count = sc.nextInt();
        graph = new boolean[y][x];
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            // a-> x b-> y
            // c-> x d-> y
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            for (int j = b; j <=  d - 1; j++) {
                for (int k = a; k <= c - 1; k++) {
                    graph[j][k] = true;
                }
            }
        }

        for (int i = 0; i < y ; i++) {
            for (int j = 0; j < x ; j++) {
                if(!graph[i][j]) {
                    list.add(dfs(i,j));
                    countCase++;
                    fucking = 0;
                }
            }
        }
        System.out.println(countCase);
        Collections.sort(list);
        for(Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
    public static int dfs(int y, int x) {
        fucking++;
        graph[y][x] = true;
        for (int i = 0; i < 4; i++) {
            if(y + dy[i] >= 0 && x + dx[i] >= 0 &&
                    y + dy[i] < graph.length && x + dx[i] < graph[0].length
                    && !graph[y + dy[i]][x + dx[i]]) {
                dfs(y + dy[i], x + dx[i]);
            }
        }
        return fucking;
    }
    public static void bfs(){

    }
}
