package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어디에단어가들어갈수있을까 {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
//            System.out.println(k);
            int[][] graph = new int[n + 2][n + 2];
            for (int j = 1; j < n + 1; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 1; l < n + 1; l++) {
                    int number = Integer.parseInt(st.nextToken());
                    graph[j][l] = number;
                }
            }
            for (int j = 1; j < graph.length - 1; j++) {
                for (int l = 1; l < graph[0].length - 1; l++) {
                    System.out.print(graph[j][l]+" ");
                }
                System.out.println();
            }
            System.out.println("?");
            checking(graph,k);
            System.out.println(result);

        }

    }

    public static boolean checking(int y, int x, int yLength, int xLength) {
        return y >= 0 && x >= 0 && yLength > y && xLength > x;
    }

    public static void checking(int[][] graph, int k) {
        for (int i = 1; i < graph.length - 1; i++) {
            for (int j = 1; j < graph[0].length - 1; j++) {
                if (graph[i][j] == 1) {
                    if(checking(graph, i, j, k)){
                        result++;
                    }
                }
            }
        }
    }

    public static boolean checking(int[][] graph, int y, int x, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (checking(y,(x+i), graph.length, graph[0].length) && graph[y][x + i] == 1) {
                count++;
            }
        }
        if (count == k) {
            // 0이거나 범위안에 없어야함
            if (graph[y][x - 1] == 0 && graph[y][x + k] == 0) {
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }
    }
}
