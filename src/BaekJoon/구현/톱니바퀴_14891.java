package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class 톱니바퀴_14891 {
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> list4 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] visited;
        for (int i = 0; i < 4; i++) {
            String a = sc.nextLine();
            for (int j = 0; j < a.length(); j++) {
                if (i == 0) {
                    list1.add(Integer.parseInt(a.charAt(j) + ""));
                } else if (i == 1) {
                    list2.add(Integer.parseInt(a.charAt(j) + ""));
                } else if (i == 2) {
                    list3.add(Integer.parseInt(a.charAt(j) + ""));
                } else {
                    list4.add(Integer.parseInt(a.charAt(j) + ""));
                }
            }
        }

//        for (int i = 0; i < 8; i++) {
//            System.out.print(list1.get(i) + " ");
//        }
//
//        System.out.println();
//        for (int i = 0; i < 8; i++) {
//            System.out.print(list1.get(i) + " ");
//        }

//        list1.add(0, list1.get(7));
//        list1.remove(7);
//        list1.add(7, list1.get(0));
//        list1.remove(0);
//        for (int i = 0; i < 8; i++) {
//            System.out.print(list1.get(i) + " ");
//        }
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            visited = new boolean[5];
            int listNumber = sc.nextInt();
            int direction = sc.nextInt();
            topNee(listNumber, direction, visited);
        }
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                System.out.println(list1.get(0));
            } else if (i == 1) {
                System.out.println(list2.get(0));
            } else if (i == 2) {
                System.out.println(list3.get(0));
            } else {
                System.out.println(list4.get(0));
            }
        }
    }

    public static void topNee(int listNumber, int direction, boolean[] visited) {
        // 시계방향으로 돌리는 로직
//        list1.add(0,list1.get(7));
//        list1.remove(7);
        // 반시계 방향으로 돌리는 로직
//        list1.add(7,list1.get(0));
//        list1.remove(0);
        visited[listNumber] = true;
        if (listNumber == 1 || listNumber == 4) {
            if (listNumber == 1) {
                if (direction == 1) {
                    list1.add(0, list1.get(7));
                    list1.remove(7);
                    if (!Objects.equals(list1.get(2), list2.get(6)) && !visited[2]) {
                        topNee(2, -1, visited);
                    }
                } else {
                    list1.add(7, list1.get(0));
                    list1.remove(0);
                    if (!Objects.equals(list1.get(2), list2.get(6)) && !visited[2]) {
                        topNee(2, 1, visited);
                    }
                }
            } else if (listNumber == 4) {
                if (direction == 1) {
                    list4.add(0, list4.get(7));
                    list4.remove(7);
                    if (!Objects.equals(list4.get(6), list3.get(2)) && !visited[3]) {
                        topNee(3, -1, visited);
                    }
                } else {
                    list4.add(7, list4.get(0));
                    list4.remove(0);
                    if (!Objects.equals(list4.get(6), list3.get(2)) && !visited[3]) {
                        topNee(3, 1, visited);
                    }
                }
            }
        } else {
            if (listNumber == 2) {
                if (direction == 1) {
                    list2.add(0, list2.get(7));
                    list2.remove(7);
                    if (!Objects.equals(list2.get(6), list1.get(2)) && !Objects.equals(list2.get(2), list3.get(6))
                            && !visited[1] && !visited[3]) {
                        topNee(1, -1, visited);
                        topNee(3, -1, visited);
                    } else if (!Objects.equals(list2.get(6), list1.get(2)) && !visited[1]) {
                        topNee(1, -1, visited);
                    } else if (!Objects.equals(list2.get(2), list3.get(6)) && !visited[3]) {
                        topNee(3, -1, visited);
                    }

                } else {
                    list2.add(7, list2.get(0));
                    list2.remove(0);
                    if (!Objects.equals(list2.get(6), list1.get(2)) && !Objects.equals(list2.get(2), list3.get(6))
                            && !visited[1] && !visited[3]) {
                        topNee(1, 1, visited);
                        topNee(3, 1, visited);
                    } else if (!Objects.equals(list2.get(6), list1.get(2)) && !visited[1]) {
                        topNee(1, 1, visited);
                    } else if (!Objects.equals(list2.get(2), list3.get(2)) && !visited[3]) {
                        topNee(3, 1, visited);
                    }

                }

            } else if (listNumber == 3) {
                if (direction == 1) {
                    list3.add(0, list3.get(7));
                    list3.remove(7);
                    if (!Objects.equals(list3.get(6), list2.get(2)) && !Objects.equals(list3.get(2), list4.get(6))
                            && !visited[2] && !visited[4]) {
                        topNee(2, -1, visited);
                        topNee(4, -1, visited);
                    } else if (!Objects.equals(list3.get(6), list2.get(2)) && !visited[2]) {
                        topNee(2, -1, visited);
                    } else if (!Objects.equals(list3.get(2), list4.get(6)) && !visited[4]) {
                        topNee(4, -1, visited);
                    }
                } else {
                    list3.add(7, list3.get(0));
                    list3.remove(0);
                    if (!Objects.equals(list3.get(6), list2.get(2)) && !Objects.equals(list3.get(2), list4.get(6))
                            && !visited[2] && !visited[4]) {
                        topNee(2, 1, visited);
                        topNee(4, 1, visited);
                    } else if (!Objects.equals(list3.get(6), list2.get(2)) && !visited[2]) {
                        topNee(2, 1, visited);
                    } else if (!Objects.equals(list3.get(2), list4.get(6)) && !visited[4]) {
                        topNee(4, 1, visited);
                    }
                }
            }
        }
    }
}
