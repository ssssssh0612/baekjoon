package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나무_재테크 {
    public static class Tree{
        int age;
        boolean status;
        public Tree(int age){
            this.age = age;
            status = true;
        }
    }
    public static class Ground{
        List<Tree> list;
        int groundFeed;
        public Ground(){
            this.groundFeed = 5;
            list = new ArrayList<>();
        }
    }
    static int[] dy = {-1,-1,-1,0,0,1,1,1};
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
    static Ground[][] graph;
    static int[][] feed;
    static int n ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new Ground[n][n];
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        feed = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                feed[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                graph[i][j] = new Ground();
            }
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            Ground ground = graph[y][x];
            ground.list.add(new Tree(age));
        }

        for(int i = 0 ; i < k ; i++){
            봄();
            여름();
            가을();
            겨울();
        }
        System.out.println(result());
    }
    // 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
    // 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다.
    // 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
    // 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.

    public static void 봄(){
        for(int i = 0 ; i < n; i ++){
            for(int j = 0 ; j < n; j++){
                Ground ground = graph[i][j];
                if(!ground.list.isEmpty()){
                    Comparator<Tree> comparator = new Comparator<>(){
                        @Override
                        public int compare(Tree tree1, Tree tree2) {
                            return tree1.age - tree2.age;
                        }
                    };
                    Collections.sort(ground.list, comparator);
                    for(int k = 0 ; k < ground.list.size(); k++){
                        Tree tree = ground.list.get(k);
//                        System.out.println(tree.age);
                        if(ground.groundFeed >= tree.age){
                            ground.groundFeed -= tree.age;
                            tree.age++;
                        }else{
                            tree.status = false;
                        }
                    }
                }
            }
        }
    }
    // 여름에는 봄에 죽은 나무가 양분으로 변하게 된다.
    // 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
    public static void 여름(){
        for(int i = 0 ; i < n; i ++){
            for(int j = 0 ; j < n; j++){
                Ground ground = graph[i][j];
                if(!ground.list.isEmpty()) {
                    for(int k = 0 ; k < ground.list.size(); k ++){
                        Tree tree = ground.list.get(k);
                        if(!tree.status){
                            ground.groundFeed += tree.age / 2;
                        }
                    }

                    for(int k = ground.list.size() - 1; k >= 0; k--){
                        Tree tree = ground.list.get(k);
                        if(!tree.status){
                            ground.list.remove(k);
                        }
                    }
                }
            }
        }
    }
    // 가을에는 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며,
    // 인접한 8개의 칸에 나이가 1인 나무가 생긴다. 어떤 칸 (r, c)와
    // 인접한 칸은 (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c-1), (r+1, c), (r+1, c+1) 이다.
    // 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
    public static void 가을(){
        for(int i = 0 ; i < n; i ++){
            for(int j = 0 ; j < n; j++){
                Ground ground = graph[i][j];
                if(!ground.list.isEmpty()) {
                    for(int k = 0 ; k < ground.list.size(); k ++){
                        Tree tree = ground.list.get(k);
                        if(tree.age % 5 == 0){
                            for(int z = 0 ; z < 8; z++){
                                int nextY = i + dy[z];
                                int nextX = j + dx[z];
                                if(checking(nextY, nextX)){
                                    Ground newGround = graph[nextY][nextX];
                                    newGround.list.add(new Tree(1));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public static void 겨울(){
        for(int i = 0 ; i < n; i ++){
            for(int j = 0 ; j < n; j++){
                Ground ground = graph[i][j];
                ground.groundFeed += feed[i][j];
            }
        }
    }
    public static boolean checking(int y , int x){
        return y >= 0 && x >= 0 && y < n && x < n;
    }
    public static int result(){
        int count = 0 ;
        for(int i = 0 ; i < n; i ++){
            for(int j = 0 ; j < n; j++){
                Ground ground = graph[i][j];
                count += ground.list.size();
            }
        }
        return count;
    }
}

