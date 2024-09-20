package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 테트로미노_14500 {
    static int y;
    static int x;
    static int[][] graph;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                stick(i,j);
                rectangle(i,j);
                shapeL(i,j);
                fuck(i,j);
                shapeS(i,j);
            }
        }
        System.out.println(result);
    }
    // 1 자 테트로미노
    public static void stick(int y , int x){
        // 1자 일 경우
        List<int[]> shape1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            shape1.add(new int[]{y+i,x});
        }
        resultChecking(shape1);
        // 누운 1자 일 경우

        List<int[]> shape2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            shape2.add(new int[]{y,x+i});
        }
        resultChecking(shape2);
    }


    public static boolean checking(List<int []> checkingList){
        int count = 0 ;
        for (int i = 0; i < 4; i++) {
            if(checkingList.get(i)[0] >= 0 &&  checkingList.get(i)[0] < y &&
            checkingList.get(i)[1] >= 0 && checkingList.get(i)[1] < x){
                count++;
            }
        }
        return count == checkingList.size();
    }
    public static void resultChecking(List<int[]> checking){
        int checkingResult = 0;
//        int[][] newGraph = new int[y][x];


        if(checking(checking)){
            for (int i = 0; i < 4; i++) {
                checkingResult += graph[checking.get(i)[0]][checking.get(i)[1]];
//                newGraph[checking.get(i)[0]][checking.get(i)[1]] = 1;
            }
        }
        result = Math.max(checkingResult,result);
//        System.out.println();
//        for (int i = 0; i < y; i++) {
//            for (int j = 0; j < x; j++) {
//                System.out.print(newGraph[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("checking result: " + checkingResult);
//        System.out.println("result: " + result);


    }



    // 네모 테트로미노
    public static void rectangle(int y, int x){
        List<int[]> rectangle = new ArrayList<>();
        rectangle.add(new int[]{y,x});
        rectangle.add(new int[]{y,x+1});
        rectangle.add(new int[]{y+1,x});
        rectangle.add(new int[]{y+1,x+1});
        resultChecking(rectangle);
    }
    // L 자 테트로미노
    public static void shapeL(int y, int x){
        // 서있는 L
        List<int[]> shapeL1 = new ArrayList<>();
        shapeL1.add(new int[]{y,x});
        shapeL1.add(new int[]{y+1,x});
        shapeL1.add(new int[]{y+2,x});
        shapeL1.add(new int[]{y+2,x+1});
        resultChecking(shapeL1);

        List<int[]> shapeL2 = new ArrayList<>();
        shapeL2.add(new int[]{y,x});
        shapeL2.add(new int[]{y+1,x});
        shapeL2.add(new int[]{y+2,x});
        shapeL2.add(new int[]{y+2,x-1});
        resultChecking(shapeL2);

        List<int[]> shapeL3 = new ArrayList<>();
        shapeL3.add(new int[]{y,x});
        shapeL3.add(new int[]{y,x+1});
        shapeL3.add(new int[]{y,x+2});
        shapeL3.add(new int[]{y+1,x});
        resultChecking(shapeL3);


        List<int[]> shapeL4 = new ArrayList<>();
        shapeL4.add(new int[]{y,x});
        shapeL4.add(new int[]{y,x+1});
        shapeL4.add(new int[]{y,x+2});
        shapeL4.add(new int[]{y+1,x+2});
        resultChecking(shapeL4);

        List<int[]> shapeL5 = new ArrayList<>();
        shapeL5.add(new int[]{y,x});
        shapeL5.add(new int[]{y+1,x});
        shapeL5.add(new int[]{y+1,x+1});
        shapeL5.add(new int[]{y+1,x+2});
        resultChecking(shapeL5);

        List<int[]> shapeL6 = new ArrayList<>();
        shapeL6.add(new int[]{y,x});
        shapeL6.add(new int[]{y+1,x});
        shapeL6.add(new int[]{y+1,x-1});
        shapeL6.add(new int[]{y+1,x-2});
        resultChecking(shapeL6);

        List<int[]> shapeL7 = new ArrayList<>();
        shapeL7.add(new int[]{y,x});
        shapeL7.add(new int[]{y,x+1});
        shapeL7.add(new int[]{y+1,x+1});
        shapeL7.add(new int[]{y+2,x+1});
        resultChecking(shapeL7);

        List<int[]> shapeL8 = new ArrayList<>();
        shapeL8.add(new int[]{y,x});
        shapeL8.add(new int[]{y,x-1});
        shapeL8.add(new int[]{y+1,x-1});
        shapeL8.add(new int[]{y+2,x-1});
        resultChecking(shapeL8);
    }
    // S 자 테트로미노
    public static void shapeS(int y, int x){
        List<int[]> shapeL1 = new ArrayList<>();
        shapeL1.add(new int[]{y,x});
        shapeL1.add(new int[]{y+1,x});
        shapeL1.add(new int[]{y+1,x+1});
        shapeL1.add(new int[]{y+2,x+1});
        resultChecking(shapeL1);

        List<int[]> shapeL2 = new ArrayList<>();
        shapeL2.add(new int[]{y,x});
        shapeL2.add(new int[]{y+1,x});
        shapeL2.add(new int[]{y+1,x-1});
        shapeL2.add(new int[]{y+2,x-1});
        resultChecking(shapeL2);

        List<int[]> shapeL3 = new ArrayList<>();
        shapeL3.add(new int[]{y,x});
        shapeL3.add(new int[]{y,x+1});
        shapeL3.add(new int[]{y+1,x+1});
        shapeL3.add(new int[]{y+1,x+2});
        resultChecking(shapeL3);

        List<int[]> shapeL4 = new ArrayList<>();
        shapeL4.add(new int[]{y,x});
        shapeL4.add(new int[]{y,x-1});
        shapeL4.add(new int[]{y+1,x-1});
        shapeL4.add(new int[]{y+1,x-2});
        resultChecking(shapeL4);
    }
    // ㅗ 자 테트로미노
    public static void fuck(int y, int x){
        List<int[]> shapeL1 = new ArrayList<>();
        shapeL1.add(new int[]{y,x});
        shapeL1.add(new int[]{y+1,x});
        shapeL1.add(new int[]{y+1,x+1});
        shapeL1.add(new int[]{y+1,x-1});
        resultChecking(shapeL1);

        List<int[]> shapeL2 = new ArrayList<>();
        shapeL2.add(new int[]{y,x});
        shapeL2.add(new int[]{y+1,x});
        shapeL2.add(new int[]{y+1,x+1});
        shapeL2.add(new int[]{y+2,x});
        resultChecking(shapeL2);

        List<int[]> shapeL3 = new ArrayList<>();
        shapeL3.add(new int[]{y,x});
        shapeL3.add(new int[]{y+1,x-1});
        shapeL3.add(new int[]{y+1,x});
        shapeL3.add(new int[]{y+2,x});
        resultChecking(shapeL3);

        List<int[]> shapeL4 = new ArrayList<>();
        shapeL4.add(new int[]{y,x});
        shapeL4.add(new int[]{y,x+1});
        shapeL4.add(new int[]{y,x+2});
        shapeL4.add(new int[]{y+1,x+1});
        resultChecking(shapeL4);
    }
}
