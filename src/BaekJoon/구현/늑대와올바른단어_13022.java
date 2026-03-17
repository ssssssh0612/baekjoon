package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 늑대와올바른단어_13022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.length() < 4){
            System.out.println(0);
            return;
        }

        int number = 0; // n 을 결정하는 숫자
        char before = str.charAt(0);
        // 전거만 보면 됨

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        // wolfwolf
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            char ch2 = str.charAt(i - 1);
            if(ch == 'w' && ch2 == 'f'){
                list.add(sb.toString());
                sb = new StringBuilder();
                sb.append(ch);
            }else{
                sb.append(ch);
            }
        }
        if(sb.length() > 0){
            list.add(sb.toString());
        }

        for (int i = 0; i < list.size(); i++) {
            if(checking(list.get(i))){
                continue;
            }else{
                System.out.println(0);
                return;
            }
        }
        if(list.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(1);
        }
    }
    public static boolean checking(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'w'){
                count++;
            }else{
                break;
            }
        }

        // 같은게 횟수만큼 나와야함
         if(count * 4 == str.length()){
             int ch = 0;
             int index = 0;
             for (int i = 0; i < str.length(); i++) {
                 if(ch == 0){
                     if(str.charAt(i) == 'w'){
                        index++;
                     }else{
                         return false;
                     }
                 }else if(ch == 1){
                     if(str.charAt(i) == 'o'){
                         index++;
                     }else{
                         return false;
                     }

                 }else if(ch == 2){
                     if(str.charAt(i) == 'l'){
                         index++;
                     }else{
                         return false;
                     }
                 }else if(ch == 3){
                     if(str.charAt(i) == 'f'){
                         index++;
                     }else{
                         return false;
                     }
                 }
                 if(index == count){
                     ch++;
                     index = 0;
                 }
             }
         }else{
             return false;
         }
         return true;
    }
}
