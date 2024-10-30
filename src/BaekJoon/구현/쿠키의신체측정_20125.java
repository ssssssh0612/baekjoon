package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿠키의신체측정_20125 {
    static int[] heart = new int[2];
    static int[][] graph;
    // 상 하 좌 우 왼쪽4 오른쪽5
    static int[] dx = {0,0,-1,1,-1,1};
    static int[] dy = {-1,1,0,0,1,1};
    static int leftArm = 0 ;
    static int rightArm = 0 ;
    static int core = 0 ;
    static int[] legStart = new int[2];
    static int leftLeg = 0;
    static int rightLeg = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char ch = str.charAt(j);
                if(ch == '_'){
                    graph[i][j] = 0;
                }else{
                    graph[i][j] = 1;
                }
            }
        }
        checkingHeart();
        checkingArm(2);
        checkingArm(3);
        checkingCore(1);
        checkingLeg(4);
        checkingLeg(5);

        System.out.println((heart[0] + 1) + " " + (heart[1] + 1));
        System.out.println(leftArm+" "+rightArm+" "+core+" "+leftLeg+" "+rightLeg);
    }
    public static void checkingArm(int dir){
        int startY = heart[0];
        int startX = heart[1];
        for (int i = 0; i < graph.length; i++) {
            startY = startY + dy[dir];
            startX = startX + dx[dir];
            if(checkingRange(startY,startX) && graph[startY][startX] == 1){
                if(dir == 2){
                    leftArm++;
                }else if(dir == 3){
                    rightArm++;
                }
            }else{
                break;
            }
        }
    }
    public static void checkingCore(int dir){
        int startY = heart[0];
        int startX = heart[1];
        for (int i = 0; i < graph.length; i++) {
            startY = startY + dy[dir];
            startX = startX + dx[dir];
            if(checkingRange(startY,startX) && graph[startY][startX] == 1){
                core++;
            }else{
                legStart[0] = startY + dy[0];
                legStart[1] = startX + dx[0];
                break;
            }
        }
    }
    public static void checkingLeg(int dir){
        int startY = legStart[0] + dy[dir];
        int startX = legStart[1] + dx[dir];
        if(dir == 4){
            leftLeg++;
        }else if(dir == 5){
            rightLeg++;
        }
        for (int i = 0; i < graph.length; i++) {
            startY = startY + dy[1];
            startX = startX + dx[1];
            if(checkingRange(startY,startX) && graph[startY][startX] == 1){
                if(dir == 4){
                    leftLeg++;
                }else if( dir == 5){
                    rightLeg++;
                }
            }else{
                break;
            }
        }
    }

    public static void checkingHeart(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    if(checkingRange(nextY, nextX) && graph[nextY][nextX] == 1){
                        count++;
                    }
                }
                if(count == 4){
                    heart[0] = i;
                    heart[1] = j;
                    return;
                }
            }
        }
    }
    public static boolean checkingRange(int y , int x ){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
