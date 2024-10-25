package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 최장경로_2814 {
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            List<List<Integer>> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n + 1; j++) {
                list.add(new ArrayList<>());
            }
            if (m == 0) {
                System.out.println("#" + (i + 1) + " " + 1);
                continue;
            } else {
                for (int j = 0; j < m; j++) {
                    st = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    list.get(a).add(b);
                    list.get(b).add(a);
                }
//                System.out.println(list);
                for (int j = 1; j < n + 1; j++) {
                    boolean[] visited = new boolean[n + 1];
                    visited[j] = true;
                    backTracking(j, visited, list, 1);
                }
                System.out.println("#" + (i + 1) + " " + result);
            }
            result = 0;
        }
    }

    public static void backTracking(int number, boolean[] visited, List<List<Integer>> list, int count) {
        if (result < count) {
            result = count;
        }
        for (int i = 0; i < list.get(number).size(); i++) {
            int num = list.get(number).get(i);
            if (!visited[num]) {
                visited[num] = true;
                backTracking(num, visited, list, count + 1);
                visited[num] = false;
            }
        }
    }
}
