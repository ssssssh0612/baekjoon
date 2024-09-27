package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자카드_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int b = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            if(set.contains(Integer.parseInt(st.nextToken()))) {
                System.out.print(1+" ");
            }else{
                System.out.print(0+" ");
            }
        }
    }
}
