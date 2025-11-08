package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 미친_아두이노_8972 {
    static String moving;
    static int[] dy = {1,1,1,0,0,0,-1,-1,-1};
    static int[] dx = {-1,0,1,-1,0,1,-1,0,1};
    static int[][] graph;
    static int[] now = new int[2];
    static int movingIndex = 0;
    static List<int[]> robots = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                if(str.charAt(j) == '.'){
                }else if(str.charAt(j) == 'R'){
                    robots.add(new int[]{i,j});
                }else{
                    now[0] = i;
                    now[1] = j;
                }
            }
        }
        moving = br.readLine();

        for (int i = 0; i < moving.length(); i++) {
            movingZongsu();
            if(checkingRobot()){
                System.out.println("kraj "+movingIndex);
                return;
            }
            movingRobots();
            if(checkingRobot()){
                System.out.println("kraj "+movingIndex);
                return;
            }
            destroy();
        }

        // 만약 아니라면
        for (int i = 0; i < robots.size(); i++) {
            int[] robot = robots.get(i);
            graph[robot[0]][robot[1]] = 2;
        }
        graph[now[0]][now[1]] = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if(graph[i][j] == 0){
                    sb.append(".");
                }else if(graph[i][j] == 1){
                    sb.append("I");
                }else{
                    sb.append("R");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void movingZongsu(){
        int movingNum = (moving.charAt(movingIndex) - '0') - 1;
        now[0] += dy[movingNum];
        now[1] += dx[movingNum];
        movingIndex++;
    }

    public static void movingRobots(){
        // 현재 종수 위치와 가장 가까운 위치
        for (int i = 0; i < robots.size(); i++) {
            // 가장 작은 i 찾기
            int index = findI(robots.get(i));
            // 그 위치로 로봇 옮기기
            robots.get(i)[0] += dy[index];
            robots.get(i)[1] += dx[index];
        }

    }
    public static boolean checkingRobot(){
        for (int[] robot : robots) {
            if (robot[0] == now[0] && robot[1] == now[1]) {
                return true;
            }
        }
        return false;
    }
    public static int findI(int[] robot){
        // 현재
        int result = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < 9; i++) {
            int nextY = robot[0] + dy[i];
            int nextX = robot[1] + dx[i];
            if(!checking(nextY, nextX)) continue;
            int sum = Math.abs(nextY - now[0]) + Math.abs(nextX - now[1]);
            if(sum < result){
                result = sum;
                index = i;
            }
        }
        return index;
    }
    public static boolean checking(int y, int x){
        return y>=0 && x>=0 && y < graph.length && x < graph[0].length;
    }
    public static void destroy(){
        int[][] visited = new int[graph.length][graph[0].length];
        for (int i = 0; i < robots.size(); i++) {
            // 현재 리스트와 겹치는지 확인하기
            int[] nowRobot = robots.get(i);
            visited[nowRobot[0]][nowRobot[1]]++;
        }

        List<int[]> newRobots = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if(visited[i][j] == 1){
                    newRobots.add(new int[]{i,j});
                }
            }
        }
        robots = newRobots;
    }
}
