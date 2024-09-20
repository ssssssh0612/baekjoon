package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 십자가_찾기_16924 {
    static int[][] graph;
    static List<int[]> list = new ArrayList<int[]>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        graph = new int[y + 1][x + 1];
        for (int i = 1; i <= y; i++) {
            String a = sc.next();
            for (int j = 1; j <= x; j++) {
                if (a.charAt(j - 1) == '*') {
                    graph[i][j] = 1;
                }
            }
        }
        // 십자가로 만들 수 있는 애들 모두 만들고 숫자 1씩 더해주기 리스트에 저장하기
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                tenStick(i,j);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]+" "+list.get(i)[2]);
        }

    }

    public static void tenStick(int y, int x) {
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                if (graph[i][j] > 0) {
                    boolean[][] flag = new boolean[4][4];
                    for (int k = 0; k < 4; k++) {
                        int nowY = i + dy[k];
                        int nowX = j + dx[k];
                        for (int l = 1; l <= 3; l++) {
                            if(nowY >= 1 && nowX >= 1 && nowY < graph.length && nowX < graph[0].length
                            && graph[nowY][nowX] >= 1) {
                                flag[l][k] = true;
                            }
                        }
                    }
                    for (int k = 1; k <= 3; k++) {
                        for (int l = 0; l < 4; l++) {
                            if(!flag[l][k]) {
                                break;
                            }
                        }
                        graph[i][j] = graph[i][j] + 1;
                        list.add(new int[]{i,j,k});
                    }
                }
            }
        }

    }
}
