package BaekJoon.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 인간컴퓨터상호작용_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            int[] arr = new int[26];
            int index = str.charAt(i) - 97;
            if(i == 0){
                arr[index]++;
                list.add(arr);
                continue;
            }
            int[] copy = list.get(i - 1);
            System.arraycopy(copy, 0, arr, 0, 26);
            arr[index]++;
            list.add(arr);
        }
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String number = st.nextToken();

            int index = number.charAt(0) - 97;

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start == end){
                if((char)index + 97 == str.charAt(start)){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }

                continue;
            }

            start--;

            if(start == -1){
                sb.append(list.get(end)[index]).append("\n");
                continue;
            }

            int[] now = new int[26];
            int[] startArr = list.get(start);
            int[] endArr = list.get(end);

            for (int j = 0; j < 26; j++) {
                now[j] = endArr[j] - startArr[j];
            }

            sb.append(now[index]).append("\n");
        }
        System.out.print(sb);
    }
}

//seungjaehwang
//4
// a 0 5
// a 0 6
// a 6 10
// a 7 10
//
