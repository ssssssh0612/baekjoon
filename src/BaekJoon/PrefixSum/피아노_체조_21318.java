package BaekJoon.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피아노_체조_21318 {
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        result = new int[length];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int startNum = 0;
        for(int i = 0 ; i < length - 1; i++){
            int nowNum = arr[i];
            int nextNum = arr[i + 1];
            if(nowNum > nextNum){
                startNum++;
            }
            result[i] = startNum;
        }
        result[length - 1] = startNum;

        int num = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if(a==b){
                sb.append(0).append("\n");
                continue;
            }

            // 만약 a b 의 차이가 1 이라면
            if((b - a) == 1 ){
                // 시작점이 0인경우
                if(a == 0){
                    sb.append(result[0]).append("\n");
                }else{
                    sb.append(result[a] - result[a - 1]).append("\n");
                }
                continue;
            }
            sb.append(checking(a, b)).append("\n");
        }

        System.out.println(sb);
    }
    public static int checking(int start, int end){
        if(start == 0){
            return result[end - 1];
        }else{
            return result[end - 1] - result[start - 1];
        }

    }
}
