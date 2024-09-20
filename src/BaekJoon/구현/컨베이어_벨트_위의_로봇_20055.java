package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 컨베이어_벨트_위의_로봇_20055 {
    static int count;
    static boolean flag;
    static int resultCount;
    static int result;

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<int[]>();
        // 0 == 현재 내구도 , 1 == 로봇의 유무 0 존재 x 1 존재
        count = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        result = sc.nextInt();
        flag = true;

        for (int i = 0; i < n * 2; i++) {
            list.add(new int[]{sc.nextInt(), 0});
        }


        while (flag) {
//    벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
//    가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
//    로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
//    올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
//    내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.


            // 컨베이어벨트 한칸 돌리기
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            if (list.get(list.size() / 2 - 1)[1] == 1) {
                list.get(list.size() / 2 - 1)[1] = 0;
            }

            // 컨베이어 벨트에 올라간 로봇부터 회전하기
//            List<Integer> robotIndex = new ArrayList<>();
            if (list.get(list.size() / 2 - 2)[1] == 1 &&
                    list.get(list.size() / 2 - 1)[0] > 0 &&
                    list.get(list.size() / 2 - 1)[1] == 0) {
                // 현재 위치의 로봇을 없애고,
                list.get(list.size() / 2 - 2)[1] = 0;
                // 이동할 위치의 내구도를 낮추기
                list.get(list.size() / 2 - 1)[0] = list.get(list.size() / 2 - 1)[0] - 1;
                // 어차피 n 자리는 로봇이 바로 사라지기때문에 로봇을 둘 필요가 없음
            }
            for (int i = list.size()/2 - 2; i >= 0; i--) {
                if (list.get(i + 1)[0] > 0 &&
                        list.get(i + 1)[1] == 0 &&
                        list.get(i)[1] == 1) {
                    // 현재 위치에 로봇을 없애고
                    list.get(i)[1] = 0;
                    // 이동할 위치의 내구도를 낮추고
                    list.get(i + 1)[0] = list.get(i + 1)[0] - 1;
                    // 이동할 위치의 로봇 놓기
                    list.get(i + 1)[1] = 1;
                }
            }
            // 로봇 올리기
            // 내구도가 0보다 커야하고
            // 현재 위치에 로봇이 존재하면 안됨
            if (list.get(0)[0] > 0 && list.get(0)[1] == 0) {
                list.get(0)[0] = list.get(0)[0] - 1;
                list.get(0)[1] = 1;
            }

            for (int[] ints : list) {
                if (ints[0] == 0) {
                    resultCount++;
                }
            }
            if (resultCount >= result) {
                flag = false;
            }
            resultCount = 0;
            count++; // 단계
        }

        System.out.println(count);

    }
}
