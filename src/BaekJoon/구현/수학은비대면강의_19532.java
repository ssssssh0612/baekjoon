package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학은비대면강의_19532 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for (int i = -999; i <= 999 ; i++) {
            for (int j = -999; j <= 999; j++) {
                int nowX = i;
                int nowY = j;
                int ax = a * nowX;
                int by = b * nowY;
                if(ax + by != c){
                    continue;
                }

                int dx = d * nowX;
                int ey = e * nowY;
                if(dx + ey != f){
                    continue;
                }

                System.out.println(nowX + " " + nowY);
                return;
            }
        }
    }
}
