package BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 숫자고르기_2668 {
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < length + 1; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 1; i <= length; i++){
            list.get(i).add(Integer.parseInt(br.readLine()));
        }

        for(int i = 1; i <= length; i++){
            boolean[] visited = new boolean[length + 1];
            dfs(visited, i, i - 1, i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for(Integer number : result){
            sb.append(number).append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(boolean[] visited, int startNum, int nextNum, int nowNum){
        if(startNum == nextNum){
            result.add(startNum);
            return;
        }

        for(int i = 0; i < list.get(nowNum).size(); i++){
            if(!visited[list.get(nowNum).get(i)]){
                visited[list.get(nowNum).get(i)] = true;
                dfs(visited, startNum, list.get(nowNum).get(i), list.get(nowNum).get(i));
            }
        }

    }
}
