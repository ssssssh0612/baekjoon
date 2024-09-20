package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 마법사_상어와_파이어볼_20056 {
    // N M K
    static int n;
    static int[][] graph;
    static int time;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static List<int[]> fireBalls = new ArrayList<>();
    static int[] oddEven = {0, 2, 4, 6};
    static int[] notOddEven = {1, 3, 5, 7};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int fireBallCount = sc.nextInt();
        time = sc.nextInt();
        graph = new int[n][n];
        //모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
        //이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
        //이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
        //같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
        //파이어볼은 4개의 파이어볼로 나누어진다.
        //나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.


        //질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
        //속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
        //합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
        //질량이 0인 파이어볼은 소멸되어 없어진다.
        // 번 파이어볼의 위치는 (ri, ci), 질량은 mi이고, 방향은 di, 속력은 si이다. 위치 (r, c)는 r행 c열을 의미한다.


        // 파이어볼 입력받음
        for (int i = 0; i < fireBallCount; i++) {
            // 자신의 방향으로 속력만큼 이동
            // y, x, 질량, 방향, 속력
            fireBalls.add(new int[]{sc.nextInt()-1, sc.nextInt()-1, sc.nextInt(), sc.nextInt(), sc.nextInt()});
        }

        for (int i = 0; i < time; i++) {
            // 파이어볼 이동
            for (int j = 0; j < fireBalls.size(); j++) {
                moveFireBall(fireBalls.get(j));
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (graph[j][k] >= 2) {
                        List<int[]> newFireballs = new ArrayList<>();
                        int weight = 0;
                        int vector = 0;
                        int odd = 0;
                        int even = 0;
                        for (int l = fireBalls.size() - 1; l >= 0; l--) {
                            if (fireBalls.get(l)[0] == j && fireBalls.get(l)[1] == k) {
                                newFireballs.add(fireBalls.get(l));
                                fireBalls.remove(l);
                            }
                        }

                        for (int l = 0; l < newFireballs.size(); l++) {
                            weight += newFireballs.get(l)[2];
                            vector += newFireballs.get(l)[3];
                            if (newFireballs.get(l)[4] % 2 == 0) {
                                // 홀수
                                odd++;
                            } else if (newFireballs.get(l)[4] % 2 == 1) {
                                // 짝수
                                even++;
                            }
                        }
                        if(weight/5 != 0){
                            if (odd == newFireballs.size() || even == newFireballs.size()) {
                                // 0, 2, 4, 6
                                for (int l = 0; l < 4; l++) {

                                    fireBalls.add(new int[]{j, k, weight / 5, vector / newFireballs.size(), oddEven[l]});
                                }

                            } else {
                                // 1, 3, 5, 7
                                for (int l = 0; l < 4; l++) {
                                    fireBalls.add(new int[]{j, k, weight / 5, vector / newFireballs.size(), notOddEven[l]});
                                }
                            }
                        }
                    }
                }
            }

            fireBallCountReset();
        }
        int result = 0;
        for (int i = 0; i < fireBalls.size(); i++) {
            result = result + fireBalls.get(i)[2];
        }
        System.out.println(result);
    }

    public static void moveFireBall(int[] fireBall) {
        // 3 속력 , 4 방향
        for (int i = 0; i < fireBall[3]; i++) {
            int nowY = fireBall[0] + dy[fireBall[4]];
            int nowX = fireBall[1] + dx[fireBall[4]];
            fireBall[0] = numberChecking(nowY);
            fireBall[1] = numberChecking(nowX);
        }
        graph[fireBall[0]][fireBall[1]] = graph[fireBall[0]][fireBall[1]] + 1;
    }

    public static void fireBallCountReset() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = 0;
            }
        }
    }

    public static int numberChecking(int number) {
        if (number < 0) {
            number = n + number;
            return number;
        } else if (number >= n) {
            number = number - n;
            return number;
        } else {
            return number;
        }
    }

    public static void checkingGraph(){
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}