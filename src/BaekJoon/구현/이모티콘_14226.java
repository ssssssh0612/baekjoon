package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 이모티콘_14226 {
    static boolean[][] visited = new boolean[2001][2001];
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // visited 관리를 어떻게 할것이냐 ? 현재 화면에 있는 이모티콘 갯수 , 복사한 이모티콘 갯수
        num = Integer.parseInt(br.readLine());
        bfs();
    }
        public static void bfs(){
            //화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            //클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            //화면에 있는 이모티콘 중 하나를 삭제한다.

            Queue<int[]> queue = new LinkedList<>();
            // now0 = 현재 복사한 이모티콘 갯수
            // now1 = 현재 적은 이모티콘 갯수
            queue.add(new int[]{0,1,0});
            visited[0][1] = true;
            while(!queue.isEmpty()){
                int[] now = queue.poll();
                int addNumber = now[0] + now[1];
                if(now[1] == num){
                    System.out.println(now[2]);
                    return;
                }

                // 복사 진행하기 만약 방문하지 않았다면
                if(!visited[now[1]][now[1]]){
                    queue.add(new int[]{now[1], now[1], now[2] + 1});
                    visited[now[1]][now[1]] = true;
                }
                // 붙여넣기 진행하기
                if(addNumber <= 2000 && !visited[now[0]][addNumber]){
                    queue.add(new int[]{now[0], addNumber, now[2] + 1});
                    visited[now[0]][addNumber] = true;
                }
                // 숫자 하나 빼기
                if(now[1] - 1 >= 0 && !visited[now[0]][now[1] - 1]){
                    queue.add(new int[]{now[0], now[1] - 1, now[2] + 1});
                    visited[now[0]][now[1] - 1] = true;
                }
            }
        }
}
