package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 숫자_재배치_16943 {
    static int count;
    static boolean[] visited;
    static int[] arr;
    static int result;
    static boolean flag;
    static int finalInt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        flag = false;
        String a = st.nextToken();
        String b = st.nextToken();
        result = Integer.parseInt(b);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(a.charAt(i))));
        }
        Collections.sort(list, Collections.reverseOrder());
        int[] aArr = new int[a.length()];
        visited = new boolean[a.length()];
        arr = new int[a.length()];
        // 가장 큰 숫자에서부터 차례차례
        for (int i = 0; i < arr.length; i++) {
            aArr[i] = list.get(i);
        }
        step(aArr, 0);
        if(!flag){
            System.out.println(-1);
        }else{
            System.out.println(finalInt);
        }

    }
    public static void step(int[] aArr, int depth){
        if(depth == arr.length){
            // 이 숫자를 합쳐야함
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                // 0으로 시작하면 종료
                if(i == 0 && arr[i] == 0){
                    return;
                }
                sb.append(arr[i]);
            }
            int newResult = Integer.parseInt(sb.toString());
            if(newResult < result && !flag){
                finalInt = newResult;
                flag = true;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = aArr[i];
                step(aArr, depth + 1);
                visited[i] = false;
            }
        }

    }
}
