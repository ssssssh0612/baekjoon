package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 십자카드문제_2659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        String[] str = new String[4];

        str[0] = new StringBuilder().append(arr[0]).append(arr[1]).append(arr[2]).append(arr[3]).toString();
        str[1] = new StringBuilder().append(arr[1]).append(arr[2]).append(arr[3]).append(arr[0]).toString();
        str[2] = new StringBuilder().append(arr[2]).append(arr[3]).append(arr[0]).append(arr[1]).toString();
        str[3] = new StringBuilder().append(arr[3]).append(arr[0]).append(arr[1]).append(arr[2]).toString();

        Arrays.sort(str);

        // 맨 처음에 모든 시계수를 찾기
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        // 이 숫자에 대한 시계수를 찾기
                        StringBuilder sb1 = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();
                        StringBuilder sb3 = new StringBuilder();
                        StringBuilder sb4 = new StringBuilder();
                        sb1.append(i).append(j).append(k).append(l);
                        sb2.append(j).append(k).append(l).append(i);
                        sb3.append(k).append(l).append(i).append(j);
                        sb4.append(l).append(i).append(j).append(k);
                        String[] strArr = new String[4];
                        strArr[0] = sb1.toString();
                        strArr[1] = sb2.toString();
                        strArr[2] = sb3.toString();
                        strArr[3] = sb4.toString();
                        Arrays.sort(strArr);
                        set.add(strArr[0]);
                    }
                }
            }
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        // 얘가 몇번째인지 찾기

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(str[0])){
                System.out.println(i + 1);
                break;
            }
        }
    }
}
