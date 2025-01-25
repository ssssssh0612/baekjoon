package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_3_13549 {
    static int startNum;
    static int result = 0;
    static boolean flag = false;
    static int endNum;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        startNum = Integer.parseInt(st.nextToken());
        endNum = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(result);
    }
    public static void bfs(){
        visited[startNum] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startNum, 0});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(endNum == now[0]){
                if(!flag){
                    result = now[1];
                    flag = true;
                }else{
                    result = Math.min(now[1],result);
                }
            }
            if(checking(now[0] * 2) && !visited[now[0] * 2]){
                queue.add(new int[]{now[0] * 2, now[1]});
                visited[now[0] * 2] = true;
            }
            if(checking(now[0] + 1) && !visited[now[0] + 1]){
                queue.add(new int[]{now[0] + 1, now[1] + 1});
                visited[now[0] + 1] = true;
            }
            if(checking(now[0] - 1) && !visited[now[0] - 1]){
                queue.add(new int[]{now[0] - 1, now[1]});
                visited[now[0] - 1] = true;
            }

        }
    }
    public static boolean checking(int number){
        return number >= 0 && number < 100001;
    }
}
