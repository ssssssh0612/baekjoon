package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별_찍기_10 {
    static StringBuilder sb = new StringBuilder();
    static char[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        graph = new char[number][number];
        partition(number, 0, 0, 1);
        result();
        System.out.println(sb);
    }
    public static void result(){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }
    }
    public static void partition(int size, int y, int x, int number){
        if(size == 1){
            if(number == 0){
                // 빈칸
                graph[y][x] = ' ';
            }else{
                // 별
                graph[y][x] = '*';
            }
            return;
        }
        int newSize = size / 3 ;
        if(number == 0){
            // 0으로 받은애는 다 0으로 채워
            partition(newSize, y, x, 0);
            partition(newSize, y, x + newSize, 0);
            partition(newSize, y, x + newSize * 2, 0);
            partition(newSize, y + newSize, x,0);
            partition(newSize, y + newSize, x + newSize, 0);
            partition(newSize, y + newSize, x + newSize * 2, 0);
            partition(newSize, y + newSize * 2, x, 0);
            partition(newSize, y + newSize * 2, x + newSize, 0);
            partition(newSize, y + newSize * 2, x + newSize * 2, 0);
        }else{
            partition(newSize, y, x, 1);
            partition(newSize, y, x + newSize, 1);
            partition(newSize, y, x + newSize * 2, 1);
            partition(newSize, y + newSize, x,1);
            partition(newSize, y + newSize, x + newSize, 0);
            partition(newSize, y + newSize, x + newSize * 2, 1);
            partition(newSize, y + newSize * 2, x, 1);
            partition(newSize, y + newSize * 2, x + newSize, 1);
            partition(newSize, y + newSize * 2, x + newSize * 2, 1);
        }
    }
}
