package swea.역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class 미생물군집_2382 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    // 노드라는 군집
    public static class Node{
        boolean flag;
        int count;
        int dir;
        int time;
        public Node(int count, int dir){
            this.count = count;
            this.dir = dir;
            this.time = 0;
        }
        public Node(int count, int dir, int time){
            this.count = count;
            this.dir = dir;
            this.time = time;
        }
        public Node(){
            this.count = -1;
            this.dir = -1;
            this.time = -1;
            this.flag = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            // 시간
            int time = Integer.parseInt(st.nextToken());
            // 군집의 수
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Node>[][] graph = new ArrayList[n][n];
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    graph[j][l] = new ArrayList<>();
                }
            }
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                graph[y][x].add(new Node(count, dir));
            }
            // 일단 위치를 다 옮김
            // 옮기려는 위치에 맨 처음 false 면
            for (int j = 0; j < time; j++) {
                // 현재 시간 = 0;
                // 맨처음 시간은 0
                for (int l = 0; l < n; l++) {
                    for (int m = 0; m < n; m++) {
                        // 반복문을돌면서 해당 위치에 노드가 있는지 없는지 체크
                        if (!graph[l][m].isEmpty()) {
                            if(graph[l][m].size() == 1){
                                Node node = graph[l][m].get(0);
                                if(node.time == j){
                                    int Time = j + 1;
                                    node.time = Time;
                                    int nowY = l + dy[node.dir -1];
                                    int nowX = m + dx[node.dir -1];
                                    // 다음 위치에 노드를 추가하고
                                    Node newNode = new Node(node.count, node.dir, j + 1);
                                    graph[nowY][nowX].add(newNode);
                                    // 현재 위치의 노드를 제거
                                    graph[l][m].remove(node);
                                }
                            }else{
                                for (int o = 0; o < graph[l][m].size(); o++) {
                                    Node node = graph[l][m].get(o);
                                    if(node.time == j){
                                        int nowY = l + dy[node.dir -1];
                                        int nowX = m + dx[node.dir -1];
                                        Node newNode = new Node(node.count, node.dir, j + 1);
                                        graph[nowY][nowX].add(newNode);
                                        graph[l][m].remove(node);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                // 해당 길이가 2이상인애들은 모두 더해주고, 가장 큰놈의 방향으로 바꿔줌
                for (int l = 0; l < n; l++) {
                    for (int m = 0; m < n; m++) {
                        if(graph[l][m].size() > 1){
                            int maxNum = Integer.MIN_VALUE;
                            int dir = 0;
                            int sum = 0;
                            int Time = 0;
                            for (int o = 0; o < graph[l][m].size(); o++) {
                                Node node = graph[l][m].get(o);
                                Time = node.time;
                                sum += node.count;
                                if( maxNum < node.count ){
                                    dir = node.dir;
                                    maxNum = node.count;
                                }
                            }
                            //
                            graph[l][m].clear();
                            graph[l][m].add(new Node(sum, dir, Time));
                        }
                    }
                }
                boolean[][] visited = new boolean[n][n];
                // 가장자리에 있는 애들은 방향을 반대로 바꾸고,
                for (int l = 0; l < n; l++) {
                    for (int m = 0; m < n; m++) {
                        // y가 0이거나 6
                        if(l == 0 || l == n-1 || m == 0 || m == n-1){
                            if(!graph[l][m].isEmpty() && !visited[l][m]){
                                visited[l][m] = true;
                                Node node = graph[l][m].get(0);
                                int number = node.count / 2;
                                node.count = number ;
                                int DIR = switchDir(node.dir);
                                node.dir = DIR;
                                if(number == 0){
                                    graph[l][m].remove(node);
                                }
                            }
                        }
                    }
                }
            }
            int result = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if(!graph[j][l].isEmpty()){
                        Node node = graph[j][l].get(0);
                        result += node.count;
//                        System.out.println(node.count);
                    }
                }
            }
//            checkingNode(graph);
            System.out.println("#"+(i+1)+" "+result);
        }
    }
    public static int switchDir(int dir){
        int newDir = 0;
        switch(dir){
            case 1:{
                newDir = 2;
            }
            break;
            case 2:{
                newDir = 1;
            }
            break;
            case 3:{
                newDir = 4;
            }
            break;
            case 4:{
                newDir = 3;
            }
            break;
        }
        return newDir;
    }

    public static void checkingNode(ArrayList<Node>[][] graph){
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("[" + i + "," + j + "]: ");
                if (!graph[i][j].isEmpty()) {
                    for (Node node : graph[i][j]) {
                        System.out.print("(count: " + node.count + ", dir: " + node.dir + ") ");
                    }
                } else {
                    System.out.print("empty ");
                }
                System.out.print(" | ");
            }
            System.out.println(); // 다음 행으로 넘어가기 위해 줄바꿈
        }
    }
}
