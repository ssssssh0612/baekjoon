package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 전쟁_땅따먹기_1270 {
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            Map<Long, Integer> map = new HashMap<>();
            boolean flag = true;
            for (int j = 0; j < count; j++) {
                long number = Long.parseLong(st.nextToken());
                map.put(number, map.getOrDefault(number, 0) + 1);
                if(map.get(number) > (count / 2)){
                    result.append(number).append("\n");
                    flag = false;
                    break;
                }
            }
            if(flag){
                result.append("SYJKGW").append("\n");
            }
        }
        System.out.println(result);
    }
}
