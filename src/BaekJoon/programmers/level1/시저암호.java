package BaekJoon.programmers.level1;

public class 시저암호 {
    public String solution(String s, int n) {
        // 대문자
        char[] arr1 = new char[26];
        // 소문자
        char[] arr2 = new char[26];

        for (int i = 0; i <= 25; i++) {
            arr1[i] = (char) (i + 65);
        }

        for (int i = 0; i <= 25; i++) {
            arr2[i] = (char) (i + 97);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((int) ch >= 97) {
                int index = (((int) ch - 97) + n) % 26;
                sb.append(arr2[index]);
            } else if (ch == ' ') {
                sb.append(" ");
            } else {
                int index = (((int) ch - 65) + n) % 26;
                sb.append(arr1[index]);
            }
        }

        return sb.toString();
    }
}
