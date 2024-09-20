package BaekJoon.구현;

import java.util.*;

public class 이차원_배열과_연산_17140 {
    static int y;
    static int x;
    static int value;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt() - 1;
        x = sc.nextInt() - 1;
        value = sc.nextInt();
        graph = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        boolean flag = true;
        int timeCount = 0;
        while (flag) {
//            System.out.println();
//            for (int i = 0; i < graph.length; i++) {
//                for (int j = 0; j < graph[0].length; j++) {
//                    System.out.print(graph[i][j] + " ");
//                }
//                System.out.println();
//            }
            if (y < graph.length && x < graph[0].length && y >= 0 && x >= 0 && graph[y][x] == value) {
                break;
            }
            if (graph.length >= graph[0].length) {
                // 배열 A의 모든 행에 대해서 정렬수행 행의 갯수 >= 열의 갯수
                arrSortR();
            } else {
                // 배열 A의 모든 열에 대해서 정렬수행 행의 갯수 < 열의 갯수
                arrSortC();
            }
            timeCount++;
            if (timeCount > 100) {
                break;
            }
        }
        if (timeCount == 101) {
            System.out.println(-1);
        } else {
            System.out.println(timeCount);
        }


    }

    public static void arrSortR() {
        List<List<Integer>> finallyList = new ArrayList<>();
        int arrSize = 0;
        for (int i = 0; i < graph.length; i++) {
            List<Integer> list = new ArrayList<>();
            List<int[]> resultList = new ArrayList<>();
            for (int j = 0; j < graph[0].length; j++) {
                list.add(graph[i][j]);
            }
            Collections.sort(list);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) != 0) {
                    if (resultList.isEmpty()) {
                        resultList.add(new int[]{list.get(j), 1});
                    } else {
                        if (list.get(j) != resultList.get(resultList.size() - 1)[0]) {
                            resultList.add(new int[]{list.get(j), 1});
                        } else {
                            resultList.get(resultList.size() - 1)[1]++;
                        }
                    }
                }
            }
            Collections.sort(resultList, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    // 첫 번째 인덱스를 기준으로 오름차순 정렬
                    if (a[0] != b[0]) {
                        return Integer.compare(a[1], b[1]);
                    }
                    // 첫 번째 인덱스가 같으면 두 번째 인덱스를 기준으로 오름차순 정렬
                    return Integer.compare(a[0], b[0]);
                }
            });

            List<Integer> newList = new ArrayList<>();
            if (resultList.size() > 100) {
                for (int j = 0; j < 100; j++) {
                    newList.add(resultList.get(j)[0]);
                    newList.add(resultList.get(j)[1]);
                }
            } else {
                for (int j = 0; j < resultList.size(); j++) {
                    newList.add(resultList.get(j)[0]);
                    newList.add(resultList.get(j)[1]);
                }
            }
            finallyList.add(newList);
            arrSize = Math.max(arrSize, newList.size());
        }
        for (int i = 0; i < finallyList.size(); i++) {
            if (finallyList.get(i).size() < arrSize) {
                int length = (arrSize - finallyList.get(i).size());
                for (int j = 0; j < length; j++) {
                    finallyList.get(i).add(0);
                }
            }
        }
        graph = new int[finallyList.size()][arrSize];
        for (int i = 0; i < finallyList.size(); i++) {
            for (int j = 0; j < arrSize; j++) {
                graph[i][j] = finallyList.get(i).get(j);
            }
        }
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[0].length; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

//        for (int i = 0; i < finallyList.size(); i++) {
//            System.out.println("머야"+(arrSize - finallyList.get(i).size()));
//            if(finallyList.get(i).size() < arrSize){
//                System.out.println("머야"+(arrSize - finallyList.get(i).size()));
        //
//                int length = (arrSize - finallyList.get(i).size());
        // 그냥 for 문안에
        // for (int j = 0; j < arrSize - finallyList.get(i).size(); j++) {
        //                    finallyList.get(i).add(0);
        //}하면 값이 틀림
//                for (int j = 0; j < length; j++) {
//                    finallyList.get(i).add(0);
//                }
    }

    public static void arrSortC() {
        List<List<Integer>> finallyList = new ArrayList<>();
        int arrSize = 0;
        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            List<int[]> resultList = new ArrayList<>();
            for (int j = 0; j < graph.length; j++) {
                list.add(graph[j][i]);
            }
            Collections.sort(list);

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) != 0) {
                    if (resultList.isEmpty()) {
                        resultList.add(new int[]{list.get(j), 1});
                    } else {
                        if (list.get(j) != resultList.get(resultList.size() - 1)[0]) {
                            resultList.add(new int[]{list.get(j), 1});
                        } else {
                            resultList.get(resultList.size() - 1)[1]++;
                        }
                    }
                }
            }
            Collections.sort(resultList, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    // 첫 번째 인덱스를 기준으로 오름차순 정렬
                    if (a[0] != b[0]) {
                        return Integer.compare(a[1], b[1]);
                    }
                    // 첫 번째 인덱스가 같으면 두 번째 인덱스를 기준으로 오름차순 정렬
                    return Integer.compare(a[0], b[0]);
                }
            });
            List<Integer> newList = new ArrayList<>();
            if (resultList.size() > 50) {
                for (int j = 0; j < 50; j++) {
                    newList.add(resultList.get(j)[0]);
                    newList.add(resultList.get(j)[1]);
                }
            } else {
                for (int j = 0; j < resultList.size(); j++) {
                    newList.add(resultList.get(j)[0]);
                    newList.add(resultList.get(j)[1]);
                }
            }
            finallyList.add(newList);
            arrSize = Math.max(arrSize, newList.size());
        }
        for (int i = 0; i < finallyList.size(); i++) {
            if (finallyList.get(i).size() < arrSize) {
                int length = (arrSize - finallyList.get(i).size());
                for (int j = 0; j < length; j++) {
                    finallyList.get(i).add(0);
                }
            }
        }
        graph = new int[arrSize][finallyList.size()];
        for (int i = 0; i < graph[0].length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[j][i] = finallyList.get(i).get(j);
            }
        }
//        for (int i = 0; i < finallyList.size(); i++) {
//            for (int j = 0; j < finallyList.get(i).size(); j++) {
//                System.out.print(finallyList.get(i).get(j)+" ");
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[0].length; j++) {
//                System.out.print(graph[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}
