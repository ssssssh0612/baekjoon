package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트리스_3019 {
    static int[][] graph;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int blockNumber = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]){
                max = arr[i];
            }
        }
        graph = new int[max+4][length];
        for( int i = 0 ; i < length; i++){
            int number = arr[i];
            if( number > 0){
                for (int j = max + 3; j > (max + 3) - number ; j--) {
                    graph[j][i] = 1;
                }
            }
        }
//        checkingGraph();
//        System.out.println(checking());
    }
    public static void block1(){
        for(int i = 0 ; i < graph.length; i ++){
            for(int j = 0 ; j < graph.length; j ++){
            }
        }
    }
    public static boolean block1Checking1(int y , int x){
        if(checkingRange(y,x) && checkingRange(y + 1,x) && checkingRange(y + 2, x) && checkingRange( y +3 , x)){
            graph[y][x] = 1;
            graph[y+1][x] = 1;
            graph[y+2][x] = 1;
            graph[y+3][x] = 1;
            return true;
        }else{
            return false;
        }
    }
    public static boolean block1Checking2(int y , int x){
        if(checkingRange(y,x) && checkingRange(y,x + 1) && checkingRange(y, x + 2) && checkingRange( y , x+3)){
            graph[y][x] = 1;
            graph[y][x+1] = 1;
            graph[y][x+2] = 1;
            graph[y][x+3] = 1;
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkingRange(int y, int x){
        return y >= 0 && y < graph.length && x >= 0 && x < graph[0].length;
    }

    public static void block2(){

    }
    public static void block3(){

    }
    public static void block4(){

    }
    public static void block5(){

    }
    public static void block6(){

    }
    public static void block7(){

    }

    public static void checkingGraph(){
        for(int i = 0 ; i < graph.length; i ++){
            for (int j = 0 ; j < graph[0].length ; j ++){
                System.out.print(graph[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static boolean checking(){
        for(int i = 0 ; i < graph[0].length; i++ ){
            int number = graph[graph.length - 1][i];
            int count = 0;
            for(int j = graph.length - 1;  j >= 0 ; j-- ){
                if( number == 0){
                    // 쭉 0이어야 함
                    if(graph[j][i] != 0){
                        return false;
                    }
                }else{
                    // count 를 체크해서 0이라면 계속 1이 나와야 함
                    if(count == 0 && graph[j][i] != 1){
                        count++;
                    }else if( count == 1 && graph[j][i] != 0 ){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
