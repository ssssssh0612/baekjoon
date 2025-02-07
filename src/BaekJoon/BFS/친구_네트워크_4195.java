package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 친구_네트워크_4195 {
    static int[] arr, size;
    static int count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            input(br);
        }
        System.out.println(sb);
    }

    public static void input(BufferedReader br) throws IOException {
        int number = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        arr = new int[number * 2];
        size = new int[number * 2];
        count = 1;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            size[i] = 1; // 초기 크기 1
        }
        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();
            if (!map.containsKey(name1)) {
                map.put(name1, index);
                index++;
            }

            if (!map.containsKey(name2)) {
                map.put(name2, index);
                index++;
            }
            // 1, 2를 저장하고나서
            int number1 = map.get(name1);
            int number2 = map.get(name2);

            sb.append(union(number1, number2)).append("\n");
        }
    }

    // 이 부분 최적화를 잘 모르겠어서 답을 봤다
    // 최적화할때 우리가 어떠한 값에 집중해야하는지 생각했을때 답을 구할 확률이 높아지는거같다
    public static int union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A != B) { // A와 B가 다를 경우만 병합
            if (size[A] < size[B]) { // 항상 B가 더 작은 집합이 되도록 정렬
                int temp = A;
                A = B;
                B = temp;
            }
            arr[B] = A; // 작은 집합을 큰 집합에 연결
            size[A] += size[B]; // 새로운 루트의 크기 갱신
        }

        return size[A]; // A가 대표하는 집합 크기 반환
    }

    public static int find(int number) {
        if (arr[number] == number) {
            return number;
        }
        return arr[number] = find(arr[number]);
    }
}
