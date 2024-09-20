package BaekJoon.BackTracking;

import java.util.*;

public class 연구소_3_17142 {
    static int count;
    static int n;
    static int virus;
    static int[][] graph;
    static List<int[]> virusList = new ArrayList<int[]>();
    static List<int[]> zeroList = new ArrayList<>();
    static boolean[] visited;
    static int[] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        virus = sc.nextInt();
        graph = new int[n][n];
        arr = new int[virus*2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 2) {
                    virusList.add(new int[]{i, j});
                }else if ( graph[i][j] == 0 ) {
                    zeroList.add(new int[]{i, j});
                }
            }
        }
        visited = new boolean[virusList.size()];

        backTracking(0,0);
        if( zeroList.isEmpty() ){
            System.out.println(0);
        }else{
            System.out.println(result);
        }
    }
    public static void backTracking( int depth , int index ){
        if( depth == virus * 2 ){
            count++;
            if(count == 1){
                result = virusGraph();
            }else if(virusGraph() == -1){
                if( result > 0){
                    return;
                }else if( result == -1 ){
                    return;
                }
            } else if (virusGraph() >= 0 && result == -1) {
                result = virusGraph();
            } else {
                result = Math.min(virusGraph(), result);
            }
            return;
        }
        for (int i = 0; i < virusList.size(); i++) {
            if(!visited[i] && index <= i ){
                visited[i] = true;
                arr[depth] = virusList.get(i)[0];
                arr[depth+1] = virusList.get(i)[1];
                backTracking(depth + 2 , i );
                visited[i] = false;
            }
        }
    }
    public static int virusGraph(){
        int[][] copyGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if( graph[i][j] == 2 ){
                    // 바이러스
                    copyGraph[i][j] = -2;
                }else if( graph[i][j] == 1 ){
                    // 벽
                    copyGraph[i][j] = -1;
                }
            }
        }
        boolean[][] visitedGraph = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < virus*2; i+=2) {
            queue.offer(new int[]{arr[i], arr[i+1]});
            visitedGraph[arr[i]][arr[i+1]] = true;
            copyGraph[arr[i]][arr[i+1]] = 1;
        }
        boolean flag = false;
        // 활성 바이러스를 -1 로 바꿔줘야함 그래야 계산할 수 있음 ?
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                // 퍼질때 1초 임
                if(checking( nowY , nowX) && !visitedGraph[nowY][nowX] && (copyGraph[nowY][nowX] == 0 || copyGraph[nowY][nowX] == -2)){
                    // 활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 비활성 바이러스가 활성으로 변한다.
                    queue.offer(new int[]{nowY, nowX});
                    visitedGraph[nowY][nowX] = true;
                    copyGraph[nowY][nowX] = copyGraph[now[0]][now[1]] + 1;
                }
            }
        }
        if (checkingGraph0(copyGraph)) {
            flag = true;
        }
        if(flag){
            return numberChecking(copyGraph) - 1;
        }else{
            return -1;
        }
    }
    public static int numberChecking( int[][] checkingGraph ){
        int count = 0;
        for (int i = 0; i < zeroList.size(); i++) {
            if(i == 0){
                count = checkingGraph[zeroList.get(i)[0]][zeroList.get(i)[1]];
            }else{
                count = Math.max(checkingGraph[zeroList.get(i)[0]][zeroList.get(i)[1]],count);
            }
        }
        return count;
    }
    public static boolean checkingGraph0( int[][] checkingGraph ){
        for (int i = 0; i < zeroList.size(); i++) {
            if(checkingGraph[zeroList.get(i)[0]][zeroList.get(i)[1]] == 0){
                return false;
            }
        }
        return true;
    }


    public static boolean checking(int nowY, int nowX){
        return nowY >= 0 && nowY < n && nowX >= 0 && nowX < n;
    }

    public static void viewGraph(int[][] graph){
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
