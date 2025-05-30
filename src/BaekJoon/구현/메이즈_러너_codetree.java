package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 메이즈_러너_codetree {
    static int n;
    static int[][] graph;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                graph[i][j] = -(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            graph[y][x]++;
        }

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;
        graph[y][x] = -10;

        int time = 0;
        while( time < k ){
            moving();
//            checkingGraph();
            rotate();
//            checkingGraph();
            time++;
        }
        System.out.println(result);
        int[] pos = result();
        System.out.println((pos[0] + 1) + " " + (pos[1] + 1));
    }
    public static void checkingGraph(){
        System.out.println();
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j ++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[] result(){
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                if(graph[i][j] == -10){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
    public static void rotate(){
        for(int i = 1; i <= n ; i ++){
            if(rotate(i)){
                break;
            }
        }
    }

    public static boolean rotate(int size){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                // 사이즈의 크기만큼 돌기
                if(checking(i,j,size)){
                    // 현재 위치가 true라면
                    rotate(i,j,size);
                    return true;
                }
            }
        }
        return false;
    }

    public static void rotate(int startY, int startX, int size){
        // 현재 이 크기만큼 회전하기
        // 현재 위치에서 돌 수 있는지 확인

        for(int i = startY; i < startY + size; i++){
            for(int j = startX; j < startX + size; j++){
                int num = graph[i][j];
                // 벽 내구도 1씩 감소
                if(num != -10 && num <= -1){
                    graph[i][j]++;
                }
            }
        }


        int[][] arr = new int[n][n];
        int indexX = startX;
        for(int i = startY; i < startY + size; i++){
            int indexY = (startY + size - 1);
            for(int j = startX; j < startX + size; j++){
                arr[i][j] = graph[indexY][indexX];
                indexY--;
            }
            indexX++;
        }

        for(int i = startY; i < startY + size; i++){
            for(int j = startX; j < startX + size; j++){
                graph[i][j] = arr[i][j];
            }
        }
    }
    public static boolean checking(int startY, int startX, int size){
        if(startY + size > n){
            return false;
        }

        if(startX + size > n){
            return false;
        }

        // 여기 포함이 되는지 안되는지 확인만 함
        boolean exitCheck = false;
        boolean personCheck = false;
//        System.out.println(startY + " " + startX + " " + size);
        for(int i = startY; i < startY + size; i++){
            for(int j = startX; j < startX + size; j++){
                // 만약 사람이 있다면,
                int num = graph[i][j];
                // 사람이 존재
                if(num > 0){
                    personCheck = true;
                }

                // 만약 출구가 있다면,
                if(num == -10){
                    exitCheck = true;
                }
            }
        }
        return exitCheck && personCheck;
    }


    public static void moving(){
        Queue<int[]> queue = new LinkedList<>();
        int[] exit = new int[2];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n; j++){
                if(graph[i][j] == - 10){
                    exit[0] = i;
                    exit[1] = j;
                }
                if(graph[i][j] > 0){
                    queue.add(new int[]{i,j, graph[i][j]});
                    graph[i][j] = 0;
                }
            }
        }
        // queue 를 돌면서 현재 위치에 대해 이동 하는지 안하는지 확인
        int size = queue.size();
        for(int i = 0 ; i < size; i++){
            int[] now = queue.poll();
            boolean flag = false;
            for(int j = 0 ; j < 4; j++){
                int nextY = now[0] + dy[j];
                int nextX = now[1] + dx[j];
                int dis1 = dis(exit, now[0], now[1]);
                int dis2 = dis(exit, nextY, nextX);
                // 범위안에 들어가야 하고 벽이 아니어야 하고 최단거리가 더 짧아져야함
                if(checking(nextY, nextX) && dis1 > dis2){
                    // 이제 큐에 들어감
                    if( (nextY == exit[0]) && (nextX == exit[1]) ){
                        result += now[2];
                        flag = true;
                    }else{
                        queue.add(new int[]{nextY, nextX, now[2]});
                        result += now[2];
                        flag = true;
                    }
                    break;
                }
            }

            if(!flag){
                // 움직이지 못한경우
                queue.add(now);
            }
        }
        size = queue.size();
        for(int i = 0 ; i < size; i++){
            int[] now = queue.poll();
            if((exit[0] == now[0] && exit[1] == now[1])){
                continue;
            }else{
                graph[now[0]][now[1]] += now[2];
            }
        }


    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < n && x < n && (graph[y][x] >= 0 || graph[y][x] == -10);
    }

    public static int dis(int[] exit, int y, int x){
        return Math.abs(y - exit[0]) + Math.abs(x - exit[1]);
    }
}
