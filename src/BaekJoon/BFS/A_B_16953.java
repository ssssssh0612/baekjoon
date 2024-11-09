package BaekJoon.BFS;

// 11시 04분 시작

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A_B_16953 {
    //정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
    //2를 곱한다.
    //1을 수의 가장 오른쪽에 추가한다.
    //A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
    static int startNum;
    static int endNum;
    static boolean[] visited;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        bfs();
        if (!flag) {
            System.out.println(-1);
        }
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        startNum = Integer.parseInt(st.nextToken());
        endNum = Integer.parseInt(st.nextToken());
        visited = new boolean[1000000001];
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{addNumber(startNum), 1});
        queue.add(new int[]{startNum * 2, 1});
        if(checking(startNum * 2)){
            visited[startNum * 2] = true;
        }
        if(checking(addNumber(startNum))){
            visited[addNumber(startNum)] = true;
        }
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            System.out.println(now[0]);
            if (now[0] == endNum) {
                flag = true;
                System.out.println(now[1] + 1);
                return;
            }
            int nextNum = now[0] * 2;
            int nextNum2 = addNumber(now[0]);
            if (checking(nextNum) && !visited[nextNum]) {
                queue.add(new int[]{now[0] * 2, now[1] + 1});
                visited[nextNum] = true;
            }
            if (checking(nextNum2) && !visited[nextNum2]) {
                queue.add(new int[]{nextNum2, now[1] + 1});
                visited[nextNum2] = true;
            }
        }
    }

    public static boolean checking(int number) {
        return number >= 0 && number < 100000001;
    }

    public static int addNumber(int number) {
        String str = number + "1";
        int returnNumber = 1;
        int index = str.length() - 1;
        for (int i = 0; i < str.length() - 1; i++) {
            int checkingNumber = str.charAt(i) - '0';
            returnNumber += checkingNumber * numberX(index);
            index--;
        }
        return returnNumber;
    }

    public static int numberX(int number) {
        if (number == 0) {
            return 1;
        }
        return 10 * numberX(number - 1);
    }
}
