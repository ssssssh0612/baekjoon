package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬만들기_1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            sb.append(str.charAt(i)).append(" ");
        }
        sb.append(str.charAt(str.length() - 1));
        str = sb.toString();
        int startIndex = str.length() / 2;
        // 시작 인덱스부터 양옆을 더하고 빼가며 확인
        // 만약 더해가는 방향과 비교했을때
        for (int i = startIndex; i < str.length(); i++) {
            int plusIndex = i + 1;
            int minusIndex = i - 1;
            boolean flag = true;
            while(plusIndex < str.length()){
                char ch1 = str.charAt(plusIndex);
                char ch2 = str.charAt(minusIndex);
                if(ch1 == ch2){
                    plusIndex++;
                    minusIndex--;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                // 현재 이 기준으로 공백이 아닌 애들 찾기
                int count = 0;
                boolean check = str.charAt(i) != ' ';
                for (int j = i - 1; j >= 0; j--) {
                    if(str.charAt(j) != ' '){
                        count++;
                    }
                }
                if(check){
                    System.out.println((count * 2) + 1);
                }else{
                    System.out.println(count * 2);
                }
                break;
            }
        }
    }
}

// 0-> 1
// 1-> 3
// 2-> 5
