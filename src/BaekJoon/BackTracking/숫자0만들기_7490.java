package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 숫자0만들기_7490 {
    static int length;
    static StringBuilder sbResult = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++){
            int number = Integer.parseInt(br.readLine());
            // 숫자 입력 받고 해당 숫자까지 depth
            length = number + 1;
            backTracking(2,"1");
            System.out.println();
        }
    }
    public static void backTracking(int depth, String str){
        if(length == depth){
//            System.out.println(str);
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < str.length(); i++){
                if(str.charAt(i) != ' '){
                    sb.append(str.charAt(i));
                }
            }
            List<Integer> list = new ArrayList<>();
            List<Boolean> plusOrMinus = new ArrayList<>();
            // 숫자를 저장하기

            int pointer = 0;
            StringBuilder addNumber = new StringBuilder();
            while(pointer < sb.length()){
                char ch = sb.charAt(pointer);
                if((ch == '+') || (ch == '-')){
                    if (ch == '+') {
                        plusOrMinus.add(true);
                        list.add(Integer.valueOf(addNumber.toString()));
                        addNumber = new StringBuilder();
                    }else{
                        list.add(Integer.valueOf(addNumber.toString()));
                        addNumber = new StringBuilder();
                        plusOrMinus.add(false);
                    }
                }else{
                    addNumber.append(ch);
                }
                pointer++;
                if(pointer == sb.length()){
                    list.add(Integer.valueOf(addNumber.toString()));
                }
            }
            // 1 + 2 + 3
            int result = list.get(0);
            for(int i = 1 ; i < list.size(); i++){
                if(plusOrMinus.get(i - 1)){
                    result += list.get(i);
                }else{
                    result -= list.get(i);
                }
            }

            if(result == 0){
                System.out.println(str);
            }

            return;
        }

        // 숫자 합치기
        String newString2 = str + " " + depth;
//        System.out.println(str);
        backTracking(depth + 1, newString2);
        // 더하기
        String newString = str + "+" + depth;
//        System.out.println(str);
        backTracking(depth + 1, newString);
        // 빼기
        String newString1 = str + "-" + depth;
//        System.out.println(str);
        backTracking(depth + 1, newString1);
    }
}

//1-2 3+4+5+6+7


//1-2 3-4 5+6 7
//1-2+3+4-5+6-7
//1-2-3-4-5+6+7
