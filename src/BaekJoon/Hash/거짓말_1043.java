package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 거짓말_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int peopleNumber = Integer.parseInt(st.nextToken());
        int partyNumber = Integer.parseInt(st.nextToken());

        int result = 0;
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        if(number > 0){
            while(st.hasMoreTokens()){
                set.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < partyNumber; i++) {

        }
    }
}
