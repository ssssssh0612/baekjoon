package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 번데기_15721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int check = 0;
        int newIndex = 4;
        int nowIndex = 0;
        int index = 0;
        int zeroCount = 0;
        int oneCount = 0;
        while(true){
            if(index == a){
                index = 0;
            }

            if(check < 4){
                if(check % 2 == 0){
                    zeroCount++;
                }else{
                    oneCount++;
                }
                check++;


                if (c == 0 && zeroCount == b) {
                    System.out.println(index);
                    return;
                }
                if (c == 1 && oneCount == b){
                    System.out.println(index);
                    return;
                }
                index++;
                continue;
            }

            if(check == 4 && nowIndex != newIndex){
                if(nowIndex < newIndex / 2){
                    zeroCount++;
                }else{
                    oneCount++;
                }
                nowIndex++;
            }

            if(nowIndex == newIndex){
                check = 0;
                newIndex += 2;
                nowIndex = 0;
            }

            if (c == 0 && zeroCount == b) {
                System.out.println(index);
                return;
            }
            if (c == 1 && oneCount == b){
                System.out.println(index);
                return;
            }

            index++;
        }


    }
}
