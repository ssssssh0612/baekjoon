package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀_3190 {
    static int[][] graph;
    static int movingIndex;
    static Deque<int[]> deque = new ArrayDeque<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        //
        deque.addFirst(new int[]{0,0,});
        movingIndex = 0;
        while(true){
            moving();
        }
    }

    public static void input(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        int appleCount = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < appleCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            graph[y][x] = 1;
        }
        int moveCount = Integer.parseInt(br.readLine());
        List<int[]> moveList = new ArrayList<>();
        for(int i = 0 ; i < moveCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            char ch = str.charAt(0);
            int dir = 0;
            if(ch == 'D') {
                dir = 1;
            }
            moveList.add(new int[]{second,dir});
        }
    }
    // 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
    // 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
    // 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
    // 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
    public static void moving(){

    }
}
