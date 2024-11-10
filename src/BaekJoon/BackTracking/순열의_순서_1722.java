package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열의_순서_1722 {
    static int[] arr;
    static boolean[] visited;
    static int count = 0;
    static int checkingCount1;
    static int[] checkingCount2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }

    public static void input(BufferedReader br) throws IOException {
        int number = Integer.parseInt(br.readLine());
        arr = new int[number];
        visited = new boolean[number + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int check = Integer.parseInt(st.nextToken());
        if (check == 1) {
            checkingCount1 = Integer.parseInt(st.nextToken());
            backTracking(0);
        } else {
//            System.out.println("?");
            checkingCount2 = new int[number];
            for (int i = 0; i < number; i++) {
                checkingCount2[i] = Integer.parseInt(st.nextToken());
            }
            backTracking2(0);
        }
    }

    public static void backTracking(int depth) {
        if (depth == arr.length) {
            count++;
            if (count == checkingCount1) {
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
            }
            return;
        }
        for (int i = 1; i <= arr.length; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void backTracking2(int depth) {
        if (depth == arr.length) {
            count++;
            int checkCount = 0;
//            for (int i = 0; i < arr.length; i++) {
//                System.out.print(arr[i] + " ");
//            }
            for (int i = 0; i < arr.length; i++) {
                if( arr[i] == checkingCount2[i] ){
                    checkCount++;
                }
            }
//            System.out.println(checkCount);
            if(checkCount == arr.length){
                System.out.println(count);
            }
            return;
        }
        for (int i = 1; i <= arr.length; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                backTracking2(depth + 1);
                visited[i] = false;
            }
        }
    }
}
