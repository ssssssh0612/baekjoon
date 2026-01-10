package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 제곱수찾기_1025 {
    static int[][] graph;
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        List<int[]> list = new ArrayList<>();
        for (int i = -8; i < 9; i++) {
            for (int j = -8; j < 9; j++) {
                if(i == 0 && j == 0) continue;
                list.add(new int[]{i, j});
            }
        }
        Set<String> set = new HashSet<>();
        int count = 1;
        set.add("0");
        while(true){
            if(count*count < 1_000_000_000){
                set.add(String.valueOf(count*count));
                count++;
            }else{
                break;
            }
        }
        int size = list.size();
        int result = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 여기서 list로 돌렸을때 값이 제대로 나오는지 확인하면됨
                int nowY = i;
                int nowX = j;
                for (int k = 0; k < size; k++) {
                    StringBuilder sb = new StringBuilder().append(graph[i][j]);
                    int[] pos = list.get(k);
                    int nextY = nowY + pos[0];
                    int nextX = nowX + pos[1];
                    while(checking(nextY, nextX)){
                        sb.append(graph[nextY][nextX]);
                        nextY = nextY + pos[0];
                        nextX = nextX + pos[1];
                        if(set.contains(sb.toString()) && Integer.parseInt(sb.toString()) > result){
                            result = Integer.parseInt(sb.toString());
                        }
                    }
                    if(set.contains(sb.toString()) && Integer.parseInt(sb.toString()) > result){
                        result = Integer.parseInt(sb.toString());
                    }
                }
            }
        }

        System.out.println(result);
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;

    }

}

