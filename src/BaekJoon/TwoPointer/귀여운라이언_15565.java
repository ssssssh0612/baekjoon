package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 귀여운라이언_15565 {
    static int[] arr ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int resultCount = Integer.parseInt(st.nextToken());
        arr = new int[length];
        st = new StringTokenizer(br.readLine());
        int oneCount = 0;
        for (int i = 0; i < length; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            if(arr[i] == 1){
                oneCount++;
            }
        }
        if(oneCount < resultCount){
            System.out.println(-1);
            return;
        }

        if(resultCount == 1){
            System.out.println(1);
            return;
        }


        int start = 0;
        int end = 0;
        int size = Integer.MAX_VALUE;
        int count = 1;

        // 첫번째 1 찾기
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                start = i;
                end = i + 1;
                break;
            }
        }

        while(end < arr.length){
            if(arr[end] == 1){
                count++;
                // 현재 count가 resultCount랑 맞춰지면
                if(count == resultCount){
                    size = Math.min(size, end - start + 1);
                    // 최신화 하고 현재 start + 1 에서 1이 나올떄까지
                    for (int i = start + 1; i < arr.length; i++) {
                        if(arr[i] == 1){
                            start = i;
                            break;
                        }
                    }
                    count--;
                }
            }

            end++;

        }
        System.out.println(size);
    }
}

