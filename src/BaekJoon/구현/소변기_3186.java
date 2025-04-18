package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소변기_3186 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int oneCount = Integer.parseInt(st.nextToken());
        int zeroCount = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        String str = br.readLine();


        // 숫자가 1 인경우가 연속 3번 나온다면
        boolean oneCountCheck = false;
        boolean zeroCountCheck = true;
        boolean flag = false;
        int checkingOne = 0;
        int checkingZero = 0;

        for(int i = 0 ; i < length; i++) {
            char ch = str.charAt(i);
            if(!oneCountCheck && zeroCountCheck){
                // 맨 처음엔 무조건 여기
                // 이 구간에 있는 경우엔, 1이 연속으로 오는지 안오는지 체크하기
                // 이 구간에 있는 경우에 1이 안오고 0이오면 숫자 초기화
                if(ch == '1'){
                    checkingOne++;
                    if(checkingOne == oneCount){
                        // checkingOne 이 oneCount와 같아지는 순간 바로 변경하기
                        oneCountCheck = true;
                        zeroCountCheck = false;
                        checkingOne = 0;
                    }
                }else{
                    checkingOne = 0;
                }
            }else {
                if(ch == '0'){
                    checkingZero++;
                    if(checkingZero == zeroCount){
                        // checkingOne 이 oneCount와 같아지는 순간 바로 변경하기
                        oneCountCheck = false;
                        zeroCountCheck = true;
                        flag = true;
                        checkingZero = 0;
                        System.out.println(i+1);
                    }
                }else{
                    checkingZero = 0;
                }
            }
        }

        if(oneCountCheck){
            System.out.println(length + zeroCount);
            flag = true;
        }

        if(!flag){
            System.out.println("NIKAD");
        }
    }
}
