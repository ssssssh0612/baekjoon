package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 좌표압축_18870 {
    static int[] sortArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        sortArr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortArr[i] = arr[i];
        }
        Arrays.sort(sortArr);
        List<Integer> list = new ArrayList<>();
        list.add(sortArr[0]);
        for (int i = 1; i < n; i++) {
            if(sortArr[i] != sortArr[i - 1]){
                list.add(sortArr[i]);
            }
        }
        int[] binaryArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            binaryArr[i] = list.get(i);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int target = arr[i];
            result[i] = binarySearch(target, binaryArr);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
    public static int binarySearch(int target, int[] arr){
        int left = 0;
        int right = arr.length;
        while(left < right){
            int mid = (right + left) / 2;
            if(arr[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}

//-10 -9 2 4 4
// 0 1 2 3 3