package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 메이즈러너_codeTree {
    static class Node{
        int wall;
        List<Integer> personList;
        boolean exit;
        public Node(){
            this.wall = 0;
            this.personList = new ArrayList<>();
            exit = false;
        }

        public boolean isPerson(){
            return !personList.isEmpty();
        }

        public boolean isWall(){
            return wall > 0;
        }
    }
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};

    static int [] rotateDY = {-1,-1,1,1};
    static int [] rotateDX = {-1,1,-1,1};

    static int [] exit = new int[2];
    static int M;
    static int resultCount = 0 ;
    static Node[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        graph = new Node[N][N];

        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < N ; j ++){
                graph[i][j] = new Node();
            }
        }

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j ++){
                graph[i][j].wall = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < M ; i ++ ){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            graph[y][x].personList.add(i + 1);
        }

        st = new StringTokenizer(br.readLine());

        exit[0] = Integer.parseInt(st.nextToken()) - 1;
        exit[1] = Integer.parseInt(st.nextToken()) - 1;

        graph[exit[0]][exit[1]].exit = true;

        for(int i = 0 ; i < K ; i ++){
            moving();
            rotate();
        }
        System.out.println(resultCount);
        System.out.println(exit[0] + " " + exit[1]);
    }
    public static void moving(){
        for(int i = 0 ; i < M ; i ++){
            movingHuman(i + 1);
        }
    }

    public static void movingHuman(int number){
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph.length; j++){
                Node node = graph[i][j];
                if(node.isPerson() && node.personList.contains(number)){
                    // 현재 위치에 존재하는 사람 주변에 벽이 있는지 확인
                    List<int[]> noWallList = noWallList(i, j);
                    // 벽이 없는곳이 없으므로 끝내기
                    if(noWallList.isEmpty()){
                        return;
                    }
                    int[] nextPos = noWallList.get(0);

                    // 현재 위치에서 다음 위치로 옮기기
                    graph[nextPos[0]][nextPos[1]].personList.add(number);

                    node.personList.remove((Integer)number);
                    resultCount++;
                    return;
                }
            }
        }
    }
    public static List<int[]> noWallList(int y, int x){
        List<int[]> list = new ArrayList<>();
        // 현재 받은 y,x 위치에서 exit까지의 최단거리
        int distance = exitBFS(y, x);

        for(int i = 0 ; i < 4; i ++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(checking(nextY, nextX) && graph[nextY][nextX].wall == 0){
                // 여기서 최단거리까지 구하자
                int newDistance = exitBFS(nextY, nextX);
                if(newDistance < distance){
                    list.add(new int[]{nextY, nextX, i});
                }
            }
        }

        Comparator<int[]> comparator = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        };
        if(!list.isEmpty()){
            Collections.sort(list, comparator);
        }

        return list;
    }

    public static void rotate(){
        // 현재 exit 를 기준으로 2, 3, 4, 5, 6 ... 크기의 정사각형을 찾아야함
        int index = 1;
        int y = exit[0];
        int x = exit[1];
        while(true){
            for(int i = 0 ; i < 4; i++){
                if( i == 0 ){
                    int startY = y + (rotateDY[i] * index);
                    int startX = x + (rotateDX[i] * index);
                    int endY = y;
                    int endX = x;
                    System.out.println(startY + " " + startX);
                    System.out.println(endY + " " + endX);
                    if(checking(endY, endX) && checking(startY, startX) && checkPerson(startY,startX,endY,endX)){
                        // 돌리고 종료
                        down(startY,startX,endY,endX);
                        rotatePartition(startY,startX,endY,endX);
                        findExit();
                        break;
                    }
                    index++;
                }else if( i == 1){
                    int startY = y + (rotateDY[i] * index);
                    int startX = x;
                    int endY = y;
                    int endX = x + (rotateDX[i] * index);;
                    System.out.println(startY + " " + startX);
                    System.out.println(endY + " " + endX);
                    if(checking(endY, endX) && checking(startY, startX) && checkPerson(startY,startX,endY,endX)){
                        // 돌리고 종료
                        down(startY,startX,endY,endX);
                        rotatePartition(startY,startX,endY,endX);
                        findExit();
                        break;
                    }
                    index++;
                }else if( i == 2){
                    int startY = y;
                    int startX = x + (rotateDX[i] * index);
                    int endY = y + (rotateDY[i] * index);
                    int endX = x;
                    System.out.println(startY + " " + startX);
                    System.out.println(endY + " " + endX);
                    if(checking(endY, endX) && checking(startY, startX) && checkPerson(startY,startX,endY,endX)){
                        // 돌리고 종료
                        down(startY,startX,endY,endX);
                        rotatePartition(startY,startX,endY,endX);
                        findExit();
                        break;
                    }
                    index++;
                }else {
                    int startY = y;
                    int startX = x;
                    int endY = y + (rotateDY[i] * index);
                    int endX = x + (rotateDX[i] * index);
                    System.out.println(startY + " " + startX);
                    System.out.println(endY + " " + endX);
                    if(checking(endY, endX) && checking(startY, startX) && checkPerson(startY,startX,endY,endX)){
                        // 돌리고 종료
                        down(startY,startX,endY,endX);
                        rotatePartition(startY,startX,endY,endX);
                        findExit();
                        break;
                    }
                    index++;
                }
            }
        }


    }
    public static void findExit(){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0 ; j < graph.length; j++){
                if(graph[i][j].exit){
                    exit[0] = i;
                    exit[1] = j;
                    return;
                }
            }
        }
    }
    public static void rotatePartition(int startY , int startX, int endY , int endX){
        int index2 = endX;
        Node[][] copyGraph = new Node[graph.length][graph.length];
        for(int i = 0 ; i < graph.length ; i ++ ){
            for(int j = 0 ; j < graph.length ; j ++){
                copyGraph[i][j] = new Node();
            }
        }


        for(int i = startY ; i <= endY ; i++){
            int index1 = startY;
            for(int j = startX ; j <= endX ; j++){
                Node node = graph[i][j];
                copyGraph[index1][index2] = node;

            }
            index2--;
        }

        for(int i = startY ; i <= endY ; i++){
            for(int j = startX ; j <= endX ; j++){
                graph[i][j] = copyGraph[i][j];
            }
        }
    }

    public static void copyGraph(){
        for(int i = 0 ; i < graph.length; i++){

        }
    }

    public static void down(int startY , int startX, int endY , int endX){
        for(int i = startY ; i <= endY ; i++){
            for(int j = startX ; j <= endX ; j++){
                Node node = graph[i][j];
                if(node.isWall()){
                    node.wall--;
                }
            }
        }
    }

    public static boolean checkPerson(int startY , int startX, int endY , int endX){
        for(int i = startY ; i <= endY ; i++){
            for(int j = startX ; j <= endX ; j++){
                Node node = graph[i][j];
                if(node.isPerson()){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checking(int y , int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length ;
    }

    public static int exitBFS(int y, int x){
        boolean[][] visited = new boolean[graph.length][graph.length];
        visited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x,0});
        int count = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(now[0] == exit[0] && now[1] == exit[1]){
                count = now[2];
                break;
            }
            for(int i = 0 ; i < 4; i++ ){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && graph[nextY][nextX].wall == 0){
                    queue.add(new int[]{nextY, nextX, now[2] + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }
        return count;
    }
}
