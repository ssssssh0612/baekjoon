package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 스타트링크_5014 {
    public static void main(String[] args) {
        // F 층으로 이루어진 사무실
        // 스타트링크가 잇는 위치 G
        // 강호 위치 S
        // U 버튼은 +
        // D 버튼은 -
        // F, S, G, U, D
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int [] operator = new int[1000000+1];
        int maxStair = sc.nextInt();
        int nowStair = sc.nextInt();
        int resultStair = sc.nextInt();
        int upStair = sc.nextInt();
        int downStair = sc.nextInt();
        boolean[] visited = new boolean[1000000+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{nowStair,operator[nowStair]});

        visited[nowStair] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == resultStair) {
                System.out.println(operator[resultStair]);
                break;
            }
            for (int i = 0; i < 2; i++) {
                if(i==0){ // 더하기
                    if(  now[0] + upStair > 0 && now[0] + upStair < 1000001  && !visited[now[0] + upStair] ){
                        visited[now[0] + upStair] = true;
                        queue.add(new int[]{now[0] + upStair, operator[now[0] + upStair] = now[1]+1});
                    }
                }else{
                    if( now[0] - downStair > 0 && now[0] - downStair < 1000001 && !visited[now[0] - downStair] ){
                        visited[now[0] - downStair] = true;
                        queue.add(new int[]{now[0] - downStair, operator[now[0] - downStair] = now[1]+1});
                    }
                }
            }
        }
        if(!visited[resultStair]) {
            System.out.println("use the stairs");
        }
    }
}
