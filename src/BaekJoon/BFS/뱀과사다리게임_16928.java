package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀과사다리게임_16928 {
    // 시작, 종점
    static boolean[][] visited = new boolean[101][101];
    static List<int[]> list = new ArrayList<int[]>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        bfs();
    }
    public static void input(BufferedReader br) throws Exception {
        // 시작은 1부터
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 1, 1});
        visited[1][1] = true;
        queue.offer(new int[]{1, 2, 1});
        visited[1][2] = true;
        queue.offer(new int[]{1, 3, 1});
        visited[1][3] = true;
        queue.offer(new int[]{1, 4, 1});
        visited[1][4] = true;
        queue.offer(new int[]{1, 5, 1});
        visited[1][5] = true;
        queue.offer(new int[]{1, 6, 1});
        visited[1][6] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(poll[0] + poll[1] == 100){
                System.out.println(poll[2]);
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int nowPos = poll[0] + poll[1];
                // 도착한 위치가 list안에 포함되는지 확인하기
                for (int j = 0; j < list.size(); j++) {
                    if(nowPos == list.get(j)[0]){
                        nowPos = list.get(j)[1];
                        //어차피 하나밖에 없음
                        break;
                    }
                }
                if(!visited[nowPos][i]){
//                    System.out.println("nowPos = "+ nowPos +" "+ i);
                    queue.offer(new int[]{nowPos, i, poll[2] + 1});
                    visited[nowPos][i] = true;
                }
            }
        }
    }
}
