package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자_1976 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        arr = new int[count + 1];
        for (int i = 1; i <= count; i++) {
            arr[i] = i;
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 1; i <= count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= count; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number != 0) {
                    union(i, j);
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        int number = 0;
        while (st.hasMoreTokens()) {
            int check = Integer.parseInt(st.nextToken());
            if (index == 0) {
                number = find(check);
                index++;
                continue;
            }
            int newNumber = find(check);
            if (newNumber != number) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A > B) {
            arr[A] = B;
        } else {
            arr[B] = A;
        }
    }

    public static int find(int number) {
        if (arr[number] == number) {
            return number;
        }
        return arr[number] = find(arr[number]);
    }
}
