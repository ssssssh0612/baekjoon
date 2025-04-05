package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 사탕_게임_3085 {
    static char[][] graph;
    static List<int[]> list = new ArrayList<>();
    static boolean[] visited;
    static int[] arr = new int[2];
    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        graph = new char[length][length];
        for (int i = 0; i < length; i++) {
            String str = br.readLine();
            for (int j = 0; j < length; j++) {
                char ch = str.charAt(j);
                list.add(new int[]{i, j});
                graph[i][j] = ch;
            }
        }
        visited = new boolean[list.size()];

        step();

        System.out.println(result);
    }

    public static void step(){

        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph.length - 1; j++){
                // pos1, pos2
                checking(new int[]{i, j}, new int[]{i, j+1});

            }
        }
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph.length - 1; j++){
                // pos1, pos2
//                System.out.println(j + " " + i);
//                System.out.println((j + 1) + " " + i);
                checking(new int[]{j, i}, new int[]{j + 1, i});
            }
        }


    }

    public static void checking(int[] pos1, int[] pos2) {

        char ch1 = graph[pos1[0]][pos1[1]];
        char ch2 = graph[pos2[0]][pos2[1]];
        if (ch1 == ch2) {
            return;
        }

        graph[pos2[0]][pos2[1]] = ch1;
        graph[pos1[0]][pos1[1]] = ch2;

        // 둘이 바꾸고 가장 긴거 찾기
        result = Math.max(result, checkNum(1));
        result = Math.max(result, checkNum(2));
        result = Math.max(result, checkNum(3));
        result = Math.max(result, checkNum(4));

        // 다시 바꿔놓기
        graph[pos2[0]][pos2[1]] = ch2;
        graph[pos1[0]][pos1[1]] = ch1;
    }

    public static int checkNum(int num) {
        char ch = ' ';
        if (num == 1) {
            ch = 'C';
        } else if (num == 2) {
            ch = 'P';
        } else if (num == 3) {
            ch = 'Z';
        } else {
            ch = 'Y';
        }
        int lastNum = 0;
        for (int i = 0; i < graph.length; i++) {
            int count = 0;
            for (int j = 0; j < graph.length; j++) {
                if(ch == graph[i][j]){
                    count++;
                }else{
                    lastNum = Math.max(lastNum, count);
                    count = 0;
                }
            }
            lastNum = Math.max(lastNum, count);
        }

        for (int i = 0; i < graph.length; i++) {
            int count = 0;
            for (int j = 0; j < graph.length; j++) {
                if(ch == graph[j][i]){
                    count++;
                }else{
                    lastNum = Math.max(lastNum, count);
                    count = 0;
                }
            }
            lastNum = Math.max(lastNum, count);
        }
        return lastNum;
    }
}
