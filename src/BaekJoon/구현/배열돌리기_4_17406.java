package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 배열돌리기_4_17406 {
    static int[][] graph;
    static int[][] copyGraph;
    static List<int[]> list = new ArrayList<>();
    static boolean[] visited;
    static int[] arr;
    static int RESULT = Integer.MAX_VALUE;
    static int[] rotateDx = {-1};
    static int[] rotateDy = {-1};

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        visited = new boolean[list.size()];
        arr = new int[list.size()];
        backTracking(0);
        System.out.println(RESULT);
    }
    public static void backTracking(int depth){
        if(depth == list.size()){
            for(int i = 0 ; i < depth; i ++){
                int[] pattern = list.get(arr[i]);
                int y = pattern[0];
                int x = pattern[1];
                int rotate = pattern[2];
                rotate(y,x,rotate);
            }
            // 다 돌리고 나서 계산한 후, 최대값 최소값 비교후에
            int numberResult = numberResult();
            RESULT = Math.min(numberResult,RESULT);
            // 그래프 초기화해주기
            copyGraph();
            return;
        }
        for(int i = 0 ; i < list.size(); i++){
            if(!visited[i]){
                arr[depth] = i;
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        copyGraph = new int[y][x];
        for(int i = 0 ; i < y ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < x ; j ++){
                int number = Integer.parseInt(st.nextToken());
                graph[i][j] = number;
                copyGraph[i][j] = number;
            }
        }
        for(int i = 0 ; i < count; i ++){
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int rotate = Integer.parseInt(st.nextToken());
            list.add(new int[]{startY,startX,rotate});
        }
    }

    public static void rotate(int y, int x, int rotate){
        for(int i = 0 ; i < rotate; i++){
            int startPosY = y + rotateDy[0] * (i + 1);
            int startPosX = x + rotateDx[0] * (i + 1);
            // 무조건 범위안에 들어간다고 가정
            startRotate(startPosY, startPosX , (i+1)*2);
        }
    }
    public static void startRotate(int y , int x , int rotateCount){
        // rotateCount 만큼 빙빙 돎
        int startY = y;
        int startX = x;
        int a = graph[startY][startX];
        int b=  0;
        for(int i = 0 ; i < 4; i++){
            for(int j = 0 ; j < rotateCount; j++){
                startY = startY + dy[i];
                startX = startX + dx[i];
                b = graph[startY][startX];
                graph[startY][startX] = a;
                a = b;
            }
        }
    }
    public static int numberResult(){
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < graph.length; i++){
            int number = 0;
            for(int j = 0; j < graph[0].length; j++){
                number += graph[i][j];
            }
            result = Math.min(result,number);
        }
        return result;
    }

    public static void copyGraph(){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                graph[i][j] = copyGraph[i][j];
            }
        }
    }
}
