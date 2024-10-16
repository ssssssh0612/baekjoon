package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 틱택토_7682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            int Ocount = 0;
            int Xcount = 0;
            if (str.equals("end")) {
                break;
            }
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == 'O') {
                    Ocount++;
                } else if (ch == 'X') {
                    Xcount++;
                }
            }
            if (Ocount + Xcount == 9) {
                if (Xcount - Ocount == 1) {
                    char[][] graph = makingGraph(str);
                    int[] arr = checking(graph);
                    if (arr[0] == 2) {
                        System.out.println("valid");
                    } else if (arr[0] == 1 && arr[1] == 1) {
                        System.out.println("invalid");
                    } else if (arr[0] == 0 && arr[1] == 1) {
                        System.out.println("invalid");
                    } else if (arr[0] == 1 && arr[1] == 0) {
                        System.out.println("valid");
                    } else if (arr[0] == 0 && arr[1] == 0) {
                        System.out.println("valid");
                    }
                } else {
                    System.out.println("invalid");
                }
            } else if (Ocount + Xcount != 9) {
                if (Xcount - Ocount == 1) {
                    char[][] graph = makingGraph(str);
                    int[] arr = checking(graph);
                    if (arr[0] == 1 && arr[1] == 1) {
                        System.out.println("invalid");
                    } else if (arr[0] == 0 && arr[1] == 1) {
                        System.out.println("invalid");
                    } else if (arr[0] == 1 && arr[1] == 0) {
                        System.out.println("valid");
                    } else if (arr[0] == 0 && arr[1] == 0) {
                        System.out.println("invalid");
                    }
                } else if (Xcount - Ocount == 0) {
                    char[][] graph = makingGraph(str);
                    int[] arr = checking(graph);
                    if (arr[0] == 0 && arr[1] == 0) {
                        System.out.println("invalid");
                    } else if (arr[0] == 1 && arr[1] == 1) {
                        System.out.println("invalid");
                    } else if (arr[0] == 0 && arr[1] == 1) {
                        System.out.println("valid");
                    } else if (arr[0] == 1 && arr[1] == 0) {
                        System.out.println("invalid");
                    }
                } else {
                    System.out.println("invalid");
                }
            }
        }
    }

    public static int[] checking(char[][] graph) {
        int[] arr = new int[2];
        // 0번째는 X카운트
        // 1번째는 O카운트
        for (int i = 0; i < 3; i++) {
            int checkCount1 = 0;
            char ch = graph[i][0];
            if (ch == 'O') {
                for (int j = 1; j < 3; j++) {
                    if (ch == graph[i][j]) {
                        checkCount1++;
                    }
                    if (j == 2 && checkCount1 == 2) {
                        arr[1]++;
                    }
                }
            } else if (ch == 'X') {
                for (int j = 1; j < 3; j++) {
                    if (ch == graph[i][j]) {
                        checkCount1++;
                    }

                    if (j == 2 && checkCount1 == 2) {
                        arr[0]++;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            char ch = graph[0][i];
            int checkCount2 = 0;
            if (ch == 'O') {
                for (int j = 1; j < 3; j++) {
                    if (ch == graph[j][i]) {
                        checkCount2++;
                    }
                    if (j == 2 && checkCount2 == 2) {
                        arr[1]++;
                    }
                }
            } else if (ch == 'X') {
                for (int j = 1; j < 3; j++) {
                    if (ch == graph[j][i]) {
                        checkCount2++;
                    }
                    if (j == 2 && checkCount2 == 2) {
                        arr[0]++;
                    }
                }
            }
        }
//        System.out.println(arr[0] + " , " + arr[1]);
        char ch = graph[0][0];
        if (ch == 'O' && graph[1][1] == ch && graph[2][2] == ch) {
            arr[1]++;
        } else if (ch == 'X' && graph[1][1] == ch && graph[2][2] == ch) {
            arr[0]++;
        }
//        System.out.println(arr[0] + " , " + arr[1]);

        char ch1 = graph[0][2];
        if (ch1 == 'O' && graph[1][1] == ch1 && graph[2][0] == ch1) {
            arr[1]++;
        } else if (ch1 == 'X' && graph[1][1] == ch1 && graph[2][0] == ch1) {
            arr[0]++;
        }

//        System.out.println(arr[0] + " , " + arr[1]);
        return arr;
    }


    public static char[][] makingGraph(String str) {
        char[][] graph = new char[3][3];
        for (int i = 0; i < 9; i++) {
            char ch = str.charAt(i);
            if (i == 0) {
                graph[0][0] = ch;
            } else if (i == 1) {
                graph[0][1] = ch;
            } else if (i == 2) {
                graph[0][2] = ch;
            } else if (i == 3) {
                graph[1][0] = ch;
            } else if (i == 4) {
                graph[1][1] = ch;
            } else if (i == 5) {
                graph[1][2] = ch;
            } else if (i == 6) {
                graph[2][0] = ch;
            } else if (i == 7) {
                graph[2][1] = ch;
            } else if (i == 8) {
                graph[2][2] = ch;
            }
        }
        return graph;
    }
}