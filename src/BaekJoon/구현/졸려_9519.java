package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 졸려_9519 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        List<String> list = new ArrayList<>();
        list.add(str);
        Set<String> set = new HashSet<>();
        set.add(str);
//        StringBuilder sb = new StringBuilder("ABCDE");
//        sb.delete(sb.length()  - 2, sb.length() - 1);
//        System.out.println(sb);
        int size = set.size();
        while(true){
            StringBuilder sb = new StringBuilder(list.get(list.size() - 1));
            char[] ch = new char[sb.length() / 2];
            int index = sb.length() - 1;
            for (int i = 0; i < ch.length; i++) {
                ch[i] = sb.toString().charAt(index);
                index--;
            }
//             뒤에 두글자
//            System.out.println(sb);
            sb.delete(sb.length() - ch.length, sb.length());
//            System.out.println(sb);
            int addIndex = 1;
            for (int i = 0; i < ch.length; i++) {
                sb.insert(addIndex, ch[i]);
                addIndex += 2;
//                System.out.println(sb);
            }
            set.add(sb.toString());
            if(set.size() != size){
                size = set.size();
                list.add(sb.toString());
            }else{
                break;
            }
        }
        int result = num % size;
//        System.out.println(result);
        if(result == 0){
            System.out.println(str);
        }else{
            int index = 0;
            for (int i = list.size() - 1; i >= 0 ; i--) {
                index++;
                if(index == result){
                    System.out.println(list.get(i));
                    return;
                }
            }
        }
    }
}
