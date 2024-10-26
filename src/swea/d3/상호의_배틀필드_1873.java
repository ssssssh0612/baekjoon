package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의_배틀필드_1873 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0,};
    static int[] tankPos = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int[][] graph = new int[y][x];
            for (int j = 0; j < y; j++) {
                String str = br.readLine();
                for (int k = 0; k < x; k++) {
                    char ch = str.charAt(k);
                    if(ch == '*'){ // 돌벽 == 1
                        graph[j][k] = 1;
                    }else if(ch == '.'){ // 평지 == 0
                        graph[j][k] = 0;
                    }else if(ch == '#'){ // 강철벽 == 2
                        graph[j][k] = 2;
                    }else if(ch == '-'){ // 물 == 3
                        graph[j][k] = 3;
                    }else{
                        if(ch == '^'){
                            tankPos[0] = j;
                            tankPos[1] = k;
                            tankPos[2] = 0;
                        }else if(ch == '<'){
                            tankPos[0] = j;
                            tankPos[1] = k;
                            tankPos[2] = 2;
                        }else if(ch == '>'){
                            tankPos[0] = j;
                            tankPos[1] = k;
                            tankPos[2] = 3;
                        }else{
                            tankPos[0] = j;
                            tankPos[1] = k;
                            tankPos[2] = 1;
                        }
                    }
                }
            }
            int moveCase = Integer.parseInt(br.readLine());
            String a = br.readLine();
            for (int j = 0; j < moveCase; j++) {
                char ch = a.charAt(j);
                if(ch == 'U'){
                    Up(graph);
                }else if(ch == 'D'){
                    Down(graph);
                }else if(ch == 'L'){
                    Left(graph);
                }else if(ch == 'R'){
                    Right(graph);
                }else{
                    Shoot(graph);
                }
            }
            char[][] grid = new char[y][x];

            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if(graph[j][k] == 0){
                        grid[j][k] = '.';
                    }else if(graph[j][k] == 1){
                        grid[j][k] = '*';
                    }else if(graph[j][k] == 2){
                        grid[j][k] = '#';
                    }else if(graph[j][k] == 3){
                        grid[j][k] = '-';
                    }
                }
            }
            if(tankPos[2] == 0){
                grid[tankPos[0]][tankPos[1]] = '^';
            }else if(tankPos[2] == 1){
                grid[tankPos[0]][tankPos[1]] = 'v';
            }else if(tankPos[2] == 2){
                grid[tankPos[0]][tankPos[1]] = '<';
            }else{
                grid[tankPos[0]][tankPos[1]] = '>';
            }
            System.out.print("#"+(i+1)+" ");
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    System.out.print(grid[j][k]);
                }
                System.out.println();
            }
        }
    }
//                U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
//                D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
//                L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
//                R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
//                S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
    public static boolean checking(int[][] graph, int y, int x){
        return y >= 0 && x >= 0 && graph.length > y && graph[0].length > x;
    }
    public static void Up(int[][] graph){
        tankPos[2] = 0;
        int nowY = tankPos[0] + dy[tankPos[2]];
        int nowX = tankPos[1] + dx[tankPos[2]];
        if(checking(graph,nowY,nowX) && graph[nowY][nowX] == 0){
            tankPos[0] = nowY;
            tankPos[1] = nowX;
        }
    }
    public static void Down(int[][] graph){
        tankPos[2] = 1;
        int nowY = tankPos[0] + dy[tankPos[2]];
        int nowX = tankPos[1] + dx[tankPos[2]];
        if(checking(graph,nowY,nowX) && graph[nowY][nowX] == 0){
            tankPos[0] = nowY;
            tankPos[1] = nowX;
        }
    }
    public static void Left(int[][] graph){
        tankPos[2] = 2;
        int nowY = tankPos[0] + dy[tankPos[2]];
        int nowX = tankPos[1] + dx[tankPos[2]];
        if(checking(graph,nowY,nowX) && graph[nowY][nowX] == 0){
            tankPos[0] = nowY;
            tankPos[1] = nowX;
        }
    }
    public static void Right(int[][] graph){
        tankPos[2] = 3;
        int nowY = tankPos[0] + dy[tankPos[2]];
        int nowX = tankPos[1] + dx[tankPos[2]];
        if(checking(graph,nowY,nowX) && graph[nowY][nowX] == 0){
            tankPos[0] = nowY;
            tankPos[1] = nowX;
        }
    }
    public static void Shoot(int[][] graph){
        // 1이거나 2를 만날때까지
        int dir = tankPos[2];
        int shootingY = tankPos[0] + dy[dir];
        int shootingX = tankPos[1] + dx[dir];
        while(true){
            if(checking(graph,shootingY,shootingX) && (graph[shootingY][shootingX] == 1 || graph[shootingY][shootingX] == 2)){
                if(graph[shootingY][shootingX] == 1){
                    graph[shootingY][shootingX] = 0;
                    break;
                }else{
                    break;
                }
            }else if(!checking(graph,shootingY,shootingX)){
                break;
            }else if(checking(graph,shootingY,shootingX)){
                shootingY = shootingY + dy[dir];
                shootingX = shootingX + dx[dir];
            }
        }
    }
}
