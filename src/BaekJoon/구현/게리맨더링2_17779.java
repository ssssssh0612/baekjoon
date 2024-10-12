package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 게리맨더링2_17779 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] graph;
    static int n;
    static int RESULT = Integer.MAX_VALUE;
    static int fiveResult = 0;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 2][n + 2];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        checking(graph);

        for (int i = 1; i <= n - 2; i++) { // i 는 y
            for (int j = 2; j <= n; j++) { // j 는 x
                boundary(i, j);
            }
        }

        Collections.sort(list);
        System.out.println(RESULT);
    }

    public static void boundary(int y, int x) {
        // 맨 처음 들어온 숫자가 1,2
        // i가 d1
        // j가 d2
        for (int i = 1; i <= x - 1; i++) {
            for (int j = 1; j <= n - x; j++) {
                if (i <= n - j - y) {
                    int d1 = i;
                    int d2 = j;
//                    System.out.println("x = " + x + " y = " + y + " d1 = " + d1 + " d2 = " + d2);
                    boolean[][] visited = new boolean[n + 2][n + 2];
                    //(x, y), (x+1, y-1), ..., (x+d1, y-d1)
                    //(x, y), (x+1, y+1), ..., (x+d2, y+d2)
                    //(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
                    //(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
                    int[][] copyGraph = new int[n + 2][n + 2];
                    graphBoundary(y, x, d1, d2, copyGraph, visited);
                    fiveChecking(copyGraph,visited);
                    list.add(fiveResult);
                    graph(y, x, d1, d2, copyGraph, visited);
                    Collections.sort(list);
                    RESULT = Math.min(RESULT, Math.abs(list.get(0)-list.get(4)));
                    list.clear();
                    fiveResult = 0;
                }
            }
        }
    }
    public static void fiveChecking(int[][] copyGraph,boolean[][] visited){
        for (int i = 1; i < n+1; i++) {
            int start = -1;
            int end = -1;
            for (int j = 1; j < n+1; j++) {
                if(start == -1 && copyGraph[i][j] == 5){
                    start = j;
                }else if(end == -1 && copyGraph[i][j] == 5){
                    end = j;
                }
                if( j == n ){
                    if(start != -1 && end != -1){
                        for(int k = start+1; k <= end - 1; k++){
                            copyGraph[i][k] = 5;
                            visited[i][k] = true;
                            fiveResult += graph[i][k];
//                            System.out.println(graph[i][k]+"이거더해");
                        }
                    }
                }
            }
        }
    }

    public static void graphBoundary(int y, int x, int d1, int d2, int[][] copyGraph, boolean[][] visited) {
        //(x, y), (x+1, y-1), ..., (x+d1, y-d1)
        for (int i = 0; i <= d1; i++) {
            if(!visited[y + i][x - i]){
                copyGraph[y + i][x - i] = 5;
                visited[y + i][x - i] = true;
                fiveResult += graph[y + i][x - i];
//                System.out.println(graph[y + i][x - i]+"이거더해");
            }
        }
        //(x, y), (x+1, y+1), ..., (x+d2, y+d2)
        for (int i = 0; i <= d2; i++) {
            if(!visited[y + i][x + i]){
                visited[y + i][x + i] = true;
                copyGraph[y + i][x + i] = 5;
                fiveResult += graph[y + i][x + i];
//                System.out.println(graph[y + i][x + i]+"이거더해");
            }
        }
        //(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
        for (int i = 0; i <= d2; i++) {
            if(!visited[y + d1 + i][x - d1 + i]){
                copyGraph[y + d1 + i][x - d1 + i] = 5;
                visited[y + d1 + i][x - d1 + i] = true;
                fiveResult += graph[y + d1 + i][x - d1 + i];
            }
        }
        //(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
        for (int i = 0; i <= d1; i++) {
            if(!visited[y + d2 + i][x + d2 - i]){
                copyGraph[y + d2 + i][x + d2 - i] = 5;
                visited[y + d2 + i][x + d2 - i] = true;
                fiveResult += graph[y + d2 + i][x + d2 - i];
            }
        }
    }

    public static void graph(int y, int x, int d1, int d2, int[][] copyGraph, boolean[][] visited) {
        // 1번 선거구
        // 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
        int result1 = 0;
        for (int i = 1; i < y + d1; i++) {
            for (int j = 1; j <= x; j++) {
                if (visited[i][j]) {
                    continue;
                }
                int num = graph[i][j];
                result1 = result1 + num;
                visited[i][j] = true;
                copyGraph[i][j] = 1;
            }
        }
        list.add(result1);
        int result2 = 0;
        // 2 번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
        for (int i = 1; i <= y + d2; i++) {
            for (int j = x + 1; j <= n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                int num = graph[i][j];
                result2 = result2 + num;
                visited[i][j] = true;
                copyGraph[i][j] = 2;
            }
        }
        list.add(result2);
        // 3번 선거구 x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
        int result3 = 0;
        for (int i = y + d1; i <= n; i++) {
            for (int j = 1; j < x - d1 + d2; j++) {
                if (visited[i][j]) {
                    continue;
                }
                int num = graph[i][j];
                result3 = result3 + num;
                visited[i][j] = true;
                copyGraph[i][j] = 3;
            }
        }
        list.add(result3);
        // 4번 선거구 x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
        int result4 = 0;
        for (int i = y + d2 + 1; i <= n; i++) {
            for (int j = x - d1 + d2; j <= n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                int num = graph[i][j];
                result4 = result4 + num;
                visited[i][j] = true;
                copyGraph[i][j] = 4;
            }
        }
        list.add(result4);
//        checking(copyGraph);
    }

    public static boolean checking(int y, int x) {
        return y >= 1 && x >= 1 && y <= n && x <= n;
    }

    public static void checking(int[][] graph) {
        System.out.println();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
