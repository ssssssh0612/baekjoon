package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 생일_5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArr = new String[n];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            strArr[i] = str;
            list.add(new int[]{i,a,b,c});
        }
        Comparator<int[]> compare = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                int result = o1[3] - o2[3];
                if(result != 0){
                    return result;
                }
                result = o1[2] - o2[2];
                if(result != 0){
                    return result;
                }
                return o1[1]- o2[1];
            }
        };
        list.sort(compare);
        System.out.println(strArr[list.get(list.size() - 1)[0]]);
        System.out.println(strArr[list.get(0)[0]]);
    }
}
