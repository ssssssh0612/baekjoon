package BaekJoon.swea.역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2시 26분
// 3시 22분
public class 미생물격리_2382 {
    public static class Node {
        int number;
        int dir;
        int time;

        public Node(int number, int dir, int time) {
            this.number = number;
            this.dir = dir;
            this.time = time;
        }
    }

    static ArrayList<Node>[][] graph;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int time = input(br);
            int newTime = 0;
            while (newTime != time) {
                moving(newTime);
                merge();
                side();
                newTime++;
                if (newTime == time) {
                    break;
                }
            }
            System.out.println("#" + (i + 1) + " " + resultChecking());
            // 방향대로 움직이고 리스트의 길이가 2 이상이면 병합시키기
            // 가장자리에 있는 애들을 나누기 2 해주고 방향 반대로 바꿔주기
        }
    }

    public static int resultChecking() {
        int result = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (!graph[i][j].isEmpty()) {
                    result += graph[i][j].get(0).number;

                }
            }
        }
        return result;
    }

    public static int switchDir(int dir) {
        int newDir = 0;
        switch (dir) {
            case 0:
                newDir = 1;
                break;
            case 1:
                newDir = 0;
                break;
            case 2:
                newDir = 3;
                break;
            case 3:
                newDir = 2;
                break;
        }
        return newDir;
    }

    public static int input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken()) - 1;
            graph[y][x].add(new Node(number, dir, 0));
        }
        return time;
    }

    public static boolean checkingRange(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }

    public static void moving(int time) {
        // 0초부터 시작하고, 현재 시간과 같은애는 옮겨야할 놈
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (!graph[i][j].isEmpty()) {
                    // remove 해야할놈의 index
                    for (int z = 0; z < graph[i][j].size(); z++) {
                        Node node = graph[i][j].get(z);
                        if (node.time == time) {
                            // 시간이 같다면 옮겨야할 놈
                            int nextY = i + dy[node.dir];
                            int nextX = j + dx[node.dir];
//                            if (checkingRange(nextY, nextX)) {
                            graph[nextY][nextX].add(new Node(node.number, node.dir, time + 1));
                            graph[i][j].remove(z);
                            break;
//                            }
                        }
                    }
                }
            }
        }
    }

    public static void merge() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j].size() > 1) {
                    // 가장 많이큰놈
                    int max = Integer.MIN_VALUE;
                    int sum = 0;
                    int maxDir = 0;
                    int time = 0;
                    for (int z = 0; z < graph[i][j].size(); z++) {
                        Node node = graph[i][j].get(z);
                        sum += node.number;
                        if (max < node.number) {
                            // 최대값 넣어주고
                            max = node.number;
                            // 방향 바꾸고
                            maxDir = node.dir;
                            // 시간 바꾸고
                            time = node.time;
                        }
                    }
                    graph[i][j].clear();
                    graph[i][j].add(new Node(sum, maxDir, time));
                }
            }
        }
    }

    public static void side() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i == 0 || i == graph.length - 1 || j == 0 || j == graph.length - 1) {
                    if (!graph[i][j].isEmpty()) {
                        Node node = graph[i][j].get(0);
                        node.dir = switchDir(node.dir);
                        node.number = node.number / 2;
                    }
                }
            }
        }
    }


    public static void checking() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j].size() + " ");
            }
            System.out.println();
        }
    }
}
