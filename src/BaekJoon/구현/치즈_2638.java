package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치즈_2638 {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] graph;
    static boolean[][] outSide;
    static boolean[][] inSide;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y + 2][x + 2];
        outSide = new boolean[y + 2][x + 2];
        inSide = new boolean[y + 2][x + 2];
        for (int i = 1; i <= y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        while(true){
            if(checkingGraph()){
                break;
            }
            // 외부 찾기
            findOutSide();
            // 안에있는 치즈 찾기
            removeCheese();
            outSide = new boolean[y + 2][x + 2];

            time++;
        }
        System.out.println(time);


    }
    public static boolean checkingGraph(){

        for (int i = 1; i <= graph.length - 2; i++) {
            for (int j = 1; j <= graph[0].length - 2; j++) {
                // 1이 하나라도 나오면 false
                if(graph[i][j] == 1){
                    return false;
                }
            }
        }

        return true;
    }
    public static void findOutSide(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        outSide[0][0] = true;
        // false 이고 graph == 0 외부에 포함
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                // 범위 안에 들고, outSide
                if(checking(nextY, nextX) && graph[nextY][nextX] == 0 && !outSide[nextY][nextX]){
                    outSide[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
    }
    // 지울 치즈 찾기
    public static void removeCheese(){
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= graph.length - 1 ; i++) {
            for (int j = 1; j <= graph[0].length - 1; j++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    if(checking(nextY,nextX) && outSide[nextY][nextX]){
                        count++;
                    }
                }
                // 현재 지워야할 치즈
                if(count >= 2){
                    list.add(new int[]{i,j});
                }
            }
        }
        // 치즈 지우기
        for(int[] pos : list){
            graph[pos[0]][pos[1]] = 0;
        }
    }

//    public static void findInSide(){
//        for (int i = 1; i <= graph.length - 2; i++) {
//            for (int j = 1; j <= graph[0].length - 2; j++) {
//                // 얘는 inside 라는 말
//                if(!outSide[i][j] && graph[i][j] == 0){
//                    inSide[i][j] = true;
//                }
//            }
//        }
//    }

    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
