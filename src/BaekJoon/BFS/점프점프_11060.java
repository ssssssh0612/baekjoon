package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프점프_11060 {
    static int[] arr;
    static int length;
    static boolean[][] visited;
    static boolean checking = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        bfs();
        if(!checking){
            System.out.println(-1);
        }
    }
    public static void input(BufferedReader br ) throws IOException {
        length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[length];
        for(int i = 0 ; i < length; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[1000][100];
    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{arr[0], 0});
        visited[arr[0]][0] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == length - 1){
                checking = true;
                System.out.println(now[1]+1);
                return;
            }
            for(int i = 1 ; i <= now[0]; i++){
                int next = now[0] + i;
                if(checking(next) && !visited[now[0]][i]){
                    queue.add(new int[]{next, now[1] + 1});
                    visited[now[0]][i] = true;
                }
            }
        }
    }
    public static boolean checking(int number){
        return number >= 0 && number < arr.length;
    }
}
