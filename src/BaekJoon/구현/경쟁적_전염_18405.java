package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 경쟁적_전염_18405 {
    static int[][] graph;
    static PriorityQueue<int[]> queue;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 큐 개수만큼 for 문 돌고
        StringTokenizer st = new StringTokenizer(br.readLine());
        Comparator<int[]> comparator = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        };
        queue = new PriorityQueue<>(comparator);
        int n = Integer.parseInt(st.nextToken());
        // k 종류
        int k = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] > 0){
                    queue.add(new int[]{i,j,graph[i][j]});
                }
            }
        }

        // s 초 뒤에
        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken()) - 1;
        int endX = Integer.parseInt(st.nextToken()) - 1;
        add(time);
        System.out.println(graph[endY][endX]);

    }
    public static void add(int time){

        while(!queue.isEmpty() && time > 0){
            int size = queue.size();
            time--;
            Queue<int[]> queue1 = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
//                System.out.println("now2 = " + now[2]);
                for (int j = 0; j < 4; j++) {
                    int nowY = now[0] + dy[j];
                    int nowX = now[1] + dx[j];
                    if(checking(nowY, nowX) && graph[nowY][nowX] == 0){
                        queue1.add(new int[]{nowY,nowX,now[2]});
                        graph[nowY][nowX] = now[2];
                    }
                }
            }
            while(!queue1.isEmpty()){
                queue.add(queue1.poll());
            }
//            checkingGraph();
        }

    }
    public static void checkingGraph(){
        System.out.println();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean checking(int y, int x){
        return y>=0 && x>=0 && y < graph.length && x < graph.length;
    }
}
