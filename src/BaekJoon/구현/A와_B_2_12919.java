package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class A와_B_2_12919 {
    static boolean flag = false;
    // 이 문제가 A와 B 와 다르게 그리디문제가 아닌 이유는 A와 B는 무조건 조건이 정해져있지만,
    // 이 문제는 맨뒤, 맨 앞 이라는 조건이 생겨서 정해져있지 않아 그리디가아니고 브루트포스 문제가 된다

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        dfs(a,b);

        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

        // 1. T 문자열의 맨뒤가 A 일 경우 A 를 제거
        // 2. T 문자열의 맨앞이 B일 경우 문자열을 뒤집고 맨 뒤의 B를 제거

        // S와 문자열의 길이가 같아질 때까지 반복
    public static void dfs(String a, String b) {
        if (a.length() == b.length()) {
            if (a.equals(b)) {
                flag = true;
                return;
            } else {
                return;
            }
        }
        char end = b.charAt(b.length() - 1);
        char start = b.charAt(0);
        if (end == 'A' && start == 'B') {
            String newB1 = new StringBuilder(b).deleteCharAt(b.length() - 1).toString();
            String newB2 = new StringBuilder(b).reverse().deleteCharAt(b.length() - 1).toString();
            dfs(a, newB1);
            dfs(a, newB2);
        } else if (end == 'A') {
            String newB1 = new StringBuilder(b).deleteCharAt(b.length() - 1).toString();
            dfs(a,newB1);
        } else if (start == 'B') {
            String newB2 = new StringBuilder(b).reverse().deleteCharAt(b.length() - 1).toString();
            dfs(a,newB2);
        }
    }
}
