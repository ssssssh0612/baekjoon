package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 단어순서_뒤집기_12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st  = new StringTokenizer(br.readLine());
            List<String> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }
            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = list.size() - 1; j >= 0 ; j--) {
                System.out.print(list.get(j)+ " ");
            }
            System.out.println();
        }
    }
}
