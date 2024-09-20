package BaekJoon.DataStructure.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멘토링_inflearn {
    static int[][] graph;
    static int result;
    static int[][] newGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        newGraph = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int studentNumber = graph[i][j] - 1; // *번 학생
                newGraph[i][studentNumber] = j + 1;
            }
        }


        for (int i = 0; i < graph[0].length; i++) {
            count(i);
        }
        System.out.println(result);

    }

    public static void count(int number) {
        int[] arr = new int[newGraph.length];
        // 0 부터 끝까지
        for (int i = 0; i < newGraph.length; i++) {
            arr[i] = newGraph[i][number];
        }
        for (int i = 0; i < newGraph[0].length; i++) {
            if (i != number) {
                int count = 0;
                for (int j = 0; j < newGraph.length; j++) {
                    if (arr[j] > newGraph[j][i]) {
                        count++;
                    }
                }
                if (count == newGraph.length) {
                    result++;
                }
            }
        }
    }

    public static void checking() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
