package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 컴백홈 {
    static int[][] graph;
    static int k;
    static boolean[] visited;
    static int[] arr;
    static List<int[]> list = new ArrayList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int length = 0 ;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        System.out.println(result);
    }
    public static void input(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        k = Integer.parseInt(st.nextToken());
        arr = new int[k * 2];
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                char ch = str.charAt(j);
                if(ch == '.'){
                    graph[i][j] = 0;
                    list.add(new int[]{i,j});
                }else{
                    graph[i][j] = 1;
                }
            }
        }
        visited = new boolean[list.size()];
        backTracking(0,0);


    }
    public static void dfs(int y, int x, boolean[][] dfsVisited){
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(checking(nextY,nextX) && dfsVisited[nextY][nextX] && graph[nextY][nextX] == 0){
                length++;
                dfsVisited[nextY][nextX] = false;
                dfs(nextY,nextX,dfsVisited);
            }
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
    public static void backTracking(int depth, int index){
        if( depth == k * 2 ){
            // 이 상태에서 dfs 를 돌아아햠
            boolean[][] dfsVisited = new boolean[graph.length][graph[0].length];
            for (int i = 0; i < k * 2; i += 2) {
                int y = arr[i];
                int x = arr[i+1];
                dfsVisited[y][x] = true;
            }
            length++;
            dfsVisited[arr[0]][arr[1]] = false;
            dfs(arr[0],arr[1],dfsVisited);
            if( length == k && checking()){
//                checkingArr();
                result++;
                length = 0 ;
                return;
            }else{
                length = 0 ;
                return;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(!visited[i] && i >= index ){
                arr[depth] = list.get(i)[0];
                arr[depth + 1] = list.get(i)[1];
                visited[i] = true;
                backTracking(depth + 2, i);
                visited[i] = false;
            }
        }
    }
    public static void checkingArr(){
        for (int i = 0; i < arr.length; i += 2) {
            System.out.print(" y = "+arr[i]+ " x = " + arr[i + 1] + " ,");
        }
        System.out.println();
    }
    public static boolean checking(){
        int count = 0 ;
        int[] startPos = new int[2];
        startPos[0] = graph.length - 1;
        startPos[1] = 0;
        int[] endPos = new int[2];
        endPos[0] = 0;
        endPos[1] = graph[0].length - 1;
        for (int i = 0; i < arr.length; i += 2) {
            int y = arr[i];
            int x = arr[i + 1];
            if( (startPos[0] == y && startPos[1] == x)){
                count++;
            }

            if ((endPos[0] == y && endPos[1] == x)) {
                count++;
            }

        }
        if(count == 2){
            return true;
        }else{
            return false;
        }
    }
//    public static void checking(){
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[0].length; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
}
