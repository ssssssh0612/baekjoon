package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어_뒤집기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int index = 0;
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        StringBuilder add = new StringBuilder();
        while(index < str.length()){
            char ch = str.charAt(index);
            if(ch == ' '){
                if(!flag && !add.equals("")){
                    StringBuilder addSb = new StringBuilder(add);
                    sb.append(addSb.reverse()).append(" ");
                    add = new StringBuilder();
                    index++;
                }else{
                    sb.append(" ");
                    index++;
                }
                continue;
            }

            if(ch == '>'){
                sb.append(ch);
                flag = false;
                index++;
                continue;
            }

            if(flag){
                sb.append(ch);
                index++;
                continue;
            }

            if(ch == '<'){
                if(!add.equals("")){
                    StringBuilder addSb = new StringBuilder(add);
                    sb.append(addSb.reverse());
                    add = new StringBuilder();
                }
                sb.append(ch);
                flag = true;
                index++;
                continue;
            }
            add.append(ch);
            index++;
        }
        if(!add.equals("")){
            StringBuilder addSb = new StringBuilder(add);
            sb.append(addSb.reverse());
            add = new StringBuilder();
        }
        System.out.println(sb);
    }
}
