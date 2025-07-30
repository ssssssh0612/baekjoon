package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기타레슨_2343 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int resultNum = Integer.MAX_VALUE;
        // 블루레이 3개로 담을 수 있는지 없는지 확인하기
        int sum = 0;

        int[] arr = new int[num];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int left = Arrays.stream(arr).max().getAsInt();;
        int right = sum;

        while(left < right){
            int mid = (left + right) / 2;
            if(count >= checking(arr,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
// count 개수가 더 많다면 보따리가 더 많다는 의미 이므로 보따리를 줄여야함 보따리를 늘리려면 크기를 늘려야함

        }
        System.out.println(left);

    }
    public static int checking(int[] arr, int mid){
        int count = 1; // 최소 블루레이 1개 필요
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > mid) {
                count++;        // 블루레이 하나 추가
                sum = arr[i];   // 새로운 블루레이에 이 강의부터 시작
            } else {
                sum += arr[i];
            }
        }

        return count;
    }
}
