package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간나누기_2 {
    static int[] arr;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        arr = new int[length];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 0 - 10000 사이의 값을 매개변수 탐색해서 찾기

        int left = 0;
        int right = 10000;

        while(left < right) {
            int mid = (left + right)/2;
            if(checking(mid) <= size) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        System.out.println(right);


    }
    public static int checking(int value){
        int cnt = 1;
        int min = INF;
        int max = -INF;
        for(int i=0; i<arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if(max - min > value) {
                cnt++;
                max = -INF; min = INF;
                i--;
            }
        }
        return cnt;
    }
}
