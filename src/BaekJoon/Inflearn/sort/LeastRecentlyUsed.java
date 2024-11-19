package BaekJoon.Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LeastRecentlyUsed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);

    }
    public static void input(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int[] cache = new int[length];
        int arrLength = Integer.parseInt(st.nextToken());
        int[] arr = new int[arrLength];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < arr.length ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < arr.length; i ++){
            int number = arr[i];
            int zeroCount = 0;
            // 현재 숫자와 같은게 있는지 체크하기
            for(int j = 0 ; i < cache.length ; j ++) {
                // 0 의 개수가 cache.length 와 같다면 그냥 삽입해주기
                if (cache[j] == 0) {
                    zeroCount++;
                }
            }
            if(zeroCount == length){
                cache[0] = number;
            }

            // 만약 같은게 없다면 0이 존재하는지 체크하기


        }

    }
}
