package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스타트_택시_2_19238 {
    static int n;
    static int[][] graph;
    static int[] taxiPos = new int[2];
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int fuel;
    static int[] endPos = new int[2];
    static Map<String, String> map = new HashMap<>();
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        int m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j ++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        taxiPos[0] = Integer.parseInt(st.nextToken()) - 1;
        taxiPos[1] = Integer.parseInt(st.nextToken()) - 1;

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;
            map.put(convert(startY, startX), convert(endY, endX));
        }

        while(findPerson()) {
            if (map.isEmpty()) {
                result = fuel;
                break;
            }
            // 목적지 찾기
            if (!findEnd()) {
                result = -1;
                break;
            }
        }

        // 모든 손님을 이동시키고 연료를 충전했을 때 남은 연료의 양을 출력한다.
        System.out.println(result);


    }
    // 찾기 위한 bfs
    public static boolean findPerson(){
        // 현재 남은 연료량과 사용 연료랑을 비교하기
        if(map.isEmpty()){
            return true;
        }
        Queue<int[]> queue = new LinkedList<>();
        int newFuel = 0;
        queue.add(new int[]{taxiPos[0], taxiPos[1]});
        boolean[][] visited = new boolean[n][n];
        while(!queue.isEmpty()){
            int size = queue.size();
            List<int[]> list = new ArrayList<>();

            for(int i = 0 ; i < size; i++){
                int[] now = queue.poll();
                // 승객이 있는경우
                if(map.containsKey(convert(now[0], now[1]))){
                    list.add(now);
                }
                for(int j = 0 ; j < 4; j++){
                    int nextY = now[0] + dy[j];
                    int nextX = now[1] + dx[j];
                    if(checking(nextY, nextX) && (graph[nextY][nextX] == 0) && (!visited[nextY][nextX])){
                        queue.add(new int[]{nextY, nextX});
                        visited[nextY][nextX] = true;
                    }
                }
            }
            // 리스트가 비어있지 않다면
            if(!list.isEmpty()){
                if(newFuel > fuel){
                    result = -1;
                    return false;
                }else{
                    fuel -= newFuel;
                }
                Comparator<int[]> comparator = new Comparator<int[]>(){
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

                String str = map.get(convert(list.get(0)[0], list.get(0)[1]));
                StringTokenizer st = new StringTokenizer(str);
                endPos[0] = Integer.parseInt(st.nextToken());
                endPos[1] = Integer.parseInt(st.nextToken());

                // 택시 위치 옮기기
                taxiPos[0] = list.get(0)[0];
                taxiPos[1] = list.get(0)[1];

                return true;
            }
            newFuel++;
        }
        result = -1;
        return false;
    }
    public static boolean findEnd(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{taxiPos[0], taxiPos[1]});
        boolean[][] visited = new boolean[n][n];
        int newFuel = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++) {
                int[] now = queue.poll();
                if (now[0] == endPos[0] && now[1] == endPos[1]) {
                    if (newFuel > fuel) {
                        return false;
                    } else {
                        map.remove(convert(taxiPos[0], taxiPos[1]));
                        // 택시 위치 옮기기
                        taxiPos[0] = now[0];
                        taxiPos[1] = now[1];

                        fuel -= newFuel;
                        fuel += newFuel * 2;
                        return true;
                    }
                }
                for (int j = 0; j < 4; j++) {
                    int nextY = now[0] + dy[j];
                    int nextX = now[1] + dx[j];
                    if (checking(nextY, nextX) && graph[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                        queue.add(new int[]{nextY, nextX});
                        visited[nextY][nextX] = true;
                    }
                }
            }
            newFuel++;
        }
        return false;
    }

    public static boolean checking(int y , int x){
        return y >= 0 && x >= 0 && y < n && x < n;
    }

    public static String convert(int y, int x){
        return y + " " + x;
    }
}
