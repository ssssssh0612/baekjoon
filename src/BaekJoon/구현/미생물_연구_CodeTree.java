package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 미생물_연구_CodeTree {
    static class Node{
        List<int[]> list;
        int number;
        Node(List<int[]> list, int number){
            this.list = list;
            this.number = number;
        }
    }
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] graph;
    static int n;
    public static void main(String[] args) throws IOException {
        // 미생물 투입
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for(int i = 0 ; i < count; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            spray(convert(x1,y1,x2,y2), i + 1);
            // dfs돌면서 숫자 체킹
            step1();
            step2();
        }
    }
    public static void step3(){
        int result = 0;
        boolean[][] checking = new boolean[51][51];
        boolean[][] visited = new boolean[n][n];
        // 현재 그래프 돌면서 0보다 크면 if문안에 들어가기
        for(int i = 0 ; i < n; i ++){
            for(int j = 0 ; j < n ; j++){
                int num = graph[i][j];
                if(num > 0){
                    // 현재 색이 있는애고
                    for(int k = 0 ; k < 4; k ++){
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        // 범위안에 들어가는데, 만약 나와 색이 다르면(0보다 커야함)
                        if(checking(nextY, nextX) && graph[nextY][nextX] > 0
                                && graph[nextY][nextX] != num && !checking[num][graph[nextY][nextX]]
                                && !checking[graph[nextY][nextX]][num]){


                        }
                    }
                }
            }
        }
    }
    public static void step2(){
        // for문을 한번 돌면서 어떤 애들을 넣어야할지 결정하기
        boolean[][] visited = new boolean[n][n];
        List<Node> nodeList = new ArrayList<>();
        for(int i = 0 ; i < n; i ++){
            for(int j = 0 ; j < n; j++){
                int num = graph[i][j];
                if(num > 0 && !visited[i][j]){
                    List<int[]> list = bfs(i, j, visited);
                    nodeList.add(new Node(list, num));
                }
            }
        }

        Comparator<Node> comparator = new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                // size가 더 큰놈
                int result = n2.list.size() - n1.list.size();
                if(result != 0){
                    return result;
                }
                return n1.number - n2.number;
            }
        };

        nodeList.sort(comparator);
        // 하나씩 골라서 넣기 만약에 넣지 못하는거라면 넘기기
        int[][] newGraph = new int[n][n];
        for(int i = 0 ; i < nodeList.size(); i ++){
            Node node = nodeList.get(i);
            insert(node, newGraph);
        }
        graph = newGraph;


        int result = 0;
        boolean[][] checking = new boolean[51][51];

        for(int i = 0 ; i < n; i ++){
            for(int j = 0 ; j < n ; j++){
                int num = graph[i][j];
                if(num > 0){
                    // 현재 색이 있는애고
                    for(int k = 0 ; k < 4; k ++){
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        // 범위안에 들어가는데, 만약 나와 색이 다르면(0보다 커야함)
                        if(checking(nextY, nextX) && graph[nextY][nextX] > 0
                                && graph[nextY][nextX] != num && !checking[num][graph[nextY][nextX]]
                                && !checking[graph[nextY][nextX]][num]){
                            int num2 = graph[nextY][nextX];
                            int num1Size = 0;
                            int num2Size = 0;
                            for(int d = 0 ; d < nodeList.size(); d ++){
                                Node node = nodeList.get(d);
                                if(node.number == num){
                                    num1Size = node.list.size();
                                }
                                if(node.number == num2){
                                    num2Size = node.list.size();
                                }
                            }
                            checking[num][num2] = true;
                            checking[num2][num] = true;
                            result += num1Size * num2Size;
                        }
                    }
                }
            }
        }
        System.out.println(result);

    }
    public static void insert(Node node, int[][] newGraph){
        // 넣기 가능하다면 넣고 안되면 return;
        // y는 가장 크고, x는 가장 작고
        List<int[]> list = node.list;
        Comparator<int[]> comparator = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                int result = o2[0] - o1[0];
                if(result != 0){
                    return result;
                }
                return o1[1] - o2[1];
            }
        };
        list.sort(comparator);
        // 기준점
        int[] pos = list.get(0);
        for(int i = 0 ; i < n; i++){
            for(int j = (n - 1); j >= 0; j--){
                // j, i;
                // 시작지점
                // 현재 기준과, 얼마나 벗어나야하는지 알고 나머지 적용시키기
                int y = j - pos[0];
                int x = i - pos[1];
                if(checkingInsert(y, x , list, newGraph)){
                    for(int[] arr : list){
                        newGraph[arr[0] + y][arr[1] + x] = node.number;
                    }
                    return;
                }
            }
        }
    }
    public static boolean checkingInsert(int y, int x, List<int[]> list,int[][] newGraph){
        for(int[] arr : list){
            int nextY = arr[0] + y;
            int nextX = arr[1] + x;
            if(checking(nextY,nextX) && newGraph[nextY][nextX] == 0){

            }else{
                return false;
            }
        }
        return true;
    }

    public static List<int[]> bfs(int y , int x, boolean[][] visited) {
        List<int[]> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int num = graph[y][x];
        queue.add(new int[]{y,x});
        list.add(new int[]{y,x});
        visited[y][x] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0; i < 4; i ++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY,nextX) && graph[nextY][nextX] == num && !visited[nextY][nextX]){
                    queue.add(new int[]{nextY,nextX});
                    list.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }
        return list;
    }

    private static void step1() {
        boolean[][] visited = new boolean[n][n];
        int[] arr = new int[51];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                int num = graph[i][j];
                // 0보다 크고 방문하지 않았다면 bfs
                // 색칠 되어있고, 방문하지 않았다면
                if(num > 0 && !visited[i][j]){
                    bfs(i,j,visited,arr);
                }
            }
        }

        // 두번이상나온애들 삭제하기
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                int num = graph[i][j];
                if(num > 0 && arr[num] > 1){
                    graph[i][j] = 0;
                }
            }
        }
    }
    public static void bfs(int y , int x, boolean[][] visited, int[] arr){
        int num = graph[y][x];
        arr[num]++;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i =0 ; i < 4; i ++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY,nextX) && !visited[nextY][nextX]
                        && graph[nextY][nextX] == num){
                    queue.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    public static int[] convert(int x1, int y1, int x2, int y2){
        y1 = (n - 1) - y1;
        y2 = (n - 1) - y2;
        return new int[]{y2, x1, y1, x2};
    }

    public static void spray(int[] pos, int color){
        for(int i = pos[0]; i <= pos[2]; i++){
            for(int j = pos[1]; j <= pos[3]; j++){
                graph[i][j] = color;
            }
        }
    }

    public static boolean checking(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    public static void checkingGraph(){
        System.out.println("============");
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph.length; j++){
                System.out.print(graph[i][j] +" ");
            }
            System.out.println();
        }
    }
}
