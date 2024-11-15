package BaekJoon.BFS;

// 11시 04분 시작

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A_B_16953 {
    //2를 곱한다.
    //1을 수의 가장 오른쪽에 추가한다.
    static boolean[] visited;
    static boolean flag = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }
    public static void input(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNum = Integer.parseInt(st.nextToken());
        int endNum = Integer.parseInt(st.nextToken());
        visited = new boolean[endNum + 1];
        bfs(startNum,endNum);
        if(!flag){
            System.out.println(-1);
        }
    }
    public static void bfs(int startNum, int endNum){
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{startNum, 0});
        while(!queue.isEmpty()){
            long[] now = queue.poll();
            long number = now[0];
            long count = now[1];
            if(number == endNum){
                flag = true;
                System.out.println(count+1);
                return;
            }
            for(int i = 0; i < 2 ; i++){
                if(i == 0 && (changeNumberX(number) <= endNum) && !visited[(int) changeNumberX(number)]){
                    // 2를 곱한값
                    queue.add(new long[]{changeNumberX(number) , count + 1});
                    visited[(int) changeNumberX(number)] = true;
                }else if( i == 1 && (changeNumberOne(number) <= endNum) && !visited[(int) changeNumberOne(number)]){
                    // 1을 수의 가장 오른쪽에 추가
                    queue.add(new long[]{changeNumberOne(number) , count + 1});
                    visited[(int) changeNumberOne(number)] = true;
                }
            }
        }
    }

    public static long changeNumberX(long number){
        return number * 2;
    }
    public static long changeNumberOne(long number){
        return (number * 10) + 1;
    }
}
