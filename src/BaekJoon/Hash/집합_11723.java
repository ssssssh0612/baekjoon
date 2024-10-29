package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 집합_11723 {

    public static void main(String[] args) throws IOException {
        //비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
        //add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
        //remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
        //check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
        //toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
        //all: S를 {1, 2, ..., 20} 으로 바꾼다.
        //empty: S를 공집합으로 바꾼다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if (a.equals("add")) {
                int number = Integer.parseInt(st.nextToken());
                set.add(number);
            } else if (a.equals("remove")) {
                int number = Integer.parseInt(st.nextToken());
                set.remove(number);
            } else if (a.equals("check")) {
                int number = Integer.parseInt(st.nextToken());
                if (set.contains(number)) {
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            } else if (a.equals("toggle")) {
                int number = Integer.parseInt(st.nextToken());
                if (set.contains(number)) {
                    set.remove(number);
                }else{
                    set.add(number);
                }
            } else if (a.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else {
                set.clear();
            }
        }
        System.out.println(sb);
    }
}
