package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class 수강신청_13414 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(int i = 0 ; i < length; i++){
            String str = br.readLine();
            if(set.contains(str)){
                set.remove(str);
                set.add(str);
            }else{
                set.add(str);
            }
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for(String str : set){
            if(index == count){
                break;
            }
            sb.append(str).append("\n");
            index++;
        }

        System.out.println(sb);

    }

}
