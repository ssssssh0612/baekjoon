package BaekJoon.BFS;

// 12시 24분 시작
// 13시 04분 제출
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 탈출_3055 {
    static int[] startPos = new int[2];
    static int[] endPos = new int[2];
    static List<int[]> waterList = new ArrayList<>();
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        bfs();
        if(!flag){
            System.out.println("KAKTUS");
        }
    }

    public static void input(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for(int i = 0; i < y; i ++){
            String str = br.readLine();
            for(int j = 0 ; j < x; j ++){
                char ch = str.charAt(j);
                if( ch == 'S'){
                    graph[i][j] = 0;
                    startPos[0] = i;
                    startPos[1] = j;
                }else if(ch == 'X'){
                    graph[i][j] = -1;
                }else if(ch == '*'){
                    graph[i][j] = -2;
                    waterList.add(new int[]{i,j});
                }else if(ch == 'D'){
                    graph[i][j] = 0;
                    endPos[0] = i;
                    endPos[1] = j;
                }else{
                    graph[i][j] = 0;
                }
            }
        }
//        checkingGraph();
    }
    public static void checkingGraph(){
        System.out.println();
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        // 0이면 도치 1이면 물
        // 마지막이 카운트
        boolean[][] waterPos = new boolean[graph.length][graph[0].length];
        queue.add(new int[]{startPos[0], startPos[1], 0, 0});
        for(int i = 0 ; i < waterList.size(); i ++){
            int y = waterList.get(i)[0];
            int x = waterList.get(i)[1];
            queue.add(new int[]{y, x, 1});
            waterPos[y][x] = true;
        }

        while(!queue.isEmpty()){
//            checkingGraph();
            // 현재 큐에서 뽑았음 이게 고슴도치인지, 물인지 판단해야함
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];
            // 고슴도치인 경우
            if( now[2] == 0 && graph[nowY][nowX] != -2 ){ // 다음 장소가 0이면 다음 장소로 옮김
                // 같다면 종료해야함
                if( nowY == endPos[0] && nowX == endPos[1] ){
                    flag = true;
                    System.out.println(now[3]);
                    return;
                }
                for(int i = 0; i < 4; i ++){
                    int nextY = nowY + dy[i];
                    int nextX = nowX + dx[i];
                    if(checking(nextY,nextX) && graph[nextY][nextX] == 0){
                        queue.add(new int[]{nextY, nextX, 0, now[3]+1});
                        graph[nextY][nextX] = now[3] + 1;
                    }
                }
            }else{
                // 물인경우 바위와 비버굴이 아닌이상 이동가능
                for(int i = 0; i < 4; i ++){
                    int nextY = nowY + dy[i];
                    int nextX = nowX + dx[i];
                    if(checking(nextY,nextX) && !checkingPos(nextY,nextX)
                            && graph[nextY][nextX] != -1 && !waterPos[nextY][nextX]){
                        graph[nextY][nextX] = -2;
                        queue.add(new int[]{nextY,nextX,1});
                        waterPos[nextY][nextX] = true;
                    }
                }
            }
        }
    }
    public static boolean checkingPos(int y, int x){
        return y == endPos[0] && x == endPos[1];
    }

    public static boolean checking(int y ,int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
