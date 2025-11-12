package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 에너지_모으기_16198 {
    static int[] energyArr;
    static int[] arr;
    static boolean[] visited;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        arr = new int[length - 2];
        visited = new boolean[length];
        energyArr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            energyArr[i] = Integer.parseInt(st.nextToken());
        }
        // 0 1 2 3 4
        backTracking(0);
        System.out.println(result);
    }
    public static void backTracking(int depth){
        if(depth == energyArr.length - 2){
            result = Math.max(result, result());
            return;
        }
        for (int i = 1; i < energyArr.length - 1; i++) {
            if(!visited[i]){
                arr[depth] = i;
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int result(){
        // arr 순서대로 숫자 하나씩 없애가며 계산하기
        int sum = 0;
        int[] numArr = new int[energyArr.length];
        for (int i = 0; i < energyArr.length; i++) {
            numArr[i] = energyArr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            numArr[num] = 0;
            int add1 = 0;
            int add2 = 0;
            for (int j = num; j >= 0; j--) {
                if(numArr[j] > 0){
                    add1 = numArr[j];
                    break;
                }
            }

            for (int j = num; j < energyArr.length; j++) {
                if(numArr[j] > 0){
                    add2 = numArr[j];
                    break;
                }
            }
            sum += add1 * add2;
        }

        return sum;
    }
}
