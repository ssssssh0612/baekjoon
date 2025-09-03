package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 안녕_1535 {
    static List<int[]> list = new ArrayList<>();
    static int resultSmile = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            list.add(new int[]{Integer.parseInt(st.nextToken()), 0});
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            list.get(i)[1] = Integer.parseInt(st.nextToken());
        }
        // 0 되면 종료 안되면 그냥 이어가기
        for (int i = 0; i < num; i++) {
            int health = list.get(i)[0];
            int smile = list.get(i)[1];
            dfs(i + 1,100 - health, smile);
        }
        System.out.println(resultSmile);
    }
    //
    public static void dfs(int index, int health, int smile){
        if(index == list.size() || health <= 0){
            if(health <= 0){
                smile = 0;
            }
            resultSmile = Math.max(smile, resultSmile);
            return;
        }
        // 인사하거나
        dfs(index + 1, health - list.get(index)[0], smile + list.get(index)[1]);
        // 그냥 가거나
        dfs(index + 1, health, smile);

    }
}
