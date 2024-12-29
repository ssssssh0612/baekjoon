package BaekJoon.DataStructure.SetMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 비밀번호찾기_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int find = Integer.parseInt(st.nextToken());

        HashMap<String, String> hashMap = new HashMap<>();

        for(int i = 0; i < number; i++){
            st = new StringTokenizer(br.readLine());
            hashMap.put(st.nextToken(), st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < find; i++){
            String str = br.readLine();
            sb.append(hashMap.get(str)).append("\n");
        }
        System.out.println(sb);
    }
}
