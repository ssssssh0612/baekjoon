package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 로마숫자만들기_16922 {
    static int[] arr = new int[]{1,5,10,50};
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        backTracking(0,0,n,0);
        System.out.println(set.size());
    }
    public static void backTracking(int num, int depth, int maxDepth, int nowNum){
        if(depth == maxDepth){
            set.add(nowNum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(i >= num){
                backTracking(i, depth + 1, maxDepth, nowNum + arr[i]);
            }
        }
    }
}
