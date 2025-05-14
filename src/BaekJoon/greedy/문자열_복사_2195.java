package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_복사_2195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String result = br.readLine();
        int length = result.length();

        int index = 0;
        int RESULT = 0;
        while(index < length){
            // for 문을 돌면서 현재 인덱스에서 가장 길게 나오는 값
            int max = 0;
            for(int i = 0; i < str.length(); i++){
                int innerIndex = i;
                int count = 0;
                for(int j = index; j < length; j++){
                    if(innerIndex == str.length()){
                        break;
                    }

                    if(str.charAt(innerIndex) == result.charAt(j)){
                        count++;
                        innerIndex++;
                    }else{
                        break;
                    }
                }
                max = Math.max(count, max);
            }
            index += max;
            RESULT++;
        }
        System.out.println(RESULT);
    }
}
