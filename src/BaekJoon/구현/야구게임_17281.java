package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 야구게임_17281 {
    static int max = 0;
    // 방문
    static boolean[] visited = new boolean[9];
    // 타순
    static int[] arr = new int[9];
    static int[][] result;
    static int score = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        result = new int[number][9];
        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0] = true;
        arr[3] = 0;
        // 타순 정하기
        backTracking(0);
        System.out.println(max);
    }

    public static void backTracking(int depth) {
        if (depth == 9) {
//            for(int i = 0; i < arr.length; i ++){
//                System.out.print(arr[i]);
//            }
//            System.out.println();
            playGame();
            max = Math.max(score,max);
            score = 0;
            return;
        }
        if (depth == 3) { // 4번 타순은 건너뜀
            backTracking(depth + 1);
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void playGame() {
        // 1, 2, 3, 0
        int gameCount = result.length;
        int startNumber = 0;
        for (int i = 0; i < gameCount; i++) {
            int[] home = new int[4];
            int out = 0;
            while( out < 3 ){
                int runner = result[i][arr[startNumber]];
                if(runner == 0){
                    out++;
                    startNumber++;
                    if(startNumber == 9){
                        startNumber = 0;
                    }
                }else if(runner == 1){
                    run(home,1);
                    startNumber++;
                    if(startNumber == 9){
                        startNumber = 0;
                    }
                }else if(runner == 2){
                    run(home,2);
                    startNumber++;
                    if(startNumber == 9){
                        startNumber = 0;
                    }
                }else if(runner == 3){
                    run(home,3);
                    startNumber++;
                    if(startNumber == 9){
                        startNumber = 0;
                    }
                }else if(runner == 4){
                    run(home,4);
                    startNumber++;
                    if(startNumber == 9){
                        startNumber = 0;
                    }
                }
            }
        }
    }
    public static void run(int[] home, int run){
        for(int i = 3; i >= 1; i--){
            // 주자가 있다는 말이므로
            if(home[i] > 0){
                home[i] = 0;
                int number = i + run;
                if(number >= 4){
                    score++;
                }else{
                    home[number]++;
                }
            }
        }

        if(run == 4){
            score++;
        }else{
            home[run]++;
        }

    }
}
