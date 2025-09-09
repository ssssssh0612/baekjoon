package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식_2961 {
    static List<int[]> list = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        visited = new boolean[n];
        for (int i = 1; i <= n; i++) {
            arr = new int[i];
            backTracking(i, 0, 0);
            // boolean 모두 초기화
            for (int j = 0; j < n; j++) {
                visited[j] = false;
            }
        }
        System.out.println(result);
    }

    public static void backTracking(int maxDepth, int depth, int number) {
        if (maxDepth == depth) {
            // arr 순서대로 곱하기
            int add1 = list.get(arr[0])[0];
            int add2 = list.get(arr[0])[1];
//            System.out.print(arr[0] + " ");
            for (int i = 1; i < arr.length; i++) {
//                System.out.print(arr[i] + " ");
                int num = arr[i];
                int[] check = list.get(num);
                add1 *= check[0];
                add2 += check[1];
                // 0과 1 구하기
            }
//            System.out.println();
            // 이 둘의 차이가 제일 작은거
            result = Math.min(result, Math.abs(add1 - add2));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] && number <= i){
                arr[depth] = i;
                visited[i] = true;
                backTracking(maxDepth, depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
