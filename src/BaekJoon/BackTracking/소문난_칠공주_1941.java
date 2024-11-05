package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 소문난_칠공주_1941 {
    static List<int[]> somList = new ArrayList<>();
    static List<int[]> yeonList = new ArrayList<>();
    static int[] result = new int[14];
    static int resultCount = 0 ;
    static List<List<int[]>> yeonLists = new ArrayList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        if(somList.size() == 4){
            // 4 해봐야함
            // 4로 백트래킹 후 3 으로 백트래킹 그리고 해당 좌표들에대해서 dfs해보았을때 7이면 count
            boolean[] visited4 = new boolean[somList.size()];
            somBackTracking(0,8,visited4,0);
        }else if(somList.size() == 5){
            // 4,5 해봐야함
            boolean[] visited4 = new boolean[somList.size()];
            somBackTracking(0,8,visited4,0);
            boolean[] visited5 = new boolean[somList.size()];
            somBackTracking(0,10,visited5,0);
        }else if(somList.size() == 6){
            // 4,5,6 다 해봐야함
            boolean[] visited4 = new boolean[somList.size()];
            somBackTracking(0,8,visited4,0);
            boolean[] visited5 = new boolean[somList.size()];
            somBackTracking(0,10,visited5,0);
            boolean[] visited6 = new boolean[somList.size()];
            somBackTracking(0,12,visited6,0);
        }else if(somList.size() > 6){
            boolean[] visited4 = new boolean[somList.size()];
            somBackTracking(0,8,visited4,0);
            boolean[] visited5 = new boolean[somList.size()];
            somBackTracking(0,10,visited5,0);
            boolean[] visited6 = new boolean[somList.size()];
            somBackTracking(0,12,visited6,0);
            boolean[] visited7 = new boolean[somList.size()];
            somBackTracking(0,14,visited7,0);
        }
        System.out.println(resultCount);
    }
    // 4 5 6 로 백트래킹 하고나서
    public static void somBackTracking(int depth, int length, boolean[] visited, int number){
        if(depth == length){
            if(length == 8){ // 4
                boolean[] visitedYeon = new boolean[yeonList.size()];
                // 3개를 뽑아야 할때,
                yeonBackTracking(8,14,visitedYeon,0);
            }else if(length == 10){ // 5
                boolean[] visitedYeon2 = new boolean[yeonList.size()];
                yeonBackTracking(10,14,visitedYeon2,0);
            }else if(length == 12){ // 6
                boolean[] visitedYeon3 = new boolean[yeonList.size()];
                yeonBackTracking(12,14,visitedYeon3,0);
            }else if(length == 14){
                bfs();
            }
            return;
        }
        for(int i = 0 ; i < somList.size(); i++){
            if(!visited[i] && i >= number){
                visited[i] = true;
                result[depth] = somList.get(i)[0];
                result[depth +1] = somList.get(i)[1];
                somBackTracking(depth + 2, length , visited, i);
                visited[i] = false;
            }
        }
    }
    public static void yeonBackTracking(int depth, int length, boolean[] visited, int number){
        if(depth == length){
            // result 가 꽉 차있는 상태로 dfs를 돌려봄
            bfs();
            return;
        }
        for(int i = 0 ; i < yeonList.size(); i++){
            if(!visited[i] && i >= number){
                visited[i] = true;
                result[depth] = yeonList.get(i)[0];
                result[depth + 1] = yeonList.get(i)[1];
                yeonBackTracking(depth + 2, length, visited, i);
                visited[i] = false;
            }
        }
    }
    public static void bfs(){
        boolean[][] visited = new boolean[5][5];
        int[][] graph = new int[5][5];
        for(int i = 0 ; i < 14; i += 2){
            graph[result[i]][result[i+1]] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{result[0],result[1]});
        visited[result[0]][result[1]] = true;
        int count = 1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4; i++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY,nextX) && !visited[nextY][nextX] && graph[nextY][nextX] == 1){
                    queue.add(new int[]{nextY,nextX});
                    visited[nextY][nextX] = true;
                    count++;
                }
            }
        }
        if(count == 7){
            resultCount++;
//            for(int i = 0 ; i < 5 ; i ++){
//                for(int j = 0 ; j < 5; j++){
//                    System.out.print(graph[i][j] +" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < 5 && x < 5;
    }

    //이름이 이름인 만큼, 7명의 여학생들로 구성되어야 한다.
    //강한 결속력을 위해, 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
    //화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다.
    //그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.
    public static void input(BufferedReader br) throws IOException{
        for(int i = 0 ; i < 5; i++){
            String a = br.readLine();
            for(int j = 0 ; j < 5; j++){
                char ch = a.charAt(j);
                // Y == 0
                if(ch == 'Y'){
                    yeonList.add(new int[]{i,j});
                }else{ // S == 1
                    somList.add(new int[]{i,j});
                }
            }
        }
    }
}
