package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 비밀번호발음하기_4659 {
    static boolean[] visited = new boolean[256];

    public static void main(String[] args) throws IOException {
        //모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
        //모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
        //같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 'a';
        int e = 'e';
        int i = 'i';
        int o = 'o';
        int u = 'u';
        visited[a] = true;
        visited[e] = true;
        visited[i] = true;
        visited[o] = true;
        visited[u] = true;
        while (true) {
            String str = br.readLine();
            if(str.equals("end")){
                break;
            }
            //<a> is acceptable.
            if (!checking1(str)) {
                System.out.println("<" + str + ">" + " is not acceptable.");
                continue;
            }
            if (!checking2(str) && str.length() >= 3) {
                System.out.println("<" + str + ">" + " is not acceptable.");
                continue;
            }
            if (!checking3(str)) {
                System.out.println("<" + str + ">" + " is not acceptable.");
                continue;
            }
            System.out.println("<" + str + ">" + " is acceptable.");
        }
    }

    public static boolean checking3(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            if (ch != 'e' && ch != 'o') {
                if (ch == str.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checking2(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            int num1 = str.charAt(i);
            int num2 = str.charAt(i + 1);
            int num3 = str.charAt(i + 2);
            if (visited[num1] && visited[num2] && visited[num3]) {
                return false;
            } else if (!visited[num1] && !visited[num2] && !visited[num3]) {
                return false;
            }
        }
        return true;
    }

    public static boolean checking1(String str) {
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i);
            if (visited[ch]) {
                return true;
            }
        }
        return false;
    }
}
