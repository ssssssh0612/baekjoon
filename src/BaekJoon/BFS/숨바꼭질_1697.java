package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질_1697 {
    // A -> B 16953과 굉장히 유사한문제
    // 사실 거의 같다고 볼 수 있음
    // x+1 x-1 2x 경우의 수
    // 반례가 ㅈㄴ많은 ㅈ같은문제
    static int start;
    static int end;
    static int[] distance = new int[1000001];
    static boolean[] visited = new boolean[1000001];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        end = sc.nextInt();
        distance[start] = 0;
        bfs(start);
        if(start > end){
            System.out.println(start - end);
        } else if ( start < end ){
        System.out.println(distance[end]);
        } else {
            System.out.println(0);
        }
    }

    public static void bfs(int start) {
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == end) {
                break;
            }
            for (int i = 0; i < 3; i++) {
                if (i == 2 && numberX(now) > 0  && numberX(now) <= 100000 && visited[numberX(now)] == false ) {
                    visited[numberX(now)] = true;
                    distance[numberX(now)] = distance[now] + 1;
                    queue.add(numberX(now));
                } else if (i == 1 && numberP(now) > 0 && numberP(now) <= 100000 && visited[numberP(now)] == false) {
                    visited[numberP(now)] = true;
                    distance[numberP(now)] = distance[now] + 1;
                    queue.add(numberP(now));
                } else if (i == 0 && numberM(now) > 0 && numberM(now) <= 100000 && visited[numberM(now)] == false) {
                    visited[numberM(now)] = true;
                    distance[numberM(now)] = distance[now] + 1;
                    queue.add(numberM(now));
                }
            }
        }
    }

    public static int numberM(int number) {
        return number - 1;
    }

    public static int numberP(int number) {
        return number + 1;
    }

    public static int numberX(int number) {
        return 2 * number;
    }
}
