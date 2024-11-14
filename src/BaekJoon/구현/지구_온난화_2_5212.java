package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 지구_온난화_2_5212 {
    static int[][] graph;
    static int[][] newGraph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
//    static int startY = 0;
//    static int end = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        step();
//        checkingGraph(graph);
//        checkingGraph(newGraph);
        checking();
    }
    public static void checking(){
        int startX = 0;
        int startY = 0;
        int count = 0;
        boolean check = false;
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph[0].length; j++){
                if( newGraph[i][j] == 1 ){
                    if(count == 0){
                        startX = j;
                        count++;
                    }else {
                        startX = Math.min(j,startX);
                    }
                    break;
                }
            }
        }
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph[0].length; j++){
                if(!check && newGraph[i][j] == 1){
                    startY = i;
                    check = true;
                }
            }
            if(check){
                break;
            }
        }
        int endY = 0;
        int endX = 0;
        for(int i = 0 ; i < graph.length; i ++){
            for(int j = 0 ; j < graph[0].length; j ++){
                if(newGraph[i][j] == 1){
                    if( endY < i ){
                        endY = i;
                    }

                    if( endX < j){
                        endX = j;
                    }
                }
            }
        }
        for(int i = startY ; i <= endY ; i ++){
            for(int j = startX ; j <= endX ; j ++){
                if(newGraph[i][j] == 0){
                    System.out.print(".");
                }else if(newGraph[i][j] == 1){
                    System.out.print("X");
                }
            }
            System.out.println();
        }



    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        newGraph = new int[y][x];
        for(int i = 0; i < y ; i ++){
            String str = br.readLine();
            for(int j = 0 ; j < x; j++){
                char ch = str.charAt(j);
                if( ch == 'X'){
                    graph[i][j] = 1;
                    newGraph[i][j] = 1;
                }else if( ch == '.'){
                    graph[i][j] = 0;
                    newGraph[i][j] = 0;
                }
            }
        }
    }
    public static void step(){
        for(int i = 0; i < graph.length; i ++){
            for(int j = 0 ; j < graph[0].length; j++){
                int number = graph[i][j] ;
                if(number == 1){
                    int count = 0;
                    for(int k = 0 ; k < 4; k ++){
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        if(checking(nextY, nextX) && graph[nextY][nextX] == 0){
                            count++;
                        }else if(!checking(nextY,nextX)){
                            count++;
                        }
                    }
//                    System.out.println("Y = " + i + " X = " + j + " count = "+ count);
                    if( count >= 3){
                        newGraph[i][j] = 0;
                    }
                }
            }
        }
    }
    public static void checkingGraph(int [][] graph){
        System.out.println();
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
