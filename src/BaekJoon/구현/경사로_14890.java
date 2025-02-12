package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 경사로_14890 {
    static int[][] graph1;
    static int[][] graph2;
    static int k;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph1 = new int[n][n];
        graph2 = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                int number = Integer.parseInt(st.nextToken());
                graph1[i][j] = number;
            }
        }

        for(int i = 0 ; i < n ; i++){
            int index = n - 1;
            for(int j = 0 ; j < n ; j++){
                graph2[i][j] = graph1[index][i];
                index--;
            }
        }

        step(graph1);
//        System.out.println(result);

        step(graph2);
//        System.out.println(result);


        System.out.println(result);

    }
    public static void step(int[][] graph){
        for(int i = 0 ; i < graph.length; i++){
            boolean[] visited = new boolean[graph.length];
            for(int j = 0 ; j < graph.length - 1; j++){
                int nowNum = graph[i][j];
                int nextNum = graph[i][j+1];
                if(nowNum == nextNum && j == graph.length - 2){
                    result++;
                    continue;
                }
                if(nowNum == nextNum) continue;
                if(Math.abs(nowNum - nextNum) == 1){
                    // 둘의 차이가 절댓값 1과 같다면
                    // 올라가는지 내려가는지 체크
                    // 경사로가 올라감
                    if(nowNum - nextNum < 0){
                        // 체킹해야할것
                        int startCheck = j - k + 1;
                        // 범위안에 안들면 break;
                        if(!checking(startCheck)) break;
                        boolean flag = true;
                        for(int z = startCheck; z <= j; z++){
                            int checkNum = graph[i][z];
                            if(!(!visited[z] && checkNum == nowNum)){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            for(int z = startCheck; z <= j; z++){
                                visited[z] = true;
                            }
                        }else{
                            break;
                        }
                    }else{
                        // 경사로가 내려감
                        int endCheck = j + k;
                        if(!checking(endCheck)) break;
                        boolean flag = true;
                        for(int z = j + 1; z <= endCheck; z++){
                            int checkNum = graph[i][z];
                            if(!(!visited[z] && checkNum == nextNum)){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            for(int z = j + 1; z <= endCheck; z++){
                                visited[z] = true;
                            }
                        }else{
                            break;
                        }
                    }
                }else{
                    break;
                }
                if( j == graph.length - 2){
                    result++;
                }
            }
        }
    }

    public static void checking(int[][] graph){
        for(int i = 0 ; i < graph.length ; i++){
            for(int j = 0 ; j < graph.length ; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean checking(int number){
        return number >= 0 && number < graph1.length;
    }

}
