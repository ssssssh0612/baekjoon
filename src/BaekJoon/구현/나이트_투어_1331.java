package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 나이트_투어_1331 {
    static boolean[][] visited = new boolean[8][8];
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static List<int[]> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();

        List<Integer> yList = new ArrayList<>();
        List<Integer> xList = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < 36; i++) {
            String a = sc.nextLine();
            for (int j = 0; j < 2; j++) {
                if (a.charAt(j) == '1') {
                    yList.add(6);
                } else if (a.charAt(j) == '2') {
                    yList.add(5);
                } else if (a.charAt(j) == '3') {
                    yList.add(4);
                } else if (a.charAt(j) == '4') {
                    yList.add(3);
                } else if (a.charAt(j) == '5') {
                    yList.add(2);
                } else if (a.charAt(j) == '6') {
                    yList.add(1);
                } else if (a.charAt(j) == 'A') {
                    xList.add(1);
                } else if (a.charAt(j) == 'B') {
                    xList.add(2);
                } else if (a.charAt(j) == 'C') {
                    xList.add(3);
                } else if (a.charAt(j) == 'D') {
                    xList.add(4);
                } else if (a.charAt(j) == 'E') {
                    xList.add(5);
                } else if (a.charAt(j) == 'F') {
                    xList.add(6);
                }
            }
        }
        for (int i = 0; i < 36; i++) {
            list.add(new int[]{yList.get(i), xList.get(i)});
        }
        for (int i = 1; i < list.size(); i++) {
            if (!visited[list.get(i)[0]][list.get(i)[1]] && valid(i)) {
                visited[list.get(i)[0]][list.get(i)[1]] = true;
            } else {
                flag = false;
                System.out.println("Invalid");
                return;
            }
        }


        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (list.get(0)[0] + dy[i] >= 1 && list.get(0)[1] + dx[i] >= 1
                    && list.get(0)[0] + dy[i] < 7 && list.get(0)[1] + dx[i] < 7) {
                if (list.get(0)[0] + dy[i] == list.get(list.size() - 1)[0] && list.get(0)[1] + dx[i] == list.get(list.size() - 1)[1]) {
                    break;
                } else {
                    count++;
                }
            } else {
                count++;
            }
        }
        if (count == 8) {
            flag = false;
        }
        if (flag) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    public static boolean valid(int index) {
        for (int i = 0; i < 8; i++) {
            if (list.get(index -1)[0] + dy[i] >= 1 && list.get(index -1)[1] + dx[i] >= 1
                    && list.get(index -1)[0] + dy[i] < 7 && list.get(index -1)[1] + dx[i] < 7) {
                if (list.get(index-1)[0] + dy[i] == list.get(index)[0] &&
                        list.get(index-1)[1] + dx[i] == list.get(index)[1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
