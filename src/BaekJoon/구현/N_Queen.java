package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen {
    public static int[] graph;
    public static int n;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n];
        nQueen(0);
        System.out.println(result);
    }

    public static void nQueen(int depth) {
        if (depth == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            graph[depth] = i;
            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean Possibility(int col) {
        for (int i = 0; i < col; i++) {
            if (graph[col] == graph[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(graph[col] - graph[i])) {
                return false;
            }
        }
        return true;
    }
}

