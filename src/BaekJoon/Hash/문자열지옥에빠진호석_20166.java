package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문자열지옥에빠진호석_20166 {
    static char[][] graph ;
    //(y-1,x-1) (y-1,x) (y-1,x+1)
    //(y,x-1)  (y,x) (y, x+1)
    //(y+1,x-1) (y+1,x) (y+1,x+1)
    static int[] dy = {-1,-1,-1,0,1,1,1,0};
    static int[] dx = {-1,0,1,1,1,0,-1,-1};
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        graph = new char[y][x];
        for(int i = 0 ; i < y ; i ++){
            String str= br.readLine();
            for(int j = 0 ; j < x; j ++){
                graph[i][j] = str.charAt(j);
            }
        }

        makeWord();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < count; i++){
            String str = br.readLine();
            if(map.get(str) != null){
                sb.append(map.get(str)).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void makeWord(){
        for(int i = 1; i <= 5; i ++){
            for(int j = 0 ; j < graph.length; j++){
                for(int k = 0 ; k < graph[0].length; k++){
                    dfs(j,k,1,i,graph[j][k]+"");
                }
            }
        }
    }
    public static void dfs(int y, int x, int depth, int length, String str){
        if(depth == length){
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        for(int i = 0 ; i < 8; i++){
            int nextY = (y + dy[i]);
            int nextX = (x + dx[i]);
            int[] pos = convert(nextY, nextX);
            dfs(pos[0], pos[1], depth+1, length, str+graph[pos[0]][pos[1]]);
        }
    }

    public static int[] convert(int y, int x){
        int[] pos = new int[2];
        if( y == graph.length ){
            pos[0] = 0;
        }else if( y < 0){
            pos[0] = graph.length - 1;
        }else{
            pos[0] = y;
        }

        if( x == graph[0].length){
            pos[1] = 0;
        }else if( x < 0){
            pos[1] = graph[0].length - 1;
        }else{
            pos[1] = x;
        }

        return pos;
    }
}
