package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 주사위_윷놀이_2_17825 {
    static class Horse{
        int y;
        int x;
        boolean finished;
        public Horse(int y, int x){
            this.y = y;
            this.x = x;
            finished = false;
        }
    }
    static boolean[] visited = new boolean[33];
    static int nextNum;
    static int[] order = new int[10];
    static int[] arr = new int[10];
    static int count = Integer.MIN_VALUE;
    static int[] board = new int[33];
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 10; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < 33; i++){
            graph.add(new ArrayList<>());
        }
        board = new int[]{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,13,16,19,25,30,35,22,24,28,27,26,0};
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(4);
        graph.get(4).add(5);
        graph.get(5).add(6);
        graph.get(5).add(21);
        graph.get(21).add(22);
        graph.get(22).add(23);
        graph.get(23).add(24);
        graph.get(24).add(25);
        graph.get(25).add(26);
        graph.get(26).add(20);
        graph.get(6).add(7);
        graph.get(7).add(8);
        graph.get(8).add(9);
        graph.get(9).add(10);
        graph.get(10).add(11);
        graph.get(10).add(27);
        graph.get(27).add(28);
        graph.get(28).add(24);
        graph.get(11).add(12);
        graph.get(12).add(13);
        graph.get(13).add(14);
        graph.get(14).add(15);
        graph.get(15).add(16);
        graph.get(15).add(29);
        graph.get(29).add(30);
        graph.get(30).add(31);
        graph.get(31).add(24);
        graph.get(16).add(17);
        graph.get(17).add(18);
        graph.get(18).add(19);
        graph.get(19).add(20);
        graph.get(20).add(32);
        graph.get(32).add(32);

        backTracking(0);
        System.out.println(count);
    }
    public static void backTracking(int depth){
        if(depth == 10){
            // 말을 움직이게함
            int compare = 0;
            int[] horseList = new int[4];
            for(int i = 0 ; i < 10 ; i++){
                int nextStep = arr[i];
                // 움직일 말 갖고오기
                int horse = horseList[order[i]];
                nextNum = horse;
                if(horse == 32){
                    break;
                }
                if(horse == 5){
                    horse = 21;
                    nextStep--;
                }else if(horse == 10){
                    horse = 27;
                    nextStep--;
                }else if(horse == 15){
                    horse = 29;
                    nextStep--;
                }

                // 이 숫자 방문했어 ?
                dfs(0, nextStep, horse);

                if(nextNum == 32){
                    visited[horse] = false;
                    horseList[order[i]] = 32;
                    continue;
                }

                if(!visited[nextNum]){
                    horseList[order[i]] = nextNum;
                    visited[horse] = false;
                    visited[nextNum] = true;
                    compare += board[nextNum];
                }else{
                    break;
                }
            }

            count = Math.max(compare, count);
            return;
        }
        for(int i = 0 ; i < 4; i++){
            order[depth] = i;
            backTracking(depth + 1);
        }
    }
    public static void dfs(int depth, int number, int startNum){
        if(depth == number){
            nextNum = startNum;
            return;
        }
        dfs(depth + 1, number, graph.get(startNum).get(0));
    }
}
