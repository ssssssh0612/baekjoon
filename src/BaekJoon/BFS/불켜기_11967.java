package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 불켜기_11967 {
    static int[] nowPos;
    static Map<List<Integer>, List<int[]>> map;
    static boolean[][] visited;
    static int[][] graph;
    static int resultCount = 1;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][n];
        map = new HashMap<>();
        graph = new int[n][n];
        graph[0][0] = 1;
        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            List<Integer> list = new ArrayList<>();
            list.add(y);
            list.add(x);
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int[] arr = {a, b};
            if (map.containsKey(list)) {
                map.get(list).add(arr);
            } else {
                map.put(list, new ArrayList<>());
                map.get(list).add(arr);
            }
        }

        nowPos = new int[]{0,0};
        while(true) {
            // 불킬게 있는지 확인
            step1();

            // 현재 위치에서 불이 켜져있고, 방문하지 않은 곳 방문하기
            if (!step2()) {
                break;
            }
        }
        System.out.println(resultCount);
    }


    public static void step1(){
        // 현재 위치에 불킬게 있는지 확인
        List<Integer> list = new ArrayList<>();
        list.add( nowPos[0] );
        list.add( nowPos[1] );
        visited[nowPos[0]][nowPos[1]] = true;
        if(map.containsKey(list)){
            // 불킬게 있다면 불키기
            List<int[]> switchOn = map.get(list);
            for(int i = 0 ; i < switchOn.size(); i++){
                int[] arr = switchOn.get(i);
                if(graph[arr[0]][arr[1]] == 0){
                    // 불키기
                    graph[arr[0]][arr[1]] = 1;
                    resultCount++;
                }
            }
        }
    }
    public static boolean step2(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] checkVisited = new boolean[graph.length][graph.length];
        queue.add(new int[]{nowPos[0], nowPos[1]});
        while(!queue.isEmpty()){
            // 해당 위치가 방문 하지 않았던 곳이어야 함
            int[] now = queue.poll();
            if(!visited[now[0]][now[1]]){
                nowPos[0] = now[0];
                nowPos[1] = now[1];
                return true;
            }
            for(int i = 0 ; i < 4; i ++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && graph[nextY][nextX] == 1 &&
                        !checkVisited[nextY][nextX]){
                    queue.add(new int[]{nextY, nextX});
                    checkVisited[nextY][nextX] = true;
                }
            }
        }
        return false;
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length ;
    }
}

