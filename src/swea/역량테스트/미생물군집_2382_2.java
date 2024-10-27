package swea.역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 미생물군집_2382_2 {
    public static class Node {
        int count;
        int dir;
        int time;

        public Node(int count, int dir, int time) {
            this.count = count;
            this.dir = dir;
            this.time = time;
        }
    }

    static ArrayList<Node>[][] graph;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int allTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            input(br);
            for (int j = 0; j < allTime; j++) {
                moving(j);
                merge(j);
                checkingSide();
            }
            System.out.println("#" + (i + 1) + " "+resultChecking());
        }
    }

    public static void moving(int nowTime) {
        // 한 군집씩 이동
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                // 하나보다 크다면, 하나보다 작다면,
                // 비어있으면 넘기고 비어있지 않다면 현재 노드가 존재하는거고,
                // 노드의 사이즈를 생각해보자
                // 사이즈가 1보다 크다면, 해당 노드의 시간값과 같은애들을 옮겨주기
                if (graph[i][j].isEmpty()) continue;
                if (graph[i][j].size() > 1) {
                    for (int k = 0; k < graph[i][j].size(); k++) {
                        Node node = graph[i][j].get(k);
                        int dir = node.dir;
                        // 현재 시간값과 같다면 옮겨줘야할 노드
                        if (node.time == nowTime) {
                            int nextY = i + dy[dir];
                            int nextX = j + dx[dir];
                            // 노드를 옮겨주고
                            graph[nextY][nextX].add(node);
                            // 시간을 더해줌
                            node.time = node.time + 1;
                            // 현재위치 노드를 삭제시킴
                            graph[i][j].remove(node);
                            // 어차피 노드는 하나씩 옮겨지면 합쳐지기때문에
                            // 한칸에 하나만 옮기는 경우밖에 안생겨서 break;
                            break;
                        }
                    }
                } else {
                    // 그렇지 않다는건 사이즈가 1이라는 말이기때문에 그냥 옮겨주기만 하면 됨
                    Node node = graph[i][j].get(0);
                    int dir = node.dir;
                    // 현재 시간값과 같다면 옮겨줘야할 노드
                    if (node.time == nowTime) {
                        int nextY = i + dy[dir];
                        int nextX = j + dx[dir];
                        // 노드를 옮겨주고
                        // 시간을 더해줌
                        node.time = node.time + 1;
                        graph[nextY][nextX].add(node);
                        // 현재위치 노드를 삭제시킴
                        graph[i][j].remove(node);
                        // 어차피 노드는 하나씩 옮겨지면 합쳐지기때문에
                        // 한칸에 하나만 옮기는 경우밖에 안생겨서 break;
                    }
                }
            }
        }
    }

    public static void merge(int nowTime) {
        // 2개 이상 노드가 있는 애들은 머징시키기
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                // 사이즈가 1보다 큰 경우에는 현재 노드들이 병합되어져야할 노드들
                if (graph[i][j].size() > 1) {
                    int sum = 0;
                    int dir = 0;
                    int maxCount = Integer.MIN_VALUE;
                    for (int k = 0; k < graph[i][j].size(); k++) {
                        Node node = graph[i][j].get(k);
                        sum += node.count;
                        if (maxCount < node.count) {
                            dir = node.dir;
                            maxCount = node.count;
                        }
                    }
                    graph[i][j].clear();
                    graph[i][j].add(new Node(sum, dir, nowTime + 1));
                }
            }
        }
    }

    public static int switchingDir(int dir) {
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

    public static void checkingSide() {
        // 사이드에 존재하고있는 애들은 방향을 반대로 바꾸고 나눠주기
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i == 0 || i == graph.length - 1 ||
                        j == 0 || j == graph.length - 1) {
                    if (graph[i][j].size() > 0) {
                        Node node = graph[i][j].get(0);
                        // 방향 반대로 바꾸고
                        node.dir = switchingDir(node.dir);
                        // 미생물 갯수 줄이기
                        node.count = node.count / 2;
                    }
                }
            }
        }
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        allTime = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }
        int groupCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < groupCount; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken()) - 1;
            graph[y][x].add(new Node(count, dir, 0));
        }
    }
    public static int resultChecking(){
        int result = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if(!graph[i][j].isEmpty()){
                    Node node = graph[i][j].get(0);
                    result += node.count;
                }
            }
        }
        return result;
    }
}

