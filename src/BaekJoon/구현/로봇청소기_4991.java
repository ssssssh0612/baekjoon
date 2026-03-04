package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기_4991 {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int count;
    static List<int[]> list;
    static List<int[][]> graphList;
    static int[] startPos = new int[2];
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(y == 0 && x == 0){
                break;
            }

            list = new ArrayList<>();
            graphList = new ArrayList<>();
            graph = new int[y][x];
            result = Integer.MAX_VALUE;
            for (int i = 0; i < y; i++) {
                String str = br.readLine();
                for (int j = 0; j < x; j++) {
                    char ch = str.charAt(j);
                    if (ch == '*') {
                        list.add(new int[]{i, j});
                    } else if (ch == 'o') {
                        startPos[0] = i;
                        startPos[1] = j;
                    } else if (ch == 'x') {
                        graph[i][j] = -1;
                    }
                }
            }
            list.add(new int[]{startPos[0], startPos[1]});
            for (int i = 0; i < list.size(); i++) {
                int[] pos = list.get(i);
                graphList.add(bfs(new int[]{pos[0] , pos[1]}));
            }

            visited = new boolean[list.size() - 1];
            arr = new int[list.size() - 1];

            backTracking(0);

            if(result == Integer.MAX_VALUE){
                sb.append(-1).append("\n");
            }else{
                sb.append(result).append("\n");
            }

        }
        System.out.println(sb);


    }

    public static void backTracking(int depth){
        if(depth == list.size() - 1){
            int[] nowPos = new int[]{startPos[0], startPos[1]};

            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if(sum > result){
                    return;
                }
                int startIndex = 0;
                for (int j = 0; j < list.size(); j++) {
                    int[] newPos = list.get(j);
                    if(nowPos[0] == newPos[0] && nowPos[1] == newPos[1]){
                        startIndex = j;
                    }
                }

                int index = arr[i];
                int[] pos = list.get(index);

                int dis = graphList.get(startIndex)[pos[0]][pos[1]];
                if(dis == 0){
                    return;
                }else{
                    sum += dis;
                    nowPos[0] = pos[0];
                    nowPos[1] = pos[1];
                }
            }

            result = Math.min(result, sum);
            return;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int[][] bfs(int[] nowPos){
        int[][] newGraph = new int[graph.length][graph[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{nowPos[0], nowPos[1], 0});

        boolean[][] checking = new boolean[graph.length][graph[0].length];

        checking[nowPos[0]][nowPos[1]] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            newGraph[now[0]][now[1]] = now[2];
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && !checking[nextY][nextX] && graph[nextY][nextX] == 0){
                    checking[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX, now[2] + 1});
                }
            }
        }



        return newGraph;
    }

    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
