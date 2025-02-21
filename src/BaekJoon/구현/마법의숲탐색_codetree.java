package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법의숲탐색_codetree {
    static int[][] graph;
    // 북, 동, 남, 서
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};


    static int[] movingDownY = {1,1,2};
    static int[] movingDownX = {-1,1,0};

    static int[] movingLeftY = {-1,0,1,1,2};
    static int[] movingLeftX = {-1,-2,-1,-2,-1};

    static int[] movingRightY = {-1,0,1,1,2};
    static int[] movingRightX = {1,2,1,2,1};

    static int resultCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int monsterCount = Integer.parseInt(st.nextToken());
        graph = new int[y + 3][x];
        for(int i = 0 ; i < monsterCount; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            movingStart(start, dir, i+1);
        }
        System.out.println(resultCount);
    }

    public static void movingStart(int start, int dir, int number){
        // 일단 정령과 함께 골렘을 떨구고 검사해보자
        int[] pos = moving(start, dir, number);
//        checkGraph();
        // 현재 정령의 시작점이 가능한지
        if (startChecking()) {
            // 정령 마지막 위치 반환받고 해당 위치에서 bfs 돌기
            bfs(pos[0], pos[1]);
        }else{
            reset();
        }
    }

    public static boolean startChecking(){
        for(int i = 0 ; i < 3; i ++){
            for(int j = 0 ; j < graph[0].length; j++){
                int number = graph[i][j];
//                System.out.println( i + " " + j + " " + number);
                if( Math.abs(number) > 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void reset(){
        // 골렘을 놓을 수 없어 초기화함
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph[0].length; j++){
                graph[i][j] = 0;
            }
        }
    }

    public static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        visited[y][x] = true;
        queue.add(new int[]{y, x});
//        System.out.println(y + " " + x);
        int maxY = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int number = graph[now[0]][now[1]];
            if(now[0] > maxY){
                maxY = now[0];
            }
//            System.out.println("now[0] = " + now[0] + " " + "now[1] = " + now[1]);
            for(int i = 0 ; i < 4; i++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                // 내가 출구에 있다면
                if(number < 0){
                    // 어디든 갈 수 있음
                    if(checking(nextY, nextX) && graph[nextY][nextX] != 0 && !visited[nextY][nextX]){
                        queue.add(new int[]{nextY, nextX});
                        visited[nextY][nextX] = true;
                    }
                }else{
                    if(checking(nextY, nextX) && !visited[nextY][nextX] &&
                            (Math.abs(graph[nextY][nextX]) == number)){
                        queue.add(new int[]{nextY,nextX});
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }
        resultCount += maxY - 2;
//        System.out.println("추가하는 값은 !"+ (maxY - 2));
//        System.out.println("maxY = " + maxY);
//        System.out.println(resultCount);
    }

    public static int[] moving(int start, int dir, int number){
        // 밑으로 최대한 움직이기
        int y = 1;
        int x = start;
        int newDir = dir;
        while(true){
            boolean flag1 = true;
            for(int i = 0 ; i < 3; i++){
                int startY = y + movingDownY[i];
                int startX = x + movingDownX[i];
//                System.out.println("startY = " + startY + " startX = " + startX + " ");
                if(checking(startY, startX) && graph[startY][startX] == 0){
                    continue;
                }else{
                    flag1 = false;
                    break;
                }
            }
            if(flag1){
                y = y + 1;
                x = x + 0;
                continue;
            }

            boolean flag2 = true;
            for(int i = 0 ; i < 5; i++){
                int nextY = y + movingLeftY[i];
                int nextX = x + movingLeftX[i];
                if(checking(nextY, nextX) && graph[nextY][nextX] == 0){
                    continue;
                }else{
                    flag2 = false;
                    break;
                }
            }
            if(flag2){
                y = y + 1;
                x = x + (-1);
                newDir--;
                if(newDir == -1){
                    newDir = 3;
                }
                continue;
            }

            boolean flag3 = true;
            for(int i = 0 ; i < 5; i++){
                int nextY = y + movingRightY[i];
                int nextX = x + movingRightX[i];
                if(checking(nextY, nextX) && graph[nextY][nextX] == 0){
                    continue;
                }else{
                    flag3 = false;
                    break;
                }
            }
            if(flag3){
                y = y + 1;
                x = x + 1;
                newDir++;
                if(newDir == 4){
                    newDir = 0;
                }
            }else{
                break;
            }
        }


        graph[y][x] = number;
        for(int i = 0 ; i < 4; i ++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(newDir == i){
                graph[nextY][nextX] = -number;
            }else{
                graph[nextY][nextX] = number;
            }
        }
        return new int[]{y, x};
        // 마지막 위치
    }

    public static int[] leftMoving(int y, int x, int dir){
        int startY = y;
        int startX = x;
        int newDir = dir;
        while(true){
            boolean flag = true;
            for(int i = 0 ; i < 5; i++){
                int nextY = startY + movingLeftY[i];
                int nextX = startX + movingLeftX[i];
                if(checking(nextY, nextX) && graph[nextY][nextX] == 0){
                    continue;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                startY = startY + 1;
                startX = startX + (-1);
                newDir--;
                if(newDir == -1){
                    newDir = 3;
                }
            }else{
                break;
            }
        }
        return new int[]{0};
    }
    public static int[] rightMoving(int y, int x, int dir){
        int startY = y;
        int startX = x;
        int newDir = dir;
        while(true){
            boolean flag = true;
            for(int i = 0 ; i < 5; i++){
                int nextY = startY + movingRightY[i];
                int nextX = startX + movingRightX[i];
                if(checking(nextY, nextX) && graph[nextY][nextX] == 0){
                    continue;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                startY = startY + 1;
                startX = startX + 1;
                newDir++;
                if(newDir == 4){
                    newDir = 0;
                }
            }else{
                break;
            }
        }
        return new int[]{startY, startX, newDir};
    }

    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }


    public static void checkGraph(){
        System.out.println();
        for(int i = 0 ; i < graph.length ; i ++){
            for(int j = 0 ; j < graph[0].length ; j++){
                System.out.print(Math.abs(graph[i][j]) +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}


