package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 전공책_16508 {
    static String name;
    static Map<String, Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();
    static int maxDepth;
    static boolean[] visited;
    static int[] arr;
    static int result = Integer.MAX_VALUE;
    static int[] check = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        name = br.readLine();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < name.length(); i++) {
            check[name.charAt(i) - 'A']++;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            String bookName = st.nextToken();
            map.put(bookName, price);
            list.add(bookName);
        }

        for (int i = 1; i <= n; i++) {
            maxDepth = i;
            visited = new boolean[n];
            arr = new int[maxDepth];
            backTracking(i, 0,0);
        }

        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }
    public static void backTracking(int maxDepth, int depth, int index){
        if(maxDepth == depth){
            int[] check2 = new int[26];
            for (int i = 0; i < arr.length; i++) {
                String newName = list.get(arr[i]);
                for (int j = 0; j < newName.length(); j++) {
                    check2[newName.charAt(j) - 'A']++;
                }
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if(check2[i] < check[i]){
                    flag = false;
                    break;
                }
            }

            if(flag){
                int sum = 0;
                for (int i = 0; i < arr.length; i++) {
                    sum += map.get(list.get(arr[i]));
                }
                result = Math.min(result, sum);
            }
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] && i >= index){
                arr[depth] = i;
                visited[i] = true;
                backTracking(maxDepth, depth + 1, i);
                visited[i] = false;
            }
        }
    }
}

