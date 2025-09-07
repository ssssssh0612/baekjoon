package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int block = Integer.parseInt(st.nextToken());
        int[][] arr = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = Integer.MAX_VALUE;
        int resultHeight = 0;
        // 높이를 0 ~ 256 까지
        for (int i = 256; i >= 0; i--) {
            // i 를 맞추기 위해 해야하는 일을 하기
            // for 문을 돌면서 현재 필요한 블록의 개수 찾기
            int[] check = check(arr, i);
            int nowBlock = block + check[0];
            // 가능한건 더해져야 하는게 빠져야하는거보다 많아야함 그래야 가능함
            if(check[1] > nowBlock){
                continue;
            }
            int newResult = (check[0] * 2) + check[1];
            if(result > newResult){
                resultHeight = i;
                result = newResult;
            }

        }
        System.out.println(result + " " + resultHeight);
    }
    public static int[] check(int[][] arr, int height){
        // 빠지는 블록, 더해지는 블록
        int minusBlock = 0;
        int addBlock = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int num = Math.abs(arr[i][j] - height);
                if(height == arr[i][j]){
                    continue;
                }else if(height < arr[i][j]){
                    minusBlock += num;
                }else{
                    addBlock += num;
                }
            }
        }
        return new int[]{minusBlock, addBlock};
    }
}
