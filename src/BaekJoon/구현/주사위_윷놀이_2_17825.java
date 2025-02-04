package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 주사위_윷놀이_2_17825 {
    static class Horse{
        int y;
        int x;
        boolean finished;
        public Horse(int y, int x){
            this.y = y;
            this.x = x;
            finished = false;
        }
    }
    static boolean[][] visited;
    static int[][] graph;
    static int[] order = new int[10];
    static int[] arr = new int[10];
    static int count = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new int[4][];
        visited = new boolean[4][];
        int[] arr1 = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
        // 1,4
        int[] arr2 = new int[]{10, 13, 16, 19, 25, 30, 35, 40};
        // 2,3
        int[] arr3 = new int[]{20, 22, 24, 25, 30, 35, 40};
        // 3,4
        int[] arr4 = new int[]{30, 28, 27, 26, 25, 30, 35, 40};
        graph[0] = arr1;
        visited[0] = new boolean[arr1.length];
        graph[1] = arr2;
        visited[1] = new boolean[arr2.length];
        graph[2] = arr3;
        visited[2] = new boolean[arr3.length];
        graph[3] = arr4;
        visited[3] = new boolean[arr4.length];
        for(int i = 0 ; i < 10; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backTracking(0);
        System.out.println(count);
    }
    public static void backTracking(int depth){
        if(depth == 10){
            // 말을 움직이게함
            int compare = 0;
            List<Horse> horseList = new ArrayList<>();
            for(int i = 0 ; i < 4; i++){
                horseList.add(new Horse(0,0));
            }
            for(int i = 0 ; i < 10 ; i++){
                int nextStep = arr[i];
                // 움직일 말 갖고오기
                Horse horse = horseList.get(order[i]);
                int nowY = horse.y;
                int nowX = horse.x;
                // 갖고온 말이 이미 끝난상태인데 순서가 있다면 제외
                if (horse.finished) {
                    break;
                }
                int nextY = horse.y;
                int nextX = horse.x + nextStep;

                if (graph[nextY].length <= nextX) {
                    horse.finished = true;
                    visited[nowY][nowX] = false;
                    continue;
                }

                if(graph[nextY][nextX] == 10 && !visited[1][0]){
                    visited[1][0] = true;
                    visited[nowY][nowX] = false;
                    horse.y = 1;
                    horse.x = 0;
                    compare += 10;
                }else if(graph[nextY][nextX] == 20 && !visited[2][0]){
                    visited[2][0] = true;
                    visited[nowY][nowX] = false;
                    horse.y = 2;
                    horse.x = 0;
                    compare += 20;
                }else if(graph[nextY][nextX] == 30 && !visited[3][0]){
                    visited[3][0] = true;
                    visited[nowY][nowX] = false;
                    horse.y = 3;
                    horse.x = 0;
                    compare += 30;
                }else if(graph[nextY][nextX] == 25){
                    // 1,4 2,3 3,4
                    if(!visited[1][4] && !visited[2][3] && !visited[3][4]){
                        visited[nextY][nextX] = true;
                        visited[nowY][nowX] = false;
                        horse.y = nextY;
                        horse.x = nextX;
                        compare += 25;
                    }else{
                        break;
                    }
                }else if(graph[nextY][nextX] == 30){
                    if(!visited[1][5] && !visited[2][4] && !visited[3][5]){
                        visited[nextY][nextX] = true;
                        visited[nowY][nowX] = false;
                        horse.y = nextY;
                        horse.x = nextX;
                        compare += 30;
                    }else{
                        break;
                    }
                }else if(graph[nextY][nextX] == 35){
                    if(!visited[1][6] && !visited[2][5] && !visited[3][6]){
                        visited[nextY][nextX] = true;
                        visited[nowY][nowX] = false;
                        horse.y = nextY;
                        horse.x = nextX;
                        compare += 35;
                    }else{
                        break;
                    }
                } else if(graph[nextY][nextX] == 40){
                    if(!visited[1][7] && !visited[2][6] && !visited[3][7]){
                        visited[nextY][nextX] = true;
                        visited[nowY][nowX] = false;
                        horse.y = nextY;
                        horse.x = nextX;
                        compare += 40;
                    }else{
                        break;
                    }
                }else if(!visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    visited[nowY][nowX] = false;
                    horse.y = nextY;
                    horse.x = nextX;
                    compare += graph[nextY][nextX];
                }else{
                    break;
                }
            }

            for(int i = 0 ; i < visited.length; i++){
                Arrays.fill(visited[i], false);
            }

            count = Math.max(compare, count);
            return;
        }
        for(int i = 0 ; i < 4; i++){
            order[depth] = i;
            backTracking(depth + 1);
        }
    }
}
