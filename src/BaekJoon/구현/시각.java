package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시각 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 맨 처음 00 00 00 부터 시작
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n1 = st.nextToken();
        String num = st.nextToken();
        StringBuilder[] sb = new StringBuilder[3];
        sb[0] = new StringBuilder();
        sb[1] = new StringBuilder();
        sb[2] = new StringBuilder();

        int[] arr = new int[3];
        sb[0].append("00");
        sb[1].append("00");
        sb[2].append("00");
        int count = 0;
        while(true){
            if(arr[0] > Integer.parseInt(n1)){
                break;
            }

            // 현재 StringBuilder 를 돌면서 숫자가 포함되어있는지 확인
            for (int i = 0; i < 3; i++) {
                if(sb[i].toString().contains(num)){
                    count++;
                    break;
                }
            }

            // 0을 더함
            arr[2]++;
            if(arr[2] < 10){
                sb[2] = new StringBuilder("0").append(arr[2]);
            }else{
                sb[2] = new StringBuilder().append(arr[2]);
            }

            if(arr[2] == 60){
                arr[1]++;
                sb[2] = new StringBuilder("00");
                arr[2] = 0;
                if(arr[1] < 10){
                    sb[1] = new StringBuilder("0").append(arr[1]);
                }else{
                    sb[1] = new StringBuilder().append(arr[1]);
                }
            }

            if(arr[1] == 60){
                arr[0]++;
                sb[1] = new StringBuilder("00");
                arr[1] = 0;
                if(arr[0] < 10){
                    sb[0] = new StringBuilder("0").append(arr[0]);
                }else{
                    sb[0] = new StringBuilder().append(arr[0]);
                }
            }

        }
        System.out.println(count);
    }
}
