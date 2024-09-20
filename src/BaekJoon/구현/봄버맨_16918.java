package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 봄버맨_16918 {
    static int y;
    static int x;
    static int second;
    static int[][] graph;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());
        graph = new int[y][x];

        for (int i = 0; i < y; i++) {
            String a = br.readLine();
            for (int j = 0; j < x; j++) {
                if (a.charAt(j) == 'O') {
                    // 폭탄 설치
                    graph[i][j] = 2;
                }
            }
        }
        //가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다. 모든 폭탄이 설치된 시간은 같다.
        //다음 1초 동안 봄버맨은 아무것도 하지 않는다.
        //다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다. 즉, 모든 칸은 폭탄을 가지고 있게 된다. 폭탄은 모두 동시에 설치했다고 가정한다.
        //1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
        //3과 4를 반복한다.
        if (second == 1) {
            result();
        } else if (second == 2) {
            bomber();
        } else if (second == 3) {
            bomber();
            boom();
        } else {
            for (int i = 1; i < second; i++) {
                if (i % 2 == 1) {
                    bomber();
                } else {
                    boom();
                }
            }
        }
        if(second != 1){
            result();
        }
    }

    public static void result() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (graph[i][j] >= 1) {
                    System.out.print("O");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }


    public static void bomber() {
        // 1초 지남
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (graph[i][j] >= 1 ) {
                    graph[i][j]++;
                }
            }
        }

        // 폭탄 설치
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                }
            }
        }

//        System.out.println();
//        checkingGraph();

    }

    public static void boom() {
        // 1초 지남
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (graph[i][j] >= 1 ) {
                    graph[i][j]++;
                }
            }
        }
        int[][] copyGraph = new int[y][x];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                copyGraph[i][j] = graph[i][j];
            }
        }


        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(graph[i][j] == 4){
                    copyGraph[i][j]= 0;
                    for (int k = 0; k < 4; k++) {
                        int nowY = i + dy[k];
                        int nowX = j + dx[k];
                        if(checking(nowY,nowX)){
                            copyGraph[nowY][nowX] = 0;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                graph[i][j] = copyGraph[i][j];
            }
        }

//        System.out.println();
//        checkingGraph();

    }

    public static boolean checking(int nowY, int nowX) {
        return nowY >= 0 && nowY < y && nowX >= 0 && nowX < x;
    }
    public static void checkingGraph(){
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}

