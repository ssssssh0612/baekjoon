package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 봄버맨_2_16918 {
    static int[][] graph;
    static int time;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        //가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다. 모든 폭탄이 설치된 시간은 같다.
        minusTime();
        if(time == 0){
            resultGraph();
            return;
        }
        //다음 1초 동안 봄버맨은 아무것도 하지 않는다.
        bomber();
        if(time == 0){
            resultGraph();
            return;
        }
        //다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다. 즉, 모든 칸은 폭탄을 가지고 있게 된다. 폭탄은 모두 동시에 설치했다고 가정한다.
        minusTime();
        //1초가 지난 후에
        bomb();
        //3초 전에 설치된 폭탄이 모두 폭발한다.
        while(time > 0){
            bomber();
            if(time == 0){
                break;
            }
            minusTime();
            bomb();
        }
        resultGraph();
    }

    public static void checkingGraph() {
        System.out.println();

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                int number = graph[i][j];
                if( number == 0){
                    System.out.print(".");
                }else{
                    System.out.print("O");
                }
            }
            System.out.println();
        }

        System.out.println();
    }
    public static void resultGraph() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                int number = graph[i][j];
                if( number == 0){
                    System.out.print(".");
                }else{
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }

    public static void checkingGraphNumber() {
        System.out.println();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static int[][] copyGraph() {
        int[][] newGraph = new int[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }
        return newGraph;
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }

    // 폭탄 터뜨리기
    public static void bomb() {
        int[][] newGraph = copyGraph();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 1) {
                    newGraph[i][j] = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        if (checking(nextY, nextX)) {
                            newGraph[nextY][nextX] = 0;
                        }
                    }
                }
            }
        }
        graph = newGraph;
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                char ch = str.charAt(j);
                if (ch == '.') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 3;
                }
            }
        }
    }

    public static void minusTime() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                int number = graph[i][j];
                if (number > 0) {
                    graph[i][j]--;
                }
            }
        }
        time--;
    }

    public static void bomber() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                int number = graph[i][j];
                if (number == 0) {
                    graph[i][j] = 3;
                }
            }
        }
        time--;
    }
}
