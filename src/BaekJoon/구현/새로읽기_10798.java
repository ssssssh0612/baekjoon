package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 새로읽기_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[15][15];
        for (int i = 0; i < 5; i++) {
            String a = br.readLine();
            for (int j = 0; j < a.length(); j++) {
                map[i][j] = a.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if(map[j][i] != '\u0000'){
                    System.out.print(map[j][i]);
                }
            }
        }
    }
}
