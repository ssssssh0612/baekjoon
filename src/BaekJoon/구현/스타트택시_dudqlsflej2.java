package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스타트택시_dudqlsflej2 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int taxiX = Integer.parseInt(st.nextToken()) - 1;
        int taxiY = Integer.parseInt(st.nextToken()) - 1;

        Taxi taxi = new Taxi(taxiX, taxiY, k);

        Passenger[] passengers = new Passenger[m + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int fromX = Integer.parseInt(st.nextToken()) - 1;
            int fromY = Integer.parseInt(st.nextToken()) - 1;
            int toX = Integer.parseInt(st.nextToken()) - 1;
            int toY = Integer.parseInt(st.nextToken()) - 1;

            // 이거 왜 -1 한고 +1 하는지 잘 모르겠음 걍 0부터 하면되는데
            int distanceToDestination = -1;
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];
            queue.add(new int[]{fromX, fromY});
            visited[fromX][fromY] = true;
            boolean isArrived = false;

            // 여기서 왜 시작하자마자 다 bfs 도는지 이해가안됨 설명좀
            // 내 예측 아마 모든 승객들 거리, 현재 택시 최단거리 비교하는거같음
            while (!queue.isEmpty()) {
                int size = queue.size();
                distanceToDestination++;
                for (int j = 0; j < size; j++) {
                    int[] cur = queue.poll();
                    int curX = cur[0];
                    int curY = cur[1];

                    if (curX == toX && curY == toY) {
                        isArrived = true;
                        break;
                    }

                    for (int l = 0; l < 4; l++) {
                        int nextX = curX + dx[l];
                        int nextY = curY + dy[l];

                        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n
                                || visited[nextX][nextY] || map[nextX][nextY] == 1)
                            continue;

                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
                if (isArrived)
                    break;
            }

            if (isArrived)
                passengers[i] = new Passenger(i, fromX, fromY, toX, toY, 0, distanceToDestination, false);
            else
                passengers[i] = new Passenger(i, fromX, fromY, toX, toY, 0, -1, false);
        }

        int turn = 0;
        while (turn < m) {
            turn++;
            ArrayList<Passenger> passengerList = new ArrayList<>();
            // estimate the distance to taxi
            for (int i = 1; i <= m; i++) {
                // 여기서 승객 모두한테 bfs 돌리는거 안미 ?
                // 그럼 승객모두는아니고 한명 도착할때마다 bfs돈다는거잖아
                // 승객 5명있어 그럼 한명 도착지 도착하면 4명 돌고
                if (!passengers[i].isDelivered) {
                    int distanceToPassenger = -1;
                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[n][n];
                    queue.add(new int[]{taxi.posX, taxi.posY});
                    visited[taxi.posX][taxi.posY] = true;
                    boolean isArrived = false;

                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        distanceToPassenger++;
                        for (int j = 0; j < size; j++) {
                            int[] cur = queue.poll();
                            int curX = cur[0];
                            int curY = cur[1];

                            if (curX == passengers[i].fromX && curY == passengers[i].fromY) {
                                isArrived = true;
                                break;
                            }

                            for (int l = 0; l < 4; l++) {
                                int nextX = curX + dx[l];
                                int nextY = curY + dy[l];

                                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || visited[nextX][nextY] || map[nextX][nextY] == 1)
                                    continue;

                                visited[nextX][nextY] = true;
                                queue.add(new int[]{nextX, nextY});
                            }
                        }
                        if (isArrived)
                            break;
                    }
                    passengers[i].distanceToTaxi = distanceToPassenger;
                    if (passengers[i].distanceToDestination != -1)
                        passengerList.add(passengers[i]);
                }
            }

            Collections.sort(passengerList, new Comparator<Passenger>() {
                @Override
                public int compare(Passenger o1, Passenger o2) {
                    if (o1.distanceToTaxi != o2.distanceToTaxi)
                        return o1.distanceToTaxi - o2.distanceToTaxi;
                    else {
                        if (o1.fromX != o2.fromX)
                            return o1.fromX - o2.fromX;
                        else
                            return o1.fromY - o2.fromY;
                    }
                }
            });

            if (passengerList.isEmpty())
                break;
            int curUsedFuel = passengerList.get(0).distanceToTaxi + passengerList.get(0).distanceToDestination;
            if (curUsedFuel > taxi.fuel)
                break;
            else {
                passengers[passengerList.get(0).num].isDelivered = true;
                taxi.posX = passengerList.get(0).toX;
                taxi.posY = passengerList.get(0).toY;
                taxi.fuel -= curUsedFuel;
                taxi.fuel += (passengerList.get(0).distanceToDestination * 2);
            }
        }

        boolean allMoved = true;
        for (int i = 1; i <= m; i++) {
            if (!passengers[i].isDelivered) {
                allMoved = false;
                break;
            }
        }

        if (allMoved)
            System.out.println(taxi.fuel);
        else
            System.out.println(-1);
    }

    private static class Passenger {
        int num;
        int fromX;
        int fromY;
        int toX;
        int toY;
        int distanceToTaxi;
        int distanceToDestination;
        boolean isDelivered;

        private Passenger(int num, int fromX, int fromY, int toX, int toY, int distanceToTaxi, int distanceToDestination, boolean isDelivered) {
            this.num = num;
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
            this.distanceToTaxi = distanceToTaxi;
            this.distanceToDestination = distanceToDestination;
            this.isDelivered = isDelivered;
        }
    }

    private static class Taxi {
        int posX;
        int posY;
        int fuel;

        private Taxi(int posX, int posY, int fuel) {
            this.posX = posX;
            this.posY = posY;
            this.fuel = fuel;
        }
    }
}
