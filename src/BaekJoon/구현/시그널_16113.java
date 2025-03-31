package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.InputStreamReader;

public class 시그널_16113 {
    static String number0 = "####.##.##.####";
    static String number1 = "#####";
    static String number2 = "###..#####..###";
    static String number3 = "###..####..####";
    static String number4 = "#.##.####..#..#";
    static String number5 = "####..###..####";
    static String number6 = "####..####.####";
    static String number7 = "###..#..#..#..#";
    static String number8 = "####.#####.####";
    static String number9 = "####.####..####";
    static StringBuilder sb = new StringBuilder();
    static char[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()) / 5;
        String str = br.readLine();
        graph = new char[5][num];
        int index1 = 0;
        for(int i = 0 ; i < 5; i ++){
            for(int j = 0 ; j < num; j++){
                graph[i][j] = str.charAt(index1);
                index1++;
            }
        }

        int index = 0 ;
        while(index < num){
            // 현재 줄에 # 이 포함되어있는지
            if(checking(index)){
                // 현재 숫자가 존재한다.
                // 현재 인덱스부터 # 이 안나올때까지
                int endIndex = checkingNumber(index);
                // 현재 나온 문자열과 비교
                StringBuilder newSb = new StringBuilder();
                for(int i = 0; i < 5; i++){
                    for(int j = index; j <= endIndex; j++){
                        newSb.append(graph[i][j]);
                    }
                }
                result(newSb);
                index = endIndex + 1;
            }else{
                // 다음으로 넘기기
                index++;
            }
        }
        System.out.println(sb);
    }
    public static void result(StringBuilder newSb){
        if(newSb.toString().equals(number0)){
            sb.append(0);
        }else if(newSb.toString().equals(number1)){
            sb.append(1);
        }else if(newSb.toString().equals(number2)){
            sb.append(2);
        }else if(newSb.toString().equals(number3)){
            sb.append(3);
        }else if(newSb.toString().equals(number4)){
            sb.append(4);
        }else if(newSb.toString().equals(number5)){
            sb.append(5);
        }else if(newSb.toString().equals(number6)){
            sb.append(6);
        }else if(newSb.toString().equals(number7)){
            sb.append(7);
        }else if(newSb.toString().equals(number8)){
            sb.append(8);
        }else{
            sb.append(9);
        }
    }

    public static int checkingNumber(int index){
        int newIndex = index + 1;
        while(newIndex < graph[0].length){
            // 다음 인덱스부터 검사
            if(checking(newIndex)){
                newIndex++;
            }else{
                return newIndex - 1;
            }
        }
        return newIndex - 1;
    }

    public static boolean checking(int index){
        for(int i = 0 ; i < 5; i ++){
            char ch = graph[i][index];
            if(ch == '#'){
                return true;
            }
        }
        return false;
    }
}
