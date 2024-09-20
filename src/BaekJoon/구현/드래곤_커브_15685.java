package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 드래곤_커브_15685 {
    static List<int[]> dragonList = new ArrayList<int[]>();
    static int[][] graph = new int[100][100];
    // 동 북 서 남
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited = new boolean[100][100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            dragonList.add(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()});
        }

        for (int i = 0; i < dragonList.size(); i++) {

        }



    }
    public static void startDragon( int y , int x ){

    }
}
