package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무꾼_이다솜_1421 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }
        long result = 0;
        for (int i = 1; i <= max; i++) {
            long moneySum = 0;
            for (int j = 0; j < n; j++) {
                // 여기서 계산한 값이 양수가 나오면 moneySum 에 더해주고 그렇지 않은경우 빼주기
                int treeCount = 0;
                int count = 0;
                if(arr[j] > i){
                    if(arr[j] % i == 0){
                        count += arr[j]/i - 1;
                        treeCount += arr[j]/i;
                    }else{
                        count += arr[j]/i;
                        treeCount += arr[j]/i;
                    }
                    int price = (l * i * treeCount) - (m * count);
                    if(price > 0){
                        moneySum += price;
                    }
                }else if(arr[j] == i){ // 이 두개가 같은 경우
                    treeCount++;
                    int price = (l * i * treeCount) - (m * count);
                    if(price > 0){
                        moneySum += price;
                    }
                }

            }

            result = Math.max(moneySum, result);
        }
        System.out.println(result);
        // 자른다, 안자른다 어떻게 구분하지
    }
}
