package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 피카츄_14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int index = 0;
        boolean flag = true;
        while(index < str.length()){
            char ch = str.charAt(index);
//            System.out.println(index);
            if(ch == 'p'){
                // 그럼 다음이 i
                // index + 1 이 범위안에 들어오는지
                if(index + 1 < str.length() && str.charAt(index + 1) == 'i'){
                    index = index + 2;
                }else{
                    flag = false;
                    break;
                }
            }else if(ch == 'k'){
                // 그럼 다음이 a
                if(index + 1 < str.length() && str.charAt(index + 1) == 'a'){
                    index = index + 2;
                }else{
                    flag = false;
                    break;
                }
            }else if(ch == 'c'){
                // 그럼 다음 h 다음이 u
                if(index + 2 < str.length()){
                    if(str.charAt(index + 1) == 'h' && str.charAt(index + 2) == 'u'){
                        index = index + 3;
                    }else{
                        flag = false;
                        break;
                    }
                }else{
                    flag = false;
                    break;
                }
            }else{
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
