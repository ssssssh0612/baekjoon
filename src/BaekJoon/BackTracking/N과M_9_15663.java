package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N과M_9_15663 {
    static int[] arr;
    static List<Integer> list;
    static int n;
    static boolean[] visited;
    static List<int[]> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken()); // depth
        list = new ArrayList<>();
        arr = new int[n];
        visited = new boolean[length];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        backTracking(0);
    }
    public static void backTracking(int depth) {
        if(depth == n) {
            if(!result.isEmpty()){
                for (int i = 0; i < result.size(); i++) {
                    int[] check = result.get(i);
                    int count = 0;
                    for (int j = 0; j < n; j++) {
                        if(arr[j] == check[j]) {
                            count++;
                        }
                    }
                    if(count == n) {
                        return;
                    }
                }

                int[] newArr = new int[n];
                for (int i = 0; i < n; i++) {
                    int number = arr[i];
                    newArr[i] = number;
                }
                result.add(newArr);
                for (int i = 0; i < n; i++) {
                    System.out.print(newArr[i]+" ");
                }
            }else{
                int[] newArr = new int[n];
                for (int i = 0; i < n; i++) {
                    int number = arr[i];
                    newArr[i] = number;
                }
                result.add(newArr);
                for (int i = 0; i < n; i++) {
                    System.out.print(newArr[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = list.get(i);
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
