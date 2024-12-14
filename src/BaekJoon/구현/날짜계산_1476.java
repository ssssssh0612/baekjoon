package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짜계산_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] compareArr = new int[3];
        compareArr[0] = E;
        compareArr[1] = S;
        compareArr[2] = M;

        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;

        int result = 1;

        // 16
        // 29
        // 20
        if(checking(arr,compareArr)){
            System.out.println(result);
            return;
        }

        while(true){
            result++;
            arr[0]++;
            arr[1]++;
            arr[2]++;
            if(arr[0] == 16){
                arr[0] = 1;
            }
            if(arr[1] == 29){
                arr[1] = 1;
            }
            if(arr[2] == 20){
                arr[2] = 1;
            }
            if(checking(arr,compareArr)){
                System.out.println(result);
                break;
            }
        }
    }
    public static boolean checking(int[] arr, int[] compareArr) {
        if (arr[0] == compareArr[0] && arr[1] == compareArr[1] && arr[2] == compareArr[2]) {
            return true;
        }
        return false;
    }
}
