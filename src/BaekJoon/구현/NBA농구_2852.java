package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NBA농구_2852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int winner = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            String[] arr = str.split(":");
            int num1 = Integer.parseInt(arr[0]) * 60;
            int num2 = Integer.parseInt(arr[1]);
            list.add(new int[]{winner, num1 + num2});
        }

        int team1 = 0;
        int team2 = 0;

        int team1Time = 0;
        int team2Time = 0;

        for (int i = 0; i < 2880; i++) {
            for (int j = 0; j < list.size(); j++) {
                int[] arr = list.get(j);
                if(i == arr[1]){
                    if(arr[0] == 1){
                        team1++;
                    }else{
                        team2++;
                    }
                }
            }
            if(team1 > team2){
                team1Time++;
            }else if(team1 < team2){
                team2Time++;
            }
        }

        String minute = convertNumber(team1Time / 60);
        String second = convertNumber(team1Time % 60);

        String minute1 = convertNumber(team2Time / 60);
        String second1 = convertNumber(team2Time % 60);

        System.out.println(minute + ":" + second);
        System.out.println(minute1 + ":" + second1);

    }
    public static String convertNumber(int num){
        if(num < 10){
            StringBuilder sb = new StringBuilder();
            sb.append("0").append(num);
            return sb.toString();
        }
        return String.valueOf(num);
    }

}
