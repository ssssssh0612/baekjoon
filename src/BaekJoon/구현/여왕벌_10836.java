package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 여왕벌_10836 {
    static List<int[]> list = new ArrayList<>();
    static int[][] graph;
    static int time;
    static int[] dx = {-1,-1,0};
    static int[] dy = {0,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        for(int i = 0 ; i < time; i ++){
            feed(i);
//            System.out.println();
//            checkingGraph();
//            System.out.println();
        }
        check();
        checkingGraph();
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = 1;
            }
        }
        time = Integer.parseInt(st.nextToken());

        for (int i = 0; i < time; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }
//        System.out.println(list);
    }

    public static void feed(int timeCheck) {
        // 시간을 매개변수로 받아서 시간에 해당하는 먹이를 List에서 주고
        int[] feedList = list.get(timeCheck);
//        System.out.println(feedList[0]+","+feedList[1]+","+feedList[2]);
//        System.out.println();
        int feedIndex = 0;
        for (int i = graph.length - 1; i >= 0; i--) {
            // 받아온 check 에 대해서 판단하기
            int check = feedList[feedIndex];
            if(check == 0){
                while(true){
                    feedIndex++;
                    if(feedList[feedIndex] > 0){
                        break;
                    }
                }
            }
            feedList[feedIndex]--;
            graph[i][0] += feedIndex;
        }
        for (int i = 1; i < graph.length; i++) {
            int check = feedList[feedIndex];
            if(check == 0){
                while(true){
                    feedIndex++;
                    if(feedList[feedIndex] > 0){
                        break;
                    }
                }
            }
            feedList[feedIndex]--;
            graph[0][i] += feedIndex;
        }
//        System.out.println(feedList[0]+","+feedList[1]+","+feedList[2]);
//        checkingGraph();
    }

    public static void check(){
        for(int i = 1 ; i < graph.length; i ++){
            for(int j = 1; j < graph.length; j++){
                int max = Integer.MIN_VALUE;
                for(int k = 0; k < 3; k++){
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    int number = graph[nextY][nextX];
                    if(number > max){
                        max = number;
                    }
                }
                graph[i][j] = max;
            }
        }
    }

    public static void checkingGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


}
