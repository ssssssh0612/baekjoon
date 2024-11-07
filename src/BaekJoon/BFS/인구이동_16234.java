package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인구이동_16234 {
    static int[][] graph;
    static int L;
    static int R;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    // 인구이동이 발생했는지 안했는지 체크하기
    static int result = 0 ;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        while(true){
            step();
            if(flag){
                result++;
            }else{
                break;
            }
            flag = false;
        }
        System.out.println(result);
    }
    //국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
    //위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
    //국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
    //연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
    //연합을 해체하고, 모든 국경선을 닫는다.

    public static void step(){
        boolean[][] visited = new boolean[graph.length][graph.length];
        // 현재 L명 이상 R명 이하인지 체크하기
        for(int i = 0 ; i < graph.length; i ++){
            for(int j = 0; j < graph.length; j ++){
                // 방문하지 않았다면 방문해서 체크하기
                if(!visited[i][j]){
                    bfs(i,j,visited);
                }
            }
        }

    }
    public static void bfs(int y, int x, boolean[][] visited){
        // 현재 나눌 수 있는 리스트
        List<int[]> list = new ArrayList<>();
        // 방문해서 체크표시 하기
        visited[y][x] = true;
        list.add(new int[]{y,x});
        int count = graph[y][x];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4; i ++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY,nextX) && !visited[nextY][nextX]){
                    int number = Math.abs(graph[now[0]][now[1]] - graph[nextY][nextX]);
                    if( number >= L && number <= R){
                        queue.add(new int[]{nextY,nextX});
                        list.add(new int[]{nextY,nextX});
                        visited[nextY][nextX] = true;
                        count += graph[nextY][nextX];
                    }
                }
            }
        }
        // 2이상이라면 인구이동이 한번이라도 발생함
        if(list.size() >= 2){
            flag = true;
        }
        int inputNumber = count / list.size();
        for(int[] arr : list ){
            int y1 = arr[0];
            int x1 = arr[1];
            graph[y1][x1] = inputNumber;
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        // 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j ++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
