package BaekJoon.구현;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 킹_1063 {
    static int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static Map<String, Integer> map = new HashMap<>();
    static Map<Integer, Integer> mapY = new HashMap<>();
    static Map<String, Integer> mapX = new HashMap<>();
    static int[] kingPos = new int[2];
    static int[] rockPos = new int[2];

    public static void main(String[] args) throws IOException {
        map.put("R", 0);
        map.put("L", 1);
        map.put("B", 2);
        map.put("T", 3);
        map.put("RT", 4);
        map.put("LT", 5);
        map.put("RB", 6);
        map.put("LB", 7);

        mapY.put(8, 0);
        mapY.put(7, 1);
        mapY.put(6, 2);
        mapY.put(5, 3);
        mapY.put(4, 4);
        mapY.put(3, 5);
        mapY.put(2, 6);
        mapY.put(1, 7);

        mapX.put("A", 0);
        mapX.put("B", 1);
        mapX.put("C", 2);
        mapX.put("D", 3);
        mapX.put("E", 4);
        mapX.put("F", 5);
        mapX.put("G", 6);
        mapX.put("H", 7);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        int kingX = mapX.get(king.charAt(0) + "");
        int kingY = mapY.get(king.charAt(1) - '0');
        kingPos[0] = kingY;
        kingPos[1] = kingX;

        String rock = st.nextToken();
        int rockX = mapX.get(rock.charAt(0) + "");
        int rockY = mapY.get(rock.charAt(1) - '0');
        rockPos[0] = rockY;
        rockPos[1] = rockX;

        int length = Integer.parseInt(st.nextToken());

        for (int i = 0; i < length; i++) {
            int num = map.get(br.readLine());
            int nextY = kingPos[0] + dy[num];
            int nextX = kingPos[1] + dx[num];
            // 범위 벗어나면 종료
            if(!checking(nextY, nextX)){
                continue;
            }
            // 만약 돌 위치랑 같을경우
            if(nextY == rockPos[0] && nextX == rockPos[1]){
                int nextRockY = rockPos[0] + dy[num];
                int nextRockX = rockPos[1] + dx[num];
                if(checking(nextRockY, nextRockX)){
                    rockPos[0] = nextRockY;
                    rockPos[1] = nextRockX;
                    kingPos[0] = nextY;
                    kingPos[1] = nextX;
                    continue;
                }
                continue;
            }

            // 돌 위치랑 같지않고 범위에 벗어나지 않으면
            kingPos[0] = nextY;
            kingPos[1] = nextX;
        }

        int num = Math.abs(kingPos[0] - 8);
        char ch = (char)(kingPos[1] + 65);
        System.out.println(ch + "" + num);
        int num1 = Math.abs(rockPos[0] - 8);
        char ch1 = (char)(rockPos[1] + 65);
        System.out.println(ch1+ "" + num1);

    }

    public static boolean checking(int y, int x) {
        return y >= 0 && y < 8 && x >= 0 && x < 8;
    }
}
