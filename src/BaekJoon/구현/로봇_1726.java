package BaekJoon.구현;

import BaekJoon.Strig.팰린드롬replaceAll_inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 로봇_1726 {
    // 동 서 남 북
    // 0  1 2 3
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] startPos = new int[3];
    static int[] endPos = new int[3];
    static boolean[][][] visited;
    static int[][] graph;
    static List<int[]> list = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    public static class Robot{
        int y;
        int x;
        int cnt;
        int dir;
        public Robot(int y, int x, int dir, int cnt){
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        visited = new boolean[y][x][4];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        startPos[0] = Integer.parseInt(st.nextToken()) - 1 ;
        startPos[1] = Integer.parseInt(st.nextToken()) - 1;
        startPos[2] = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        endPos[0] = Integer.parseInt(st.nextToken()) - 1;
        endPos[1] = Integer.parseInt(st.nextToken()) - 1;
        endPos[2] = Integer.parseInt(st.nextToken()) - 1;
        bfs();
        System.out.println(result);
    }

    // 방향을 바꿀때마다 count ++
    public static void bfs(){
        Queue<Robot> queue = new LinkedList<>();
        queue.add(new Robot(startPos[0],startPos[1],startPos[2],0));
        visited[startPos[0]][startPos[1]][startPos[2]] = true;
        while(!queue.isEmpty()){
            Robot robot = queue.poll();
            int nowY = robot.y;
            int nowX = robot.x;
            int nowDir = robot.dir;
            int nowCnt = robot.cnt;
//            System.out.println(nowY+" "+nowX+" "+nowDir+" "+nowCnt);

//            for (int i = 0; i < 4; i++) {
//                visited[endPos[0]][endPos[1]][endPos[2]] = false;
//            }

            // endPos 와 같은지체크
            if(nowY == endPos[0] && nowX == endPos[1] && nowDir == endPos[2]){
                result = robot.cnt;
                break;
            }
            // 회전 체크
            if (nowDir == 0) {
                if(!visited[nowY][nowX][2] && graph[nowY][nowX] == 0){
                    queue.add(new Robot(nowY,nowX,2,nowCnt+1));
                    visited[nowY][nowX][2] = true;
                }

                if(!visited[nowY][nowX][3] && graph[nowY][nowX] == 0){
                    queue.add(new Robot(nowY,nowX,3,nowCnt+1));
                    visited[nowY][nowX][3] = true;
                }
            }else if(nowDir == 1){
                if(!visited[nowY][nowX][2] && graph[nowY][nowX] == 0){
                    queue.add(new Robot(nowY,nowX,2,nowCnt+1));
                    visited[nowY][nowX][2] = true;
                }

                if(!visited[nowY][nowX][3] && graph[nowY][nowX] == 0){
                    queue.add(new Robot(nowY,nowX,3,nowCnt+1));
                    visited[nowY][nowX][3] = true;
                }
            }else if(nowDir == 2){
                if(!visited[nowY][nowX][1] && graph[nowY][nowX] == 0){
                    queue.add(new Robot(nowY,nowX,1,nowCnt+1));
                    visited[nowY][nowX][1] = true;
                }

                if(!visited[nowY][nowX][0] && graph[nowY][nowX] == 0){
                    queue.add(new Robot(nowY,nowX,0,nowCnt+1));
                    visited[nowY][nowX][0] = true;
                }

            }else{
                if(!visited[nowY][nowX][1] && graph[nowY][nowX] == 0){
                    queue.add(new Robot(nowY,nowX,1,nowCnt+1));
                    visited[nowY][nowX][1] = true;
                }

                if(!visited[nowY][nowX][0] && graph[nowY][nowX] == 0){
                    queue.add(new Robot(nowY,nowX,0,nowCnt+1));
                    visited[nowY][nowX][0] = true;
                }

            }

            for(int i = 1; i <= 3; i ++){
                // 현재 방향으로 1,2,3 갈 수 있는지에 대해 검사
                int newY = nowY + i * dy[nowDir];
                int newX = nowX + i * dx[nowDir];
                if(i == 1){
                    if(checking(newY,newX) && !visited[newY][newX][nowDir] && graph[newY][newX] == 0){
                        queue.add(new Robot(newY,newX,nowDir,nowCnt+1));
                        visited[newY][newX][nowDir] = true;
                    }else if(checking(newY,newX) && graph[newY][newX] == 1){
                        break;
                    }
                }else if(i ==2){
                    if(checking(newY,newX) && !visited[newY][newX][nowDir] && graph[newY][newX] == 0){
                        queue.add(new Robot(newY,newX,nowDir,nowCnt+1));
                        visited[newY][newX][nowDir] = true;
                    }else if(checking(newY,newX) && graph[newY][newX] == 1){
                        break;
                    }
                }else{
                    if(checking(newY,newX) && !visited[newY][newX][nowDir] && graph[newY][newX] == 0){
                        queue.add(new Robot(newY,newX,nowDir,nowCnt+1));
                        visited[newY][newX][nowDir] = true;
                    }else if(checking(newY,newX) && graph[newY][newX] == 1){
                        break;
                    }
                }
            }
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }


}
