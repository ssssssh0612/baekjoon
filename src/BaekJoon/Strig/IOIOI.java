package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        StringBuilder sb = new StringBuilder("IOI");
        for(int i = 1; i < num; i++){
            sb.append("OI");
        }

        String compare = sb.toString();
        int index = 0;
        int count = 0;
        while(index < length){
            if(index + compare.length() > length){
                // 더이상 검사할 이유가 없어 종료
                break;
            }
            // 현재 인덱스부터 검사하기,
            boolean flag = true;
            for(int i = 0 ; i < compare.length(); i++){
                // 하다가 다른게 나오면 해당 인덱스부터 다시시작
                int newIndex = index + i;
                if(newIndex >= length){
                    flag = false;
                    break;
                }
                if(str.charAt(newIndex) == compare.charAt(i)){
                    continue;
                }else{
                    if(i == 0){
                        index = newIndex + 1;
                    }else{
                        index = newIndex;
                    }
                    flag = false;
                    break;
                }
            }
            if(!flag){
                continue;
            }
            // 다른게 나온다면 다시 시작
            count++;
            index+=2;
        }
        System.out.println(count);

    }
}
