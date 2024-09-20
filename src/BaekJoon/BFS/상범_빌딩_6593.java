package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 상범_빌딩_6593 {
    // 금으로 막혀있어 지나갈 수 없는 칸은 '#'으로 표현되고,
    // 비어있는 칸은 '.'으로 표현된다.
    // 당신의 시작 지점은 'S'로 표현되고,
    // 탈출할 수 있는 출구는 'E'로 표현된다.
    // 상, 하, 좌, 우, 위, 아래
    static int[] dz = {0,0,0,0,-1,1};
    static int[] dy = {-1,1,0,0,0,0};
    static int[] dx = {0,0,-1,1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            int[] startPos = new int[3];
            int[] endPos = new int[3];
            int[][][] graph;
            int z = sc.nextInt();
            int y = sc.nextInt();
            int x = sc.nextInt();
            graph = new int[z][y][x];
            if (z == 0 && y == 0 && x == 0) {
                flag = false;
                break;
            }
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < y; j++) {
                    String a = sc.next();
                    for (int k = 0; k < x; k++) {
                        // 시작점
                        if( a.charAt(k) == 'S'){
                            startPos[0] = i;
                            startPos[1] = j;
                            startPos[2] = k;
                        }else if(a.charAt(k) == 'E'){ // 종점
                            endPos[0] = i;
                            endPos[1] = j;
                            endPos[2] = k;
                        }else if(a.charAt(k) == '#'){ // 지나갈 수 있는
                            graph[i][j][k] = -1;
                        }
                    }
                }
            }
            int number = bfs(startPos[0],startPos[1],startPos[2],graph,endPos[0],endPos[1],endPos[2]);
            if( number == 0 ){
                System.out.println("Trapped!");
            }else{
                System.out.println("Escaped in "+number+" minute(s).");
            }
        }
    }
    public static int bfs( int z, int y, int x, int[][][] graph, int endZ, int endY, int endX){
        boolean[][][] visited = new boolean[graph.length][graph[0].length][graph[0][0].length];
        visited[z][y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{z,y,x});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nowZ = now[0] + dz[i];
                int nowY = now[1] + dy[i];
                int nowX = now[2] + dx[i];
                if(nowZ >= 0 && nowY >= 0 && nowX >= 0 && nowZ < graph.length && nowY < graph[0].length && nowX < graph[0][0].length
                    && graph[nowZ][nowY][nowX] == 0 && !visited[nowZ][nowY][nowX]){
                    visited[nowZ][nowY][nowX] = true;
                    queue.offer(new int[]{nowZ,nowY,nowX});
                    graph[nowZ][nowY][nowX] = graph[now[0]][now[1]][now[2]] + 1;
                }
            }
        }
        return graph[endZ][endY][endX];
    }
}
