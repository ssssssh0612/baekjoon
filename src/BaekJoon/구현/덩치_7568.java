package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 덩치_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0});
        }
        for (int i = 0; i < list.size(); i++) {
            int kg = list.get(i)[0];
            int cm = list.get(i)[1];
            for (int j = 0; j < list.size(); j++) {
                int kg2 = list.get(j)[0];
                int cm2 = list.get(j)[1];
                if( i != j && kg < kg2 && cm < cm2){
                    list.get(i)[2]++;
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)[2]+1+" ");
        }
    }
}
