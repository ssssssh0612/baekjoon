package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뮤직비디오_inflearn {
    public int count(int[] arr, int capacity) {
        Stack<Integer> stack = new Stack<>();

        int cnt = 1, sum = 0;
        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else sum += x;
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }
        return answer;
    }

    //int low = 0;
    //        int high = arr.length;
    //        while(low < high){
    //            int mid = low + (high - low) / 2;
    //            int number = arr[mid];
    //            if(target <= number){
    //                high = mid;
    //            }else{
    //                low = mid + 1;
    //            }
    //        }
    //        return low;

    public static void main(String[] args) {
        뮤직비디오_inflearn T = new 뮤직비디오_inflearn();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(T.solution(n, m, arr));
    }
}

