package BaekJoon.Hash;

import java.util.*;

public class K번째큰수_inflearn {
    static boolean[] visited;
    static int[] result = new int[3];
    static TreeSet<Integer> set = new TreeSet<>();
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int k = sc.nextInt();
        arr = new int[count];
        visited = new boolean[count];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        backTracking(0);
        List<Integer> list = new ArrayList<>(set);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i)+" ");
//        }
        try {
            int number = k - 1;
            int index = list.size() - 1 - (number);
            System.out.println(list.get(index));
        } catch (Exception e) {
            System.out.println(-1);
        }
    }

    public static void backTracking(int depth) {
        if (depth == 3) {
            int a = 0;
            for (int i = 0; i < 3; i++) {
                a += result[i];
            }
            set.add(a);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                result[depth] = arr[i];
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
