package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 폴링_17829 {
    static int[][] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        step(arr);
        System.out.println(result);
    }
    public static void step(int[][] graph){
        if(graph.length == 2){
            int num = 0;
            int[] numArr = new int[4];
            int index = 0;
            for (int k = 0; k < 2; k++) {
                for (int l = 0; l < 2; l++) {
                    // 이중에 두번째 수 찾기
                    numArr[index] = graph[k][l];
                    index++;
                }
            }
            Arrays.sort(numArr);
            result = numArr[2];
            return;
        }

        int[][] newGraph = new int[graph.length / 2][graph.length / 2];
        for (int i = 0; i < graph.length; i +=2 ) {
            for (int j = 0; j < graph.length; j+= 2) {
                int num = 0;
                int[] numArr = new int[4];
                int index = 0;
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        // 이중에 두번째 수 찾기
                        numArr[index] = graph[i + k][j + l];
                        index++;
                    }
                }
                Arrays.sort(numArr);
                num = numArr[2];
                newGraph[i/2][j/2] = num;
            }
        }
//        for (int i = 0; i < newGraph.length; i++) {
//            for (int j = 0; j < newGraph.length; j++) {
//                System.out.print(newGraph[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        step(newGraph);
    }
}
