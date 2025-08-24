package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목_2615 {
    static boolean flag = false;
    static int[][] graph = new int[19][19];
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19 ; i++) {
            for (int j = 0; j < 19 ; j++) {
                if(flag) continue;

                if(graph[i][j] == 1 || graph[i][j] == 2 ){
                    if(checking(i,j,2)){
                        flag = true;
                        System.out.println(graph[i][j]);
                        System.out.println((i + 1) + " " + (j + 1));
                        continue;
                    }

                    if(checking(i,j,3)){
                        flag = true;
                        System.out.println(graph[i][j]);
                        System.out.println((i + 1) + " " + (j + 1));
                        continue;
                    }

                    if(checking(i,j,4)){
                        flag = true;
                        System.out.println(graph[i][j]);
                        System.out.println((i + 1) + " " + (j + 1));
                        continue;
                    }

                    if(checking(i,j,5)){
                        flag = true;
                        System.out.println(graph[i][j]);
                        int nowY = (i + 1) + (dy[5] * 4);
                        int nowX = (j + 1) + (dx[5] * 4);
                        System.out.println(nowY + " " + nowX);
                    }
                }
            }
        }

        if(!flag){
            System.out.println(0);
        }
    }
    public static boolean checking(int y, int x, int dir){
        int count = 1;
        int num = graph[y][x];
        // 해당 방향으로 검사하기전에 반대방향으로 같은 숫자가 몇번 들어오는지
        int switchDir = switchDir(dir);
        int nowY = y;
        int nowX = x;
        while(true){
            nowY = nowY + dy[switchDir];
            nowX = nowX + dx[switchDir];
            if(checking(nowY,nowX) && graph[nowY][nowX] == num){
                count++;
            }else{
                break;
            }
        }
        nowY = y;
        nowX = x;
        while(true){
            nowY = nowY + dy[dir];
            nowX = nowX + dx[dir];
            if(checking(nowY,nowX) && graph[nowY][nowX] == num){
                count++;
            }else{
                break;
            }
        }
        if(count == 5){
            return true;
        }else{
            return false;
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < 19 && x < 19;
    }
    public static int switchDir(int dir){
        if(dir == 2){
            return 6;
        }else if(dir == 3){
            return 7;
        }else if(dir == 4){
            return 0;
        }else{
            return 1;
        }
    }
}
