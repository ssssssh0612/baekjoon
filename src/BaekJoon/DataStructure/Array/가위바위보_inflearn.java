package BaekJoon.DataStructure.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가위바위보_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aList.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bList.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            char d  = winner(aList.get(i), bList.get(i));
            System.out.println(d);
        }

    }
    // 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보
    public static char winner(int a, int b){
        // a가 이기는 경우의 수
        if( a == 1 ){
            if( b == 1 ){
                return 'D';
            }else if ( b == 2 ){
                return 'B';
            }else if ( b == 3 ){
                return 'A';
            }
        }else if( a == 2 ){
            if( b == 1 ){
                return 'A';
            }else if ( b == 2 ){
                return 'D';
            }else if ( b == 3 ){
                return 'B';
            }
        }else if( a == 3 ){
            if( b == 1 ){
                return 'B';
            }else if ( b == 2 ){
                return 'A';
            }else if ( b == 3 ){
                return 'D';
            }
        }
        return ' ';
    }
}
