package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 크로아티아알파벳_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> set = new HashSet<>();
        set.add("c=");
        set.add("c-");
        set.add("dz=");
        set.add("d-");
        set.add("lj");
        set.add("nj");
        set.add("s=");
        set.add("z=");

        int index = 0;
        int count = 0;
        while(index < str.length()){

            if(index + 1 < str.length()){
                StringBuilder sb = new StringBuilder();
                sb.append(str.charAt(index)).append(str.charAt(index + 1));
                if(set.contains(sb.toString())){
                    index += 2;
                    count++;
                    continue;
                }
            }

            if(index + 2 < str.length() ){
                StringBuilder sb = new StringBuilder();
                sb.append(str.charAt(index)).
                        append(str.charAt(index + 1)).
                        append(str.charAt(index + 2));
                if(set.contains(sb.toString())){
                    index += 3;
                    count++;
                    continue;
                }
            }

            index++;
            count++;

        }
        System.out.println(count);
    }
}
