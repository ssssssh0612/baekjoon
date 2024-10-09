package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 캐슬디펜스_17135 {
    static boolean[] visited;
    static int[] arr;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int length;
    static int killCount  = 0;
    static int result = Integer.MIN_VALUE;
    static int[][] copyGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()); // n
        int x = Integer.parseInt(st.nextToken()); // m
        length = Integer.parseInt(st.nextToken());
        graph = new int[y + 1][x];
        copyGraph = new int[y + 1][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                copyGraph[i][j] = num;
            }
        }
        arr = new int[3];
        visited = new boolean[x];
        // 일단 백트래킹으로 궁수의 위치 체크

        backTracking(0,0);
        System.out.println(result);

    }
    public static void checking(){
        System.out.println();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void copyGraph(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                graph[i][j] = copyGraph[i][j];
            }
        }
    }
    public static void backTracking(int depth, int number){
        if( depth == 3){
            // 현재 선택된 궁수들의위치로 bfs를 돌아서
            for (int i = 0; i < arr.length; i++) {
                graph[graph.length -1][arr[i]] = 1;
//                System.out.print(arr[i]+" ");
            }
            for (int i = 0; i < graph.length - 1; i++) {
                kill();
                down();
//                checking();
            }
            result = Math.max(result , killCount);
            // 현재 궁수들의 위치에서 bfs 를 돌려 가장 가깝고, 가장 왼쪽에 있는 적을 죽여야함
            killCount = 0;
            copyGraph();
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] && number <= i){
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    public static void kill(){
        List<int[]> killList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            // 현재 큐를 돌면서
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.add(new int[]{graph.length - 1, arr[i]});
            int[] killPos = new int[]{-1,-1};
            int distance = 1;
            boolean[][] check = new boolean[graph.length][graph[0].length];
            while(!queue.isEmpty()){
                int queueSize = queue.size();
                boolean flag = false;
//                System.out.println("queueSize"+queueSize+" i = "+ i );
                while(queueSize > 0){
                    queueSize--;
                    int[] now = queue.poll();
//                    System.out.println(now[0]+", "+now[1]);
                    for (int j = 0; j < 4; j++) {
                        int nowY = dy[j] + now[0];
                        int nowX = dx[j] + now[1];
//                        System.out.println(nowY+" "+nowX);
                        if(checking(nowY,nowX) && !check[nowY][nowX]){
                            if( nowY != graph.length -1 && graph[nowY][nowX] == 1 && distance <= length){
                                flag = true;
                                if(killPos[0] == -1 && killPos[1] == -1){
                                    killPos[0] = nowY;
                                    killPos[1] = nowX;
                                }else{
                                    if(killPos[1] > nowX){
                                        killPos[0] = nowY;
                                        killPos[1] = nowX;
                                    }
                                }
                            }else{
                                queue.add(new int[]{nowY,nowX});
                                check[nowY][nowX] = true;
                            }
                        }
                    }
                }
                distance++;
                if(flag){
//                    System.out.println("?????");
                    killList.add(new int[]{killPos[0],killPos[1]});
                    break;
                }
            }
        }
//        System.out.println("feed");
        for (int i = 0; i < killList.size(); i++) {
            if(graph[killList.get(i)[0]][killList.get(i)[1]] == 1){
                graph[killList.get(i)[0]][killList.get(i)[1]] = 0;
                killCount++;
            }
        }
    }
    // 범위안에 들어가는지 체크
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }

    public static void down(){
        for (int i = graph.length - 2; i >= 0; i--) {
            for (int j = 0; j < graph[0].length; j++) {
                if(i == graph.length - 2){
                    graph[i][j] = 0;
                }else{
                    int num = graph[i][j];
                    graph[i][j] = 0;
                    graph[i + 1][j] = num ;
                }
            }
        }
    }
}
