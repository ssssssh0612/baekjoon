package BaekJoon.DFS;

import java.util.ArrayList;
import java.util.List;

public class 주사위_굴리기_2_23288 {
    static int score = 0;
    // 주사위
    static List<Integer> block = new ArrayList<>();
    static int[] LR = {0,2,4,5};
    static int[] UD = {1,2,3,5};
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int dir = 4;
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int y = sc.nextInt();
//        int x = sc.nextInt();
//        int testCase = sc.nextInt();
        block.add(4);
        block.add(2);
        block.add(1);
        block.add(5);
        block.add(3);
        block.add(6);
        동쪽회전(block);
        for (int i = 0; i < block.size(); i++) {
            System.out.print(block.get(i) + " ");
        }
        System.out.println();
//        for (int i = 0; i < testCase; i++) {
//
//        }
    }
    // 0 2 4 5 인덱스 차례로 옮기기
    // 오른쪽으로 옮기는게 동쪽
    // 왼쪽으로 옮기는게 서쪽
    // 1 2 3 5 인덱스 차례로 옮기기
    // 오른쪽으로 옮기는게 남쪽
    // 왼쪽으로 옮기는게 북쪽
    // 북 남 서 동 순서


    public static void 동쪽회전(List<Integer> block){
        // 0, 2, 4, 5 오른쪽
        int[] memory = new int[4];
        for (int i = 3; i >= 0; i--) {
            memory[LR[3-i]] = block.get(LR[i]);
            System.out.print(memory[i]+"");
            // 0, 2, 4, 5
            // 5, 0, 2, 4
        }
        for (int i = 0; i < 4; i++) {
            block.remove(LR[i]);
            block.add(LR[i], memory[1]);
        }
    }
    public static void 서쪽회전(List<Integer> block){
        // 0, 2, 4, 5 왼쪽

    }
    public static void 남쪽회전(){
        // 1, 2, 3, 5 오른쪽

    }
    public static void 북쪽회전(){
        // 1, 2, 3, 5 왼쪽
    }
}
