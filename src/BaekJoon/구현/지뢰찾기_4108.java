package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지뢰찾기_4108 {
    static int[] dx = {0,0,-1,1,-1,1,1,-1};
    static int[] dy = {-1,1,0,0,-1,1,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while( flag ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int[][] graph = new int[y][x];
            if( y == 0 && x == 0){
                flag = false;
                break;
            }
            for(int i = 0; i < y; i++){
                String str = br.readLine();
                for(int j =0; j< x; j++){
                    if( str.charAt(j) == '.'){
                        graph[i][j] = 0;
                    }else{
                        graph[i][j] = -1;
                    }
                }
            }
            for(int i = 0; i < y; i++){
                for(int j =0; j< x; j++){
                    if(graph[i][j] == -1){
                        for(int k =0; k< 8; k++){
                            int nowY = i + dy[k];
                            int nowX = j + dx[k];
                            if( checking(nowY,nowX,graph) && graph[nowY][nowX] >= 0 ){
                                graph[nowY][nowX]++;
                            }
                        }
                    }
                }
            }
            for(int i= 0; i < y; i++){
                for(int j=0; j < x; j++){
                    if( graph[i][j] >= 0){
                        System.out.print(graph[i][j]);
                    }else {
                        System.out.print("*");
                    }
                }
                System.out.println();
            }
        }
    }
    public static boolean checking(int y , int x , int[][] graph){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
