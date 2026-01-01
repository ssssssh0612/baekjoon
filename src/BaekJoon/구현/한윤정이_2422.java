package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 한윤정이_2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < 200; i++) {
            map.put(i + 1, new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    // i 의 HashSet에 j,k 가 포함하는지 확인
                    if(map.get(i).contains(j) || map.get(i).contains(k)){
                        continue;
                    }
                    if(map.get(j).contains(i) || map.get(j).contains(k)){
                        continue;
                    }
                    if(map.get(k).contains(i) || map.get(k).contains(j)){
                        continue;
                    }
                    count++;
                    // j 의 HashSet에 i,k 가 포함하는지 확인

                    // k 의 HashSet에 i,j 가 포함하는지 확인

                }
            }
        }
        System.out.println(count);
    }
}
