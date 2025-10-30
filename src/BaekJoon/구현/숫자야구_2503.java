package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//import 숫자야구_2503.Game;

public class 숫자야구_2503 {
    public static class Game {
        int num;
        int strike;
        int ball;

        public Game(int num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Integer.parseInt(" 123 "));
//        int n = Integer.parseInt(br.readLine());
//        Game[] games = new Game[n];
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int num = Integer.parseInt(st.nextToken());
//            int strike = Integer.parseInt(st.nextToken());
//            int ball = Integer.parseInt(st.nextToken());
//            games[i] = new Game(num, strike, ball);
//        }
        // 이 숫자 4개를 모두 만족하는 숫자가 존재하는가 ?
        int result = 0;
        for (int i = 111; i <= 999; i++) {

            if(!check(i)){
                continue;
            }
//
//            for (int j = 0; j < games.length; j++) {
//                if(!check(i,games[j])){
//                    break;
//                }
//
//                if(j == games.length - 1){
//                    result++;
//                }
//            }

        }
        System.out.println(result);
    }
    public static boolean check(int num){
        String num1 = String.valueOf(num);
        boolean[] check = new boolean[10];
        for (int i = 0; i < num1.length(); i++) {
            int arrNum = num1.charAt(i) - '0';
            if(arrNum == 0){
                return false;
            }
            if(!check[arrNum]){
                check[arrNum] = true;
            }else{
                return false;
            }
        }
        return true;
    }
    public static boolean check(int num, 숫자야구_2503.Game game){
        String num1 = String.valueOf(num);
        String num2 = String.valueOf(game.num);

        int strikeCount = 0;
        int ballCount = 0;
        boolean[] check1 = new boolean[10];

        for (int i = 0; i < num2.length(); i++) {
            int arrNum = num2.charAt(i) - '0';
            check1[arrNum] = true;
        }

        for (int i = 0; i < 3; i++) {
            if(num1.charAt(i) == num2.charAt(i)){
                strikeCount++;
                continue;
            }
            if(check1[num1.charAt(i)-'0']){
                ballCount++;
            }
        }
        return strikeCount == game.strike && ballCount == game.ball;
    }
}

