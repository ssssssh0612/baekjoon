package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 미세먼지안녕_2_17144 {

    // 상 하 좌 우
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};


    // 동 북 서 남
    static int[] dxUp = {1,0,-1,0};
    static int[] dyUp = {0,-1,0,1};

    // 동 남 서 북
    static int[] dxDown = {1,0,-1,0};
    static int[] dyDown = {0,1,0,-1};


    static int result = 0 ;
    static int time;
    static int[][] graph;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        for(int i = 0 ; i < time ; i++){
            확산();
            작동();
        }
        resultChecking();
        System.out.println(result);
    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for(int i = 0 ; i < y ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < x;  j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == - 1){
                    list.add(new int[]{i,j});
                }
            }
        }
    }
    public static void 확산(){
        // 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
        // (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
        // 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
        // 확산되는 양은 Ar,c/5이고 소수점은 버린다. 즉, ⌊Ar,c/5⌋이다.
        // (r, c)에 남은 미세먼지의 양은 Ar,c - ⌊Ar,c/5⌋×(확산된 방향의 개수) 이다.

        // 새롭게 만들어서 방문처리
        int[][] newGraph = new int[graph.length][graph[0].length];
        newGraph[list.get(0)[0]][list.get(0)[1]] = -1;
        newGraph[list.get(1)[0]][list.get(1)[1]] = -1;
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph[0].length; j ++){
                if(graph[i][j] > 0){
                    먼지확산(i,j,graph[i][j],newGraph);
                }
            }
        }
        // 먼지가 확산됨 확산된 먼지에 대해서 그래프를 최신화
        graph = newGraph;
    }
    public static void checkingGraph(){
        System.out.println();
        for(int i = 0 ; i < graph.length; i ++){
            for(int j = 0 ; j < graph[0].length; j ++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && graph.length > y && graph[0].length > x;
    }
    public static void 먼지확산(int y, int x, int munji, int[][] newGraph){
        // 얼마나 확산될 수 있는가
        int count = 0 ;
        for(int i = 0; i < 4; i ++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            // 로봇 위치가 아니고, 범위안에 들어오면 퍼질 수 있음
            if(checking(nextY, nextX) && graph[nextY][nextX] != -1 ){
                count++;
            }
        }
        int sideMunji = munji / 5;
        int midMunji = munji - (sideMunji) * count;

        for(int i = 0; i < 4; i ++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            // 로봇 위치가 아니고, 범위안에 들어오면 퍼질 수 있음
            if(checking(nextY, nextX) && graph[nextY][nextX] != -1 ){
                newGraph[nextY][nextX] += sideMunji;
            }
        }
        newGraph[y][x] += midMunji;
    }
    public static void resultChecking(){
        for(int i = 0 ; i < graph.length; i ++){
            for(int j = 0 ; j < graph[0].length; j ++){
                if(graph[i][j] > 0){
                    result += graph[i][j];
                }
            }
        }
    }

    // 공기청정기에서는 바람이 나온다.
    // 위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
    // 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
    // 공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
    public static void 작동(){
        // 0번째가 위에있는 공기청정기 반시계
        int dir = 0;
        int startY = list.get(0)[0] + dyUp[dir];
        int startX = list.get(0)[1] + dxUp[dir];
        int a = graph[startY][startX];
        int b = 0;
        graph[startY][startX] = 0;
        while(true){
            int nextY = startY + dyUp[dir];
            int nextX = startX + dxUp[dir];
            if(nextY == list.get(0)[0] && nextX == list.get(0)[1]) {
                break;
            }
            if(checking(nextY,nextX)){
                b = graph[nextY][nextX];
                graph[nextY][nextX] = a;
                a = b;
                startY = nextY;
                startX = nextX;
            }else{
                // 현재 범위안에 들어오지 않는다면
                // 한칸 뒤로 가고
                dir++;
                nextY = startY + dyUp[dir];
                nextX = startX + dxUp[dir];
                // 바꾸는 순간 로봇이 있으면 값을 바꾸니 여기에서 걸러야함
                if(checking(nextY,nextX) && list.get(0)[0] != nextY && list.get(0)[1] != nextX) {
                    b = graph[nextY][nextX];
                    graph[nextY][nextX] = a;
                    a = b;
                    startY = nextY;
                    startX = nextX;
                }
            }
        }

        // 1번째가 아래에 있는 공기청정기 시계
        int dir1 = 0;
        int startY1 = list.get(1)[0] + dyDown[dir1];
        int startX1 = list.get(1)[1] + dxDown[dir1];
        int a1 = graph[startY1][startX1];
        int b1 = 0;
        graph[startY1][startX1] = 0;
        while(true){
            int nextY = startY1 + dyDown[dir1];
            int nextX = startX1 + dxDown[dir1];
            if(nextY == list.get(1)[0] && nextX == list.get(1)[1]) {
                break;
            }
            if(checking(nextY,nextX)){
                b1 = graph[nextY][nextX];
                graph[nextY][nextX] = a1;
                a1 = b1;
                startY1 = nextY;
                startX1 = nextX;
            }else{
                // 현재 범위안에 들어오지 않는다면
                // 한칸 뒤로 가고
                dir1++;
                nextY = startY1 + dyDown[dir1];
                nextX = startX1 + dxDown[dir1];
                // 바꾸는 순간 로봇이 있으면 값을 바꾸니 여기에서 걸러야함
                if(checking(nextY,nextX) && list.get(0)[0] != nextY && list.get(0)[1] != nextX) {
                    b1 = graph[nextY][nextX];
                    graph[nextY][nextX] = a1;
                    a1 = b1;
                    startY1 = nextY;
                    startX1 = nextX;
                }
            }
        }
    }
}
