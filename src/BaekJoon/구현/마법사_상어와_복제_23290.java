package BaekJoon.구현;

import java.util.ArrayList;
import java.util.Scanner;


public class 마법사_상어와_복제_23290 {
    public class Fish{
        int y;
        int x;
        int[] dir = new int[8];
        int smell;
        Fish(){

        }
    }
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int[][]graph;
    static ArrayList<Fish>[][] fishGraph;
    static ArrayList<Fish>[][] smellGraph;
    static int[] sharkPos = new int[2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        graph = new int[4][4];
        fishGraph = new ArrayList[4][4];
        smellGraph = new ArrayList[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                fishGraph[i][j] = new ArrayList<>();
                smellGraph[i][j] = new ArrayList<>();
            }
        }
        int fishCount = sc.nextInt();
        int practice = sc.nextInt();
        for (int i = 0; i < fishCount; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
//            fishGraph[y][x].add(sc.nextInt() - 1);
        }
        sharkPos[0] = sc.nextInt() - 1;
        sharkPos[1] = sc.nextInt() - 1;
        System.out.println(sharkPos[0]+" "+sharkPos[1]);
        for (int i = 0; i < practice; i++) {
            // 복제 마법 시작
//            ArrayList<Integer>[][] copySharkGraph = fishGraph.clone();
        }
        movingFish();
    }
    public static void movingFish(){

    }
    public static boolean checking(int y, int x){
        return y>=0 && y < 4 && x >= 0 && x < 4 && smellGraph[y][x].isEmpty() && (sharkPos[0] != y || sharkPos[1] != x);
    }

    public static void checkingFish(ArrayList<Integer>[][] list){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(list[i][j].isEmpty()){
                    System.out.print("0");
                }else{
                    for (int k = 0; k < list[i][j].size(); k++) {
                        System.out.print(list[i][j].get(k));
                    }
                }
            }
            System.out.println();
        }
    }
    public static void checkingCopyFish(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
            }
        }
    }
}

