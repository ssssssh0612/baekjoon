package BaekJoon.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 알파벳_1987 {
    static int y;
    static int x;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static char[][] graph;
    static boolean[][] visited;
    static int[] pos = new int[2];
    static List<Character> list = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        pos[0] = 0;
        pos[1] = 0;
        graph = new char[y][x];
        visited = new boolean[y][x];

        sc.nextLine();
        for (int i = 0; i < y; i++) {
            String a = sc.nextLine();
            for (int j = 0; j < a.length(); j++) {
                graph[i][j] = a.charAt(j);
            }
        }
        list.add(graph[0][0]);
        backTracking(0,0,0);
        System.out.println(result);

    }
    public static void backTracking(int y, int x, int number){
        result = Math.max(result,list.size());
        for (int i = 0; i < 4; i++) {
            int nowY = y + dy[i];
            int nowX = x + dx[i];
            if( checking(nowY, nowX) && checkingArr( graph[nowY][nowX] )) {
                list.add(graph[nowY][nowX]);
                backTracking(nowY,nowX,number+1);
                list.remove((Character) graph[nowY][nowX]);
            }
        }

    }

    public static boolean checking( int nowY, int nowX){
        return nowY >= 0 && nowX >= 0 && nowY < y && nowX < x;
    }
    public static boolean checkingArr( char a ){
        for (int i = 0; i < list.size(); i++) {
            if( list.get(i) == a ){
                return false;
            }
        }
        return true;
    }
}
