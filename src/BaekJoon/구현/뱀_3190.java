package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀_3190 {
    static int[][] graph;
    static int movingIndex;
    static Deque<int[]> deque = new ArrayDeque<>();
    // 상, 하, 좌, 우
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static List <int[]> moveList = new ArrayList<>();
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        int time = 0;
        while(true){
            moving(time);
            if(flag){
                break;
            }
            time++;
        }
        System.out.println(time + 1);
    }
    // 방향 전환하기
    public static int switchDir(int dir, int turn){
        int newDir = 0;
        if( dir == 0){
            if ( turn == 0 ){
                newDir = 2;
            }else{
                newDir = 3;
            }
        }else if( dir == 1){
            if ( turn == 0 ){
                newDir = 3;
            }else{
                newDir = 2;
            }
        }else if( dir == 2){
            if ( turn == 0 ){
                newDir = 1;
            }else{
                newDir = 0;
            }
        }else{
            if ( turn == 0 ){
                newDir = 0;
            }else{
                newDir = 1;
            }
        }
        return newDir;
    }
    public static void input(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        movingIndex = 0;
        int appleCount = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < appleCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            graph[y][x] = 1;
        }
        int moveCount = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < moveCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            char ch = str.charAt(0);
            int turn = 0;
            if(ch == 'D') {
                turn = 1;
            }
            moveList.add(new int[]{second,turn});
        }
        // 해당 위치,
        deque.add(new int[]{0,0,3});
        graph[0][0] = 3;
    }
    // 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
    // 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
    // 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
    // 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
    // snake == 3
    public static void moving(int time){
        // 일단 뱀 머리 위치 정리
        int[] head = deque.peek();
        int nowY = head[0];
        int nowX = head[1];
        int dir = head[2];

//        System.out.println("y = "+ nowY + " x = " + nowX +  " dir = "+ dir );
        if( movingIndex < moveList.size() && time == moveList.get(movingIndex)[0]){
            dir = switchDir(dir,moveList.get(movingIndex)[1]);
            movingIndex++;
        }
        // 다음 이동할 위치 생각
        int nextY = nowY + dy[dir];
        int nextX = nowX + dx[dir];
        // 해당 위치가 벽이 아니라면 내 몸과 부딛치는가 ? 검증하기
        if(checking(nextY,nextX)){
            if(graph[nextY][nextX] == 1){
                deque.addFirst(new int[]{nextY,nextX,dir});
                graph[nextY][nextX] = 3;
            }else{
                deque.addFirst(new int[]{nextY,nextX,dir});
                graph[nextY][nextX] = 3;
                int[] tail = deque.removeLast();
                graph[tail[0]][tail[1]] = 0;
            }
        }else{
            flag = true;
        }
//        checkingGraph();
    }
    public static boolean checking(int y , int x){
        if(y >= 0 && x >= 0 && y < graph.length && x < graph[0].length){
            if(graph[y][x] == 3){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
    public static void checkingGraph(){
        System.out.println();
        for(int i = 0 ; i < graph.length; i ++){
            for(int j = 0; j < graph[0].length; j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
