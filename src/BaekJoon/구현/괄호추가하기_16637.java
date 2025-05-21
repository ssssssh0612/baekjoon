package BaekJoon.구현;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 괄호추가하기_16637 {
    static int ans;
    static ArrayList<Character> ops;
    static ArrayList<Integer> nums;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        ops = new ArrayList<>();
        nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
                continue;
            }
            nums.add(Character.getNumericValue(c));
        }

        ans = Integer.MIN_VALUE;
        DFS(nums.get(0), 0);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 연산
    public static int calc(char op, int n1, int n2) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
        }
        return -1;
    }

    // DFS, 백트래킹 활용.
    public static void DFS(int result, int opIdx) {
        // 주어진 연산자의 개수를 초과하였을 경우.
        if (opIdx >= ops.size()) {
            ans = Math.max(ans, result);
            return;
        }

        // 괄호가 없는 경우
        int res1 = calc(ops.get(opIdx), result, nums.get(opIdx + 1));
        DFS(res1, opIdx + 1);

        // 괄호가 있는 경우
        if (opIdx + 1 < ops.size()) {
            // result의 오른쪽에 있는 값을 연산함.
            int res2 = calc(ops.get(opIdx + 1), nums.get(opIdx + 1), nums.get(opIdx + 2));

            // 현재 result와 방금 구한 괄호 값을 연산한 결과와 괄호 오른쪽에 존재하는 연산자의 인덱스를 넘김.
            DFS(calc(ops.get(opIdx), result, res2), opIdx + 2);
        }
    }

}

//    static int result =  0;
//    static String str ;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int length = Integer.parseInt(br.readLine());
//        str = br.readLine();
//
//        checking(0, str);
//        System.out.println(result);
//    }
//    public static void checking(int index, String newStr){
//        if(index >= newStr.length()){
//            // 종료해야함
//            result = Math.max(result, calc(newStr));
//            return;
//        }
//        // 현재 문자열에서 계산할래 아니면 넘길래
//
//        int newIndex = index + 2;
//        // 계산 가능하면 계산하고, 계산 불가능하면 넘기기
//        if(newIndex < newStr.length()){
//            // 계산 가능한 상태
//            int addNum = calc(newStr.charAt(index) - '0' ,
//                    newStr.charAt(index+2) - '0', newStr.charAt(index+1));
//            StringBuilder sb = new StringBuilder();
//            for(int i = 0 ; i < index; i++){
//                sb.append(newStr.charAt(i));
//            }
//            sb.append(addNum);
//            for(int i = index + 3; i < newStr.length(); i++){
//                sb.append(newStr.charAt(i));
//            }
//            checking(index + 3, sb.toString());
//        }
//
//
//        // 넘기기
//        checking(index + 2, newStr);
//    }
//    public static int calc(String newStr){
//        // 음수인지 아닌지는 어떻게 판별하지 ?
//        System.out.println("====="+newStr+"=====");
//        StringTokenizer st = new StringTokenizer(newStr, "-+*");
//        while(st.hasMoreTokens()){
//            System.out.println(st.nextToken());
//        }
//        return 0;
//    }
//
//    public static int calc(int num1, int num2, char ch){
//        if(ch == '+'){
//            return num1 + num2;
//        }else if(ch == '-'){
//            return num1 - num2;
//        }else if(ch == '*'){
//            return num1 * num2;
//        }
//        return '0';
//    }

