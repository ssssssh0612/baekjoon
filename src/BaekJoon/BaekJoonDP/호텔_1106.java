package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 호텔_1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cost = Integer.parseInt(st.nextToken());
        int cityCount = Integer.parseInt(st.nextToken());

        List<int[]> cities = new ArrayList<>();

        for (int i = 0; i < cityCount; i++) {
            st = new StringTokenizer(br.readLine());
            cities.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            // 비용, 얻는 고객
        }

        int[] arr = new int[1101];
        Arrays.fill(arr, 100_000_000);
        arr[0] = 0;
        // 비용중 가장 최소값 찾기
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < cities.size(); j++) {
                int[] city = cities.get(j);
                int next = i + city[1];
                // 다음보다 크지 않으면
                if(next > 1100) continue;
                arr[next] = Math.min(arr[next], arr[i] + city[0]);
            }
            // 여기서 arr 이 모두 최신화 되어야 하는데
        }

        int min = Integer.MAX_VALUE;
        for (int i = cost; i < arr.length; i++) {
            min = Math.min(arr[i], min);
        }

        System.out.println(min);
    }
}
