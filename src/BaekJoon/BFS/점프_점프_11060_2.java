package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프_점프_11060_2 {
    static int[] arr;
    static boolean[] visited;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        bfs();
        if( !flag ){
            System.out.println(-1);
        }
    }
    public static void input(BufferedReader br) throws IOException {
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[length];
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{arr[0], 0, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int length = now[0];
            int index = now[1];
            int count = now[2];
            if (index == arr.length - 1) {
                flag = true;
                System.out.println(count);
                break;
            }
            for (int i = 1; i <= length; i++) {
                int nextIndex = i + index;
//                System.out.println("length = " + length + " index = " + index + " count = " + count + " nextIndex = " + nextIndex);
                if (checking(nextIndex) && !visited[nextIndex]) {
                    visited[nextIndex] = true;
                    queue.add(new int[]{arr[nextIndex], nextIndex, count + 1});
                }
            }
        }
    }

    public static boolean checking(int index) {
        return index >= 0 && index < arr.length;
    }
}
