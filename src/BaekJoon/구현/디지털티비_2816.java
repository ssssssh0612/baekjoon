package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 디지털티비_2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] str = new String[testCase];
        for( int i = 0; i < testCase; i++){
            str[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        int arrow = 0;
        // KBS1을 먼저 찾고
        //화살표를 한 칸 아래로 내린다. (채널 i에서 i+1로)
        //화살표를 위로 한 칸 올린다. (채널 i에서 i-1로)
        //현재 선택한 채널을 한 칸 아래로 내린다. (채널 i와 i+1의 위치를 바꾼다. 화살표는 i+1을 가리키고 있는다)
        //현재 선택한 채널을 위로 한 칸 올린다. (채널 i와 i-1의 위치를 바꾼다. 화살표는 i-1을 가리키고 있다)
        while(true){
            if(str[arrow].equals("KBS1")){
                break;
            }else{
                arrow++;
                sb.append(1);
            }
        }
        while(true){
            if(arrow != 0){
                arrow--;
                change(str,arrow,1);
                sb.append(4);
            }else{
                break;
            }
        }
        while(true){
            if(str[arrow].equals("KBS2")){
                break;
            }else{
                arrow++;
                sb.append(1);
            }
        }

        while(true){
            if(arrow != 1){
                arrow--;
                change(str,arrow,2);
                sb.append(4);
            }else{
                break;
            }
        }

        System.out.println(sb);

    }
    public static void change(String[] str, int arrow, int number){
        if(number == 1){
            String temp = str[arrow];
            str[arrow + 1] = temp;
            str[arrow] = "KBS1";
        }else{
            String temp = str[arrow];
            str[arrow + 1] = temp;
            str[arrow] = "KBS2";
        }
    }
}
