package BaekJoon.Inflearn.classArray;

import java.io.*;
import java.util.*;
public class Main01 {
    static int count = 0;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n, m, ans = 0; //ans : 최종 점수
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Node> queue = new LinkedList<>(); //bfs
    static Queue<Node> queue2 = new LinkedList<>(); //무지개 블록 초기화 큐
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Node standard; //기준 블록 노드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n][n]; visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //반복
        while(true) {
            check();
            score();
            System.out.println("삭제");
            graph();
            gravity();
            System.out.println("중력");
            graph();
            rotate();
            System.out.println("회전");
            graph();
            gravity();
            System.out.println("중력");
            graph();
        }
    }
    //반시계방향 배열 회전
    static void rotate(){
        int[][] arr2 = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr2[n-1-j][i] = arr[i][j];
        for(int i = 0; i < n; i++)
            System.arraycopy(arr2[i], 0, arr[i], 0, arr2[i].length);
    }
    static void graph(){
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" "+arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //중력
    static void gravity(){
        for(int i = n-2; 0 <= i; i--){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == -2 || arr[i][j] == -1) continue;
                int tmp = arr[i][j], ni = i;
                while(ni+1 < n && arr[ni+1][j] == -2)
                    ni++;
                if(arr[ni][j] == -2) {
                    arr[ni][j] = tmp;
                    arr[i][j] = -2;
                }
            }
        }
    }
    //점수 계산
    static void score(){
        int score = 0, color = arr[standard.x][standard.y];
        visited = new boolean[n][n];
        queue.add(standard); visited[standard.x][standard.y] = true;
        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            arr[tmp.x][tmp.y] = -2; //빈공간 : -2
            score++;
            for(int i = 0; i < 4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < n){
                    if(!visited[nx][ny] && arr[nx][ny] != -1 && arr[nx][ny] != -2){
                        if(color == 0 && arr[nx][ny] != 0)
                            color = arr[nx][ny];
                        if(color == arr[nx][ny] || arr[nx][ny] == 0) {
                            queue.add(new Node(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
//        System.out.println("score = "+score);
        System.out.println(++count);
        ans += Math.pow(score, 2);
    }

    //기준 블럭 찾기
    static void check(){
        int max = 0, rainMax = 0; //최대 그룹 크기, 무지개 블럭 개수
        visited = new boolean[n][n];
        standard = new Node(-1, -1);
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int size = 0, rain = 0, color = 0; Node tmpStd; //빈 공간 : -2
                if(!visited[i][j] && arr[i][j] != -1 && arr[i][j] != -2 && arr[i][j] != 0) {
                    queue.add(tmpStd = new Node(i, j)); // 빈 공간, 무지개, 검은색 블럭은 기준 블럭x
                    visited[i][j] = true;
                    color = arr[i][j]; size++;
                }
                while (!queue.isEmpty()) {
                    Node tmp = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = tmp.x + dx[k];
                        int ny = tmp.y + dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                            if (!visited[nx][ny] && arr[nx][ny] != -1 && arr[nx][ny] != -2) {
                                if(color == arr[nx][ny] || arr[nx][ny] == 0) {
                                    if(arr[nx][ny] == 0) //무지개 노드 위치 저장
                                        queue2.add(new Node(nx, ny));
                                    visited[nx][ny] = true;
                                    queue.add(new Node(nx, ny));
                                    size++;
                                    if(arr[nx][ny] == 0) //무지개 노드 수
                                        rain++;
                                }
                            }
                        }
                    }
                }
                if(max < size){
                    max = size; rainMax = rain; standard = new Node(i, j);
                }
                else if(max == size){
                    if(rainMax < rain){
                        rainMax = rain; standard = new Node(i, j);
                    }
                    else if(rainMax == rain){
                        if(standard.x < i)
                            standard = new Node(i, j);
                        else if(standard.x == i)
                            if(standard.y < j)
                                standard = new Node(i, j);
                    }
                }
                //무지개 노드 방문 복구
                while(!queue2.isEmpty()){
                    Node tmp = queue2.poll();
                    visited[tmp.x][tmp.y] = false;
                }
            }
        }
        //그룹이 없으면 합 출력 후 프로그램 종료
        if(max < 2) {
            System.out.println(ans);
            System.exit(0);
        }
    }
}
