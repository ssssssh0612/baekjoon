package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다리만들기_2146 {
    static int[][] graph ;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    static int resultCount = Integer.MAX_VALUE;
    static List<List<int[]>> numberList = new ArrayList<>();
    static int[] arr;
    static int number;
    static boolean[] arrVisited;
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[graph.length][graph.length];
        for(int i = 0 ; i < graph.length ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < graph.length; j ++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        number = 1;
        numberList.add(new ArrayList<>());
        for(int i = 0; i < graph.length; i++){
            for(int j = 0 ; j < graph.length; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    bfs(i,j,number);
                    number++;
                }
            }
        }
        number--;
        arrVisited = new boolean[number + 1];
        arr = new int[2];
        backTracking(0, 0);
        System.out.println(resultCount - 1);
    }
    public static void backTracking(int depth, int nextNumber){
        if(depth == 2){
            twoNumberBFS(arr[0], arr[1]);
            return;
        }
        for(int i = 1; i <= number; i++){
            if(!arrVisited[i] && i >= nextNumber){
                arrVisited[i] = true;
                arr[depth] = i;
                backTracking(depth + 1, i);
                arrVisited[i] = false;
            }
        }
    }
    public static void twoNumberBFS(int number1, int number2){
        List<int[]> list1 = numberList.get(number1);
        List<int[]> list2 = numberList.get(number2);
        for(int i = 0 ; i < list1.size(); i++){
            int[] arr1 = list1.get(i);
            for(int j = 0 ; j < list2.size(); j++){
                int[] arr2 = list2.get(j);
                int shortDis = bfs(arr1[0], arr1[1], arr2[0], arr2[1]);
                resultCount = Math.min(shortDis, resultCount);
            }
        }
    }

    public static int bfs(int y, int x, int resultY1, int resultX1){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x, 0});
        boolean[][] newVisited = new boolean[graph.length][graph.length];
        newVisited[y][x] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if((now[0] == resultY1) && (now[1] == resultX1)){
                return now[2];
            }
            for(int i = 0 ; i < 4; i ++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && !newVisited[nextY][nextX]){
//                    System.out.println("nextY = " + nextY + " nextX = "+ nextX);
                    queue.add(new int[]{nextY, nextX, now[2] + 1});
                    newVisited[nextY][nextX] = true;
                }
            }
        }
        return 0;
    }


    public static void bfs(int y, int x, int number){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{y,x});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4; i++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && !visited[nextY][nextX] && graph[nextY][nextX] == 1){
                    queue.add(new int[]{nextY, nextX});
                    list.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }
        numberList.add(new ArrayList<>());
        for(int i = 0 ; i < list.size(); i ++){
            int[] arr1 = list.get(i);
            numberList.get(number).add(arr1);
            graph[arr1[0]][arr1[1]] = number;
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }
}
