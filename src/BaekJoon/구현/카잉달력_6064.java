package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카잉달력_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(step(m,n,x,y)).append("\n");
        }
        System.out.println(sb);
    }
    public static int step(int m, int n, int x, int y){
        int[] arr = new int[]{1,1};
        int count = 1;
        while(true){
            if(arr[0] == m && arr[1] == n){
                if(m == x && n == y){
                    return count;
                }
                break;
            }

            if(arr[0] == x && arr[1] == y){
                return count;
            }

            if(arr[0] < m){
                arr[0] += 1;
            }else{
                arr[0] = 1;
            }

            if(arr[1] < n){
                arr[1] += 1;
            }else{
                arr[1] = 1;
            }

            count++;
        }
        return -1;
    }
}
