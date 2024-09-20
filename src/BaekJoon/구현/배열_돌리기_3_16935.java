package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 배열_돌리기_3_16935 {
    static int y;
    static int x;
    static int count;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());
        graph = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            int a = Integer.parseInt(st.nextToken());
            if( a == 1){
                one();
            }else if( a == 2){
                two();
            }else if( a == 3){
                three();
            }else if( a == 4){
                four();
            }else if( a == 5){
                five();
            }else{
                six();
            }
        }
        checking();

    }
    public static void checking(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] copyGraph() {
        int[][] copyGraph = new int[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                copyGraph[i][j] = graph[i][j];
            }
        }
        return copyGraph;
    }
    public static void one(){
        int[][] copyGraph = copyGraph();
        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < graph.length; j++) {
                list.add(copyGraph[j][i]);
            }
            int number = graph.length - 1;
            for (int j = list.size() - 1; j >= 0 ; j--) {
                graph[number - j][i] = list.get(j);
            }
        }
    }
    public static void two(){
        int[][] copyGraph = copyGraph();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < graph[0].length; j++) {
                list.add(copyGraph[i][j]);
            }
            int number = 0;
            for (int j = list.size() - 1; j >= 0; j--) {
                graph[i][number] = list.get(j);
                number++;
            }
        }
    }
    public static void three(){
        int[][] newGraph = new int[graph[0].length][graph.length];
        int[][] copyGraph = copyGraph();

        for (int i = 0; i < graph[0].length ; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = graph.length - 1; j >= 0; j--) {
                list.add(copyGraph[j][i]);
            }
            for (int j = 0; j < graph.length; j++) {
                newGraph[i][j] = list.get(j);
            }
        }
        graph = newGraph;
    }
    public static void four(){
        int[][] copyGraph = copyGraph();
        int[][] newGraph = new int[graph[0].length][graph.length];
        int number = 0;
        for (int i = graph[0].length - 1; i >=0 ; i--) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < graph.length; j++) {
                list.add(copyGraph[j][i]);
            }
            for (int j = 0; j < list.size(); j++) {
                newGraph[number][j] = list.get(j);
            }
            number++;
        }
        graph = newGraph;
    }
    public static void five(){
        int[][] copyGraph = copyGraph();
        int nowY = graph.length / 2 ;
        int nowX = graph[0].length / 2 ;
        // step 1
        for (int i = 0; i < nowY; i++) {
            for (int j = 0; j < nowX; j++) {
                graph[i][j+nowX] = copyGraph[i][j];
            }
        }
        // step 2
        for (int i = 0; i < nowY; i++) {
            for (int j = nowX; j < graph[0].length; j++) {
                graph[i + nowY][j] = copyGraph[i][j];
            }
        }
        // step 3
        for (int i = nowY; i < graph.length; i++) {
            for (int j = nowX; j < graph[0].length; j++) {
                graph[i][j - (nowX)] = copyGraph[i][j];
            }
        }

        // step 4
        for (int i = nowY; i < graph.length; i++) {
            for (int j = 0; j < nowX; j++) {
                graph[i - (nowY)][j] = copyGraph[i][j];
            }
        }

    }
    public static void six(){
        int[][] copyGraph = copyGraph();
        int nowY = graph.length / 2 ;
        int nowX = graph[0].length / 2 ;
        // step 1
        for (int i = 0; i < nowY; i++) {
            for (int j = 0; j < nowX; j++) {
                graph[i + nowY][j] = copyGraph[i][j];
            }
        }
        // step 2
        for (int i = 0; i < nowY; i++) {
            for (int j = nowX; j < graph[0].length; j++) {
                graph[i][j - nowX] = copyGraph[i][j];
            }
        }
        // step 3
        for (int i = nowY; i < graph.length; i++) {
            for (int j = nowX; j < graph[0].length; j++) {
                graph[i - nowY][j] = copyGraph[i][j];
            }
        }
        // step 4
        for (int i = nowY; i < graph.length; i++) {
            for (int j = 0; j < nowX; j++) {
                graph[i][j+nowX] = copyGraph[i][j];
            }
        }
    }
}
