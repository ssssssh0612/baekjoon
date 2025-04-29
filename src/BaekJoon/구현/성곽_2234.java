package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 성곽_2234 {
    static class Node{
        // 서 북 동 남 순서
        boolean[] isWall;
        public Node(boolean[] isWall){
            this.isWall = isWall;
        }
    }
    static boolean[][] visited;
    static int[][] numberGraph;
    static Node[][] graph;
    // 서 북 동 남
    static int[] dy = {0,-1,0,1};
    static int[] dx = {-1,0,1,0};
    static int result1 = 0;
    static int result2 = 0;
    static int result3 = 0;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        visited = new boolean[y][x];
        graph = new Node[y][x];
        numberGraph = new int[y][x];

        // 받아오는 숫자를 2진수로 변환해서 표현하기

        for(int i = 0 ; i < y ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < x; j++){
                int num = Integer.parseInt(st.nextToken());
                String str = convert(num);
                boolean[] isWall = new boolean[4];
                for(int k = 0 ; k < 4; k++){
                    if(str.charAt(k) == '0'){
                        isWall[k] = false;
                    }else{
                        isWall[k] = true;
                    }
                }
                graph[i][j] = new Node(isWall);
            }
        }

        for(int i = 0 ; i < y ; i++){
            for(int j = 0 ; j < x; j++){
                if(!visited[i][j]){
                    bfs(i,j);
                    result1++;
                }
            }
        }

        Set<String> set = new HashSet<>();

        // 서로 붙는 경우
        for(int i = 0 ; i < y ; i++){
            for(int j = 0 ; j < x; j++){
                // 현재 위치와 다음 위치가 다른경우
                int nowNum = numberGraph[i][j];
                for(int k = 0; k < 4; k++){
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    if (checking(nextY, nextX) && numberGraph[nextY][nextX] != nowNum) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(nowNum).append(" ").append(numberGraph[nextY][nextX]);
                        set.add(sb.toString());
                    }
                }
            }
        }

        for(String str : set){
            st = new StringTokenizer(str," ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int result = list.get(num1) + list.get(num2);
            result3 = Math.max(result3, result);
        }


        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }

    public static void visitedFalse(){
        for(int i = 0 ; i < graph.length ; i++){
            for(int j = 0 ; j < graph[0].length; j++){
                visited[i][j] = false;
            }
        }
    }

    public static void bfs(int y , int x){
        int count = 1;
        visited[y][x] = true;
        numberGraph[y][x] = result1;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{y,x});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            boolean[] isWall = graph[now[0]][now[1]].isWall;
            for(int i = 0 ; i < 4; i++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && !isWall[i]
                        && !visited[nextY][nextX]){
                    queue.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                    numberGraph[nextY][nextX] = result1;
                    count++;
                }
            }
        }
        list.add(count);
        result2 = Math.max(result2, count);
    }

    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }

    public static String convert(int num){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 4; i++){
            int addNum = num % 2;
            sb.append(addNum);
            num = num/2;
        }
        return sb.toString();
    }
}
