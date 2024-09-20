package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 낚시왕_17143 {
    static int y;
    static int x;
    static int sharkCount;
    static List<int[]> sharkList = new ArrayList<>();
    // 상 하 우 좌
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = 0;
    static int[] catcher;
    static int catcherPos;
    static final int UP = 0;
    static final int DOWN = 1;
    static final int RIGHT = 2;
    static final int LEFT = 3;
    static  int R;
    static  int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        R = y;
        C = x;
        catcherPos = 0;
        catcher = new int[x + 1];
        sharkCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < sharkCount; i++) {
            st = new StringTokenizer(br.readLine());
            // 상어 위치 , 상어 위치 , 속력 , 이동방향 , 크기
            sharkList.add(new int[]{
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken())
            });
        }

        while (catcherPos <= x) {
            fishCather();
            movingFish();
        }
        System.out.println(result);
    }

    public static void fishCather() {
        // 낚시왕이 오른쪽으로 한 칸 이동한다
        catcherPos++;
        // 가까운 상어 잡기
        List<int[]> catchFish = new ArrayList<>();
        for (int[] shark : sharkList) {
            if (shark[1] == catcherPos - 1) {
                catchFish.add(shark);
            }
        }

        if (catchFish.isEmpty()) {
            return;
        }

        Collections.sort(catchFish, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]); // 0번째 인덱스를 기준으로 비교
            }
        });

        // 정렬 후
        int[] fishDelete = catchFish.get(0);
        sharkList.removeIf(shark -> shark == fishDelete);
        result += fishDelete[4];
    }
    public static int[] getNextLoc(int i, int j, int speed, int dir) {
        int nextI = i;
        int nextJ = j;
        int nextDir = dir;
        // 상어 위치 , 상어 위치 , 속력 , 이동방향

        if (dir == UP || dir == DOWN) {  // 수직 방향 이동 (i)
            int cycle = R * 2 - 2;

            if (dir == UP) {
                speed += 2 * (R - 1) - i;
            } else {
                speed += i;
            }

            speed %= cycle;

            if (speed >= R) {
                nextI = 2 * R - 2 - speed;
                nextDir = UP;
            } else {
                nextI = speed;
                nextDir = DOWN;
            }

        } else {  // 수평 방향 이동 (j)
            int cycle = C * 2 - 2;

            if (dir == LEFT) {
                speed += 2 * (C - 1) - j;
            } else {
                speed += j;
            }

            speed %= cycle;

            if (speed >= C) {
                nextJ = 2 * C - 2 - speed;
                nextDir = LEFT;
            } else {
                nextJ = speed;
                nextDir = RIGHT;
            }
        }

        return new int[]{nextI, nextJ, nextDir};
    }

    public static void movingFish() {
        // 상어의 위치 반영하기
        int[][] fishGraph = new int[y][x];

//        // 해당 상어를 한번씩 방문하면서 위치를 바꿔주기
//        for (int i = 0; i < sharkList.size(); i++) {
//            for (int j = 0; j < sharkList.get(i)[2]; j++) {
//                int nowY = sharkList.get(i)[0] + dy[sharkList.get(i)[3]];
//                int nowX = sharkList.get(i)[1] + dx[sharkList.get(i)[3]];
//                if (checking(nowY, nowX)) {
//                    sharkList.get(i)[0] = nowY;
//                    sharkList.get(i)[1] = nowX;
//                } else {
//                    sharkList.get(i)[3] = checkDir(sharkList.get(i)[3]);
//                    int newY = sharkList.get(i)[0] + dy[sharkList.get(i)[3]];
//                    int newX = sharkList.get(i)[1] + dx[sharkList.get(i)[3]];
//                    sharkList.get(i)[0] = newY;
//                    sharkList.get(i)[1] = newX;
//                }
//            }
//        }


        for (int i = 0; i < sharkList.size(); i++) {
            int[] shark = sharkList.get(i);
            int[] nextLoc = getNextLoc(shark[0], shark[1], shark[2], shark[3]);
            sharkList.get(i)[0] = nextLoc[0];
            sharkList.get(i)[1] = nextLoc[1];
            sharkList.get(i)[3] = nextLoc[2];
            fishGraph[shark[0]][shark[1]] = fishGraph[shark[0]][shark[1]] + 1;
        }


        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (fishGraph[i][j] > 1) {
                    List<int[]> deleteFish = new ArrayList<>();
                    for (int[] shark : sharkList) {
                        if (shark[0] == i && shark[1] == j) {
                            deleteFish.add(shark);
                        }
                    }
                    Collections.sort(deleteFish, new Comparator<int[]>() {
                        @Override
                        public int compare(int[] a, int[] b) {
                            return Integer.compare(a[4], b[4]);
                        }
                    });

                    Iterator<int[]> iterator = sharkList.iterator();
                    while (iterator.hasNext()) {
                        int[] shark = iterator.next();
                        for (int l = 0; l < deleteFish.size() - 1; l++) {
                            if (deleteFish.get(l) == shark) {
                                iterator.remove();
                                break;  // 한 번 삭제하면 더 이상 비교할 필요가 없음
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean checking(int posY, int posX) {
        return posY >= 0 && posX >= 0 && posY < y && posX < x;
    }

    public static int checkDir(int dir) {
        switch (dir) {
            case 0:
                dir = 1;
                break;
            case 1:
                dir = 0;
                break;
            case 2:
                dir = 3;
                break;
            case 3:
                dir = 2;
                break;
        }
        return dir;
    }


}
