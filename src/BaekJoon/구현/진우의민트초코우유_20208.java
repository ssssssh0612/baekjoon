package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 진우의민트초코우유_20208 {
    static int[][] graph;
    static int[] homePos = new int[2];
    static int m;
    static int h;
    static boolean[] visited;
    static int[] arr;
    static List<int[]> list = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                if(num == 1){
                    homePos[0] = i;
                    homePos[1] = j;
                }else if(num == 2){
                    list.add(new int[]{i,j});
                }
            }
        }
        visited = new boolean[list.size()];
        arr = new int[list.size()];
        backTracking(0);
        System.out.println(result);
    }
    public static boolean checking(int[] nowPos, int[] nextMilk, int nowHp){
        int minus = Math.abs(nowPos[0] - nextMilk[0]) + Math.abs(nowPos[1] - nextMilk[1]);
        return nowHp - minus >= 0;
    }
    public static boolean canGoHome(int[] nowPos, int nowHp){
        return checking(nowPos, homePos, nowHp);
    }
    public static void backTracking(int depth){
        if(list.size() == depth){
            int[] nowPos = new int[]{homePos[0], homePos[1]};
            int nowHp = m;
            // 계속 먹을지, 집에갈지, 못먹는지 확인
            // 초코우유를 최대로 먹을 수 있는 상황 확인
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                int[] nextMilk = list.get(arr[i]);
                // 우유 마실 수 있는지 검사
                if(checking(nowPos, nextMilk, nowHp)){
                    nowHp -= Math.abs(nowPos[0] - nextMilk[0]) + Math.abs(nowPos[1] - nextMilk[1]);
                    nowPos[0] = nextMilk[0];
                    nowPos[1] = nextMilk[1];
                    nowHp += h;
                    if(canGoHome(nowPos, nowHp)){
                        count = i + 1;
                    }
                }else{
                    break;
                }
            }
            result = Math.max(count, result);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }

    }
}
