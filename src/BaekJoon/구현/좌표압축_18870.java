package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 좌표압축_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] resultArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            resultArr[i] = arr[i];
        }
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(arr[i])){
                map.put(arr[i], index);
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(resultArr[i])).append(" ");
        }
        System.out.println(sb);
    }
}
