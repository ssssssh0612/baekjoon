package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 누울_자리를_찾아라_1652 {
    static int[][] graph;
    static int garo = 0;
    static int sero = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        checking();
        System.out.println(garo + " " + sero);
    }

    public static void input(BufferedReader br) throws IOException {
        int length = Integer.parseInt(br.readLine());
        graph = new int[length][length];
        for (int i = 0; i < length; i++) {
            String str = br.readLine();
            for (int j = 0; j < length; j++) {
                char ch = str.charAt(j);
                if (ch == 'X') {
                    graph[i][j] = 1;
                } else {
                    graph[i][j] = 0;
                }
            }
        }
    }

    public static void checking() {
        boolean[][] visited = new boolean[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length - 1; j++) {
                int number = graph[i][j];
                if (number == 0) {
                    int number2 = graph[i][j + 1];
                    if (number == number2) {
                        garo++;
                        int index = j;
                        while( index < graph.length - 1){
                            int check = graph[i][index];
                            if(check == 1){
                                break;
                            }else{
                                index++;
                            }
                        }
                        j = index;
                    }
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length - 1; j++) {
                int number = graph[j][i];
                if (number == 0) {
                    int number2 = graph[j + 1][i];
                    if (number == number2) {
                        sero++;
                        int index = j;
                        while( index < graph.length - 1){
                            int check = graph[index][i];
                            if(check == 1){
                                break;
                            }else{
                                index++;
                            }
                        }
                        j = index;
                    }
                }
            }
        }
    }
}
