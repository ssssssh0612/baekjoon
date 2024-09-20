package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 으어어에이쁠_23031 {
    static int[][] graph;
    static List<Integer> list = new ArrayList<>();
    static List<int[]> zombieList = new ArrayList<>();
    static List<int[]> switchList = new ArrayList<>();
    static int[] human = new int[2];
    static int dir = 0;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int[] switchDx = {1,1,0,-1,-1,-1,0,1};
    static int[] switchDy = {0,1,1,1,0,-1,-1,-1};
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        human[0] = 0;
        human[1] = 0;
        graph = new int[n][n];
        String a = br.readLine();
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == 'F'){
                list.add(1);
            }else if(a.charAt(i) == 'R'){
                list.add(2);
            }else if(a.charAt(i) == 'L'){
                list.add(3);
            }
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                if(str.charAt(j) == 'O'){
                    graph[i][j] = 0;
                }else if(str.charAt(j) == 'Z'){
                    zombieList.add(new int[]{i,j,0});
                }else if(str.charAt(j) == 'S'){
                    graph[i][j] = 2;
                    switchList.add(new int[]{i,j});
                }
            }
        }


        // 아리가 이동함
        // 아리가 스위치로 이동시 주변에 불이 켜져 좀비와 마주쳐도 상관 없음(
        // 좀비 이동
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == 1){
                // 움직이고
                moving();
                // 스위치를켰는지 체크하고
                if(!switchList.isEmpty()){
                    checkingSwitch();
                }
                // 좀비를 만나는지 체크하고
                if(!zombieList.isEmpty()){
                    meetChecking();
                    zombieMoving();
                    meetChecking();
                }
            }else if(list.get(i) == 2){
                turn(list.get(i));
                if(!zombieList.isEmpty()){
                    // 좀비 움직이고
                    zombieMoving();
                    // 좀비 만나는지 체크
                    meetChecking();
                }
            }else if(list.get(i) == 3){
                turn(list.get(i));
                if(!zombieList.isEmpty()){
                    // 좀비 움직이고
                    zombieMoving();
                    // 좀비 만나는지 체크
                    meetChecking();
                }
            }

            if( flag ){
                break;
            }
        }
        if( flag ){
            System.out.println("Aaaaaah!");
        }else{
            System.out.println("Phew...");
        }
    }
    public static void meetChecking(){
        for (int i = 0; i < zombieList.size(); i++) {
            int y = zombieList.get(i)[0];
            int x = zombieList.get(i)[1];
            if(human[0] == y && human[1] == x && graph[y][x] == 0){
                flag = true;
            }
        }
    }
    public static boolean checkingGraph(int y, int x){
        return y >= 0 && y < graph.length && x >= 0 && x < graph[0].length;
    }
    public static void checkingSwitch(){
        for (int i = 0; i < switchList.size(); i++) {
            int y = switchList.get(i)[0];
            int x = switchList.get(i)[1];
            if(human[0] == y && human[1] == x){
                for (int j = 0; j < 8; j++) {
                    int nowY = y + switchDy[j];
                    int nowX = x + switchDx[j];
                    if(checkingGraph(nowY, nowX)){
                        graph[nowY][nowX] = 2;
                    }
                }
            }
        }
    }
    public static void moving(){
        // 아리가 현재 방향으로 한칸 움직임
        int nowY = human[0] + dy[dir];
        int nowX = human[1] + dx[dir];
        if(checkingGraph(nowY, nowX)){
            // 사람이 움직이고
            human[0] = nowY;
            human[1] = nowX;
        }
    }
    public static void zombieMoving(){
        // 좀비들이 벽에 부딛치면 2로 움직이고, 벽에 안부딛치면 0으로 움직임
        for (int i = 0; i < zombieList.size(); i++) {
            int y = zombieList.get(i)[0] + dy[zombieList.get(i)[2]]; ;
            int x = zombieList.get(i)[1] + dx[zombieList.get(i)[2]]; ;
            // true 면 아래로 한칸
            if(checkingGraph(y, x)){
                zombieList.get(i)[0] = y;
                zombieList.get(i)[1] = x;
            }else{
                if( zombieList.get(i)[2] == 0 ){
                    zombieList.get(i)[2] = 2;
                }else{
                    zombieList.get(i)[2] = 0;
                }
            }
        }
    }
    public static void turn(int number){
        // 오른쪽 회전
        if(number == 2){
            if( dir == 3 ){
                dir = 0;
            }else{
                dir = dir + 1;
            }
        }else{
            // 왼쪽 회전
            if( dir == 0){
                dir = 3;
            }else{
                dir = dir - 1;
            }
        }
    }

    public static void check(){
        System.out.println();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
}
