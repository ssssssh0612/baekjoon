package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 유성_10703 {
    static int[] dy = {1};
    static int[] dx = {0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] graph = new int[y][x];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                if(str.charAt(j) == 'X'){
                    graph[i][j] = 1;
                    list.add(new int[]{i,j});
                }else if(str.charAt(j) == '#'){
                    graph[i][j] = 2;
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            int[] pos = list.get(i);
            int moveY = pos[0] + dy[0];
            int moveX = pos[1] + dx[0];
            if(graph[moveY][moveX] == 1){
                continue;
            }
            if(graph[moveY][moveX] == 2){
                result = 0;
                break;
            }

            int count = 1;
            while(true){
                count++;
                moveY = moveY + dy[0];
                moveX = moveX + dx[0];
                if(graph[moveY][moveX] == 2){
                    result = Math.min(result, count - 1);
                    break;
                }
            }
        }
        // result 횟수만큼 모두 이동시키기
        List<int[]> newPos = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] pos = list.get(i);
            graph[pos[0]][pos[1]] = 0;
            int newY = pos[0] + result * dy[0];
            int newX = pos[1] + result * dx[0];
            newPos.add(new int[]{newY, newX});
        }
        
        for (int i = 0; i < newPos.size(); i++) {
            int[] pos = newPos.get(i);
            graph[pos[0]][pos[1]] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(graph[i][j] == 0){
                    sb.append(".");
                }else if(graph[i][j] == 1){
                    sb.append("X");
                }else{
                    sb.append("#");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

}
