package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 아기상어_2 {
    static int fishUp = 0;
    static int fishSize = 2;
    static int[] pos = new int[2];
    static int[][] graph;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 9){
                    pos[0] = i;
                    pos[1] = j;
                }else{
                    graph[i][j] = num;
                }
            }
        }

        while(true){
            if(bfs(pos[0],pos[1])){
                continue;
            }else{
                break;
            }
        }

        System.out.println(result);
    }
    public static boolean bfs(int startY , int startX ){
//        checking();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[graph.length][graph.length];
        queue.add(new int[]{startY, startX});
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<int[]> list = new ArrayList<>();
            // 큐에 추가하는데
            for(int i = 0 ; i < size; i++){
                int[] now =  queue.poll();
                int fish = graph[now[0]][now[1]];
                if(fish != 0 && fish < fishSize){
                    list.add(now);
                }
                for(int j = 0 ; j < 4; j++){
                    int nextY = now[0] + dy[j];
                    int nextX = now[1] + dx[j];
                    if (checking(nextY, nextX) && !visited[nextY][nextX]
                            && ((graph[nextY][nextX] == 0) || (fishSize >= graph[nextY][nextX]))) {
                        queue.add(new int[]{nextY, nextX});
                        visited[nextY][nextX] = true;
                    }
                }
            }

            if(!list.isEmpty()){
                // 현재 리스트 Comparator 해서 물고기 하나잡기
                Comparator<int[]> comparator = new Comparator<>(){
                    @Override
                    public int compare(int[] o1, int[] o2){
                        int result = o1[0] - o2[0];
                        if(result != 0){
                            return result;
                        }
                        return o1[1] - o2[1];
                    }
                };
                list.sort(comparator);
                int[] arr = list.get(0);
                // 이 위치 물고기 먹고
                fishUp++;
                if(fishUp == fishSize){
                    fishUp = 0;
                    fishSize++;
                }

                graph[arr[0]][arr[1]] = 0;
                pos[0] = arr[0];
                pos[1] = arr[1];
                result += time;
//                System.out.println(time);
                return true;
            }
            // 만약 사이즈가 현재 상어보다 작다면 list에도 추가해서 여기서 가장 작은
            time++;
            if(time > (graph.length * graph.length) - 1){
                break;
            }
        }
        return false;
    }
    public static void checking(){
        System.out.println();
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph.length; j++){
                if(i == pos[0] && j == pos[1]){
                    System.out.print("@" + " ");
                    continue;
                }
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static boolean checking(int y , int x){
        return y >= 0  && x >= 0 && y < graph.length && x < graph.length;
    }

}
