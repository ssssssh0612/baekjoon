package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 인사성_밝은_곰곰이_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int result = 0 ;
        while(length > 0){
            String str = br.readLine();
            if(str.equals("ENTER")){
                result += set.size();
                set = new HashSet<>();
            }else{
                set.add(str);
            }
            length--;
        }
        System.out.println(result + set.size());
    }
}
