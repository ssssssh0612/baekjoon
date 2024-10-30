package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 임스와함께하는미니게임_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String character = st.nextToken();
        char ch = character.charAt(0);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            set.add(str);
        }
        if(ch == 'Y'){
            //2
            System.out.println(set.size());
        }else if(ch == 'F'){
            //3
            System.out.println(set.size()/2);
        }else{
            //4
            System.out.println(set.size()/3);
        }
    }
}
