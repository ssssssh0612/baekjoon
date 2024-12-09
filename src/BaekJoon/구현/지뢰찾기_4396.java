package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지뢰찾기_4396 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] bomb = new char[n][n];
        char[][] map = new char[n][n];
        int[] dirx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] diry = {-1, 0, 1, -1, 1, -1, 0, 1};
        int key = 1;

        // 지뢰 위치 입력 받기
        for (int i = 0; i < n; i++) {
            String x = br.readLine();
            for (int j = 0; j < n; j++) {
                bomb[i][j] = x.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String x = br.readLine();
            for (int j = 0; j < n; j++) {
                if (x.charAt(j) == 'x') { // 지뢰를 열었을 때
                    if (bomb[i][j] == '*') { // 출력시 지뢰 부분을 *로 바꾸기 위한 표시
                        key = 0;
                    } else { // 지뢰를 열지 않았을 때
                        int count = 0;
                        for (int k = 0; k < 8; k++) { // 해당 칸을 둘러싼 8칸 검사
                            int newx = i + dirx[k];
                            int newy = j + diry[k];
                            if (newx >= 0 && newx < n && newy >= 0 && newy < n && bomb[newx][newy] == '*') // 둘러싼 칸에서 지뢰 있으면 count 1 증가
                                count++;
                        }
                        map[i][j] = (char) (count + '0');
                    }
                } else {
                    map[i][j] = '.';
                }
            }
        }

        if (key == 0) { // 지뢰 열었을 경우 지뢰 부분 *로 바꾸기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (bomb[i][j] == '*')
                        map[i][j] = '*';
                }
            }
        }

        // 전체 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.print("\n");
        }
    }
}
